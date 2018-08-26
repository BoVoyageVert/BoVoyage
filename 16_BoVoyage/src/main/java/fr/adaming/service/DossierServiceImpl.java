package fr.adaming.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IDossierDao;
import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Voyage;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {

	/** Transformation de l'association UML en Java */
	private IDossierDao dossierDao;

	/** Setter pour l'injection dépendance */
	@Autowired
	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
	}
	
	//association avec ligne de commande + setter
	@Autowired
	private ILigneCommandeDao lcDao;
	
	public void setLcDao(ILigneCommandeDao lcDao) {
		this.lcDao = lcDao;
	}

	@Override
	public DossierVoyage addDossier(DossierVoyage dv, Voyage v, Client cl) {
		// lier les objets java
		dv.setVoyage(v);
		dv.setClient(cl);

		return dossierDao.addDossier(dv);
	}

	@Override
	public DossierVoyage updateDossier(DossierVoyage dv, Voyage v, Client cl) {

		dv.setVoyage(v);
		dv.setClient(cl);

		return dossierDao.updateDossier(dv);
	}

	@Override
	public DossierVoyage deleteDossier(DossierVoyage dv, Voyage v, Client cl) {

		dv.setVoyage(v);
		dv.setClient(cl);

		return dossierDao.deleteDossier(dv);
	}

	@Override
	public DossierVoyage getDossierById(DossierVoyage dv, Voyage v, Client cl) {
		dv.setVoyage(v);
		dv.setClient(cl);
		return dossierDao.getDossierById(dv);
	}

	@Override
	public DossierVoyage getDossierByNum(DossierVoyage dv, Voyage v, Client cl) {
		dv.setVoyage(v);
		dv.setClient(cl);
		return dossierDao.getDossierByNum(dv);
	}

	@Override
	public List<DossierVoyage> getAllDossier(Voyage v, Client cl) {
		return dossierDao.getAllDossier(v, cl);
	}

	@Override
	public void sendMail(DossierVoyage dv, Voyage v) {
		// mon compte gmail (pour recevoir les messages)
		final String username = "bauchemin.c@gmail.com";
		final String password = "geol220891";

		// les propriétées
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// recuperer ma session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			// creer l'objet message MimeMessage
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(dv.getClient().getMail()));

			// Set Subject: header du message
			message.setSubject("Mail facture");

			ByteArrayOutputStream outputStream = null;

			// Partie 1: Le texte
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText("Cher(e) Client(e)" + dv.getClient().getNom() + " " + dv.getClient().getPrenom() + ";"
					+ "\n\n Merci de votre confiance!" + "\n Vous trouverez ci-joint la facture de votre séjour"
					+ "\n n° de dossier:" + dv.getNumDossier() + "\n Dates du sejour:" + "\n Date d'arrivée: "
					+ v.getDateArrivee() + "\n Date de départ: " + v.getDateDepart()
					+ "\n\n\n Tout l'équipe d'Amandine, J-D, Steven et Claire espère vous revoir bientôt sur leur site!");

			// ecrire le pdf dans outputStream
			outputStream = new ByteArrayOutputStream();
			LigneCommande lc = new LigneCommande();
			writePdf(outputStream, dv, lc);
			byte[] bytes = outputStream.toByteArray();

			// construire le pdf
			DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
			MimeBodyPart pdfbp = new MimeBodyPart();
			pdfbp.setDataHandler(new DataHandler(dataSource));
			pdfbp.setFileName("facture.pdf");

			// On regroupe les deux dans le message
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(pdfbp);
			message.setContent(mp);

			// on envoie le message
			Transport.send(message);

			System.out.println("message envoyé! c'est ok!!");// verifier si
																// ca a reussi

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	// ecrire le pdf (using iText API)

	@SuppressWarnings("unchecked")
	public void writePdf(ByteArrayOutputStream outputStream, DossierVoyage dv, LigneCommande lc) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);

		// ouvrir le document
		document.open();

		// données du document
		document.addTitle("Facture PDF");
		document.addSubject("Testing email PDF");
		document.addKeywords("iText, email");
		document.addAuthor("Steven, Amandine, J-D et Claire");
		document.addCreator("Steven, Amandine, J-D et Claire");

		// récup de la liste des lignes commandes associées à la reservation
		 List<LigneCommande> liste = (List<LigneCommande>) lcDao.getLigneCommandeById(lc);

		// calcul du prix total =
		 Double d = 0.0;
		 for (LigneCommande lc1 : liste) {
		 d += lc1.getPrixNormal();
		 }

		// composition du pdf

		Image img = Image.getInstance(getClass().getClassLoader().getResource("logoPDF.png"));
		document.add(img);

		Paragraph paragraph = new Paragraph();
		paragraph.add(
				new Chunk("\n\n Cher(e) Mr(Mme) " + dv.getClient().getNom() + " " + dv.getClient().getPrenom() + ";"));
		document.add(paragraph);

		Paragraph paragraph1 = new Paragraph();
		paragraph1.add(new Chunk("\n n° de dossier:" + dv.getNumDossier() + "\n Statut de votre dossier: "
				+ dv.getStatut() + "\n\n voici le recapitulatif de votre facture:\n\n"));
		document.add(paragraph1);

		 // On créer un objet table dans lequel on intialise ça taille.
		 PdfPTable table = new PdfPTable(5);
		 // ajout des cellules entêtes
		 Font f = new Font(FontFamily.HELVETICA, 15, Font.BOLD,
		 GrayColor.BLACK);
		 PdfPCell cell = new PdfPCell(new Phrase("type de prestation", f));
		 cell.setBackgroundColor(GrayColor.LIGHT_GRAY);
		 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.addCell(cell);
		 PdfPCell cell1 = new PdfPCell(new Phrase("Designation", f));
		 cell1.setBackgroundColor(GrayColor.LIGHT_GRAY);
		 cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.addCell(cell1);
		 PdfPCell cell2 = new PdfPCell(new Phrase("Prix normal", f));
		 cell2.setBackgroundColor(GrayColor.LIGHT_GRAY);
		 cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.addCell(cell2);
		 PdfPCell cell3 = new PdfPCell(new Phrase("Promotion", f));
		 cell3.setBackgroundColor(GrayColor.LIGHT_GRAY);
		 cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.addCell(cell3);
		 PdfPCell cell4 = new PdfPCell(new Phrase("Quantité", f));
		 cell4.setBackgroundColor(GrayColor.LIGHT_GRAY);
		 cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.addCell(cell4);

		 //Creation du recapitulatif de la commande
		 for (LigneCommande lc1 : liste ) {
		
		 // on ajoute les cellules
		 table.addCell(lc1.getTypePrestation());
		 table.addCell(lc1.getDesignation());
		 table.addCell(lc1.getPrixNormal()+" € ");
		 table.addCell(lc1.getPrixPromotion() +"€ ");
		 table.addCell(lc1.getQuantite()+"");
		
		 }
		 document.add(table);

		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(new Chunk("______________________________________________________________________________"));
		document.add(paragraph2);

		Paragraph paragraph3 = new Paragraph();
		 paragraph3.add(new Chunk("Prix total: " + d + " €"));
		 document.add(paragraph3);

		Paragraph paragraph4 = new Paragraph();
		paragraph4.add(new Chunk(
				"\n\n\n l'equipe Amandine, J-D, Steven et Claire espère vous revoir bientôt pour de nouvelles aventures avec Marmotte vacances!"
						+ "\n en cas de reclamation veillez nous contacter à l'adresse suivante:  nomane.boulmerdj@gmail.com"));
		document.add(paragraph4);

		// fermer le document
		document.close();
	}
}
