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
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IDossierDao;
import fr.adaming.model.Client;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.Voyage;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {

	/** Transformation de l'association UML en Java */
	private IDossierDao dossierDao;

	/** Setter pour l'injection d�pendance */
	@Autowired
	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
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
	public List<DossierVoyage> getDossierByIdClient(Client cl) {
		// TODO Auto-generated method stub
		return dossierDao.getDossierByIdClient(cl);
	}

	@Override
	public List<DossierVoyage> getAllDossier() {
		return dossierDao.getAllDossier();
	}

	@Override
	public void sendMail(DossierVoyage dv, Voyage v) {
		// mon compte gmail (pour recevoir les messages)
		final String username = "bauchemin.c@gmail.com";
		final String password = "geol220891";

		// les propri�t�es
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
					+ "\n\n Merci de votre confiance!" + "\n Vous trouverez ci-joint la facture de votre s�jour"
					+ "\n n� de dossier:" + dv.getIdDossier() + "\n Dates du sejour:" + "\n Date d'arriv�e: "
					+ v.getDateArrivee() + "\n Date de d�part: " + v.getDateDepart()
					+ "\n\n\n Tout l'�quipe d'Amandine, J-D, Steven et Claire esp�re vous revoir bient�t sur leur site!");

			// ecrire le pdf dans outputStream
			outputStream = new ByteArrayOutputStream();
			writePdf(outputStream, dv);
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

			System.out.println("message envoy�! c'est ok!!");// verifier si
																// ca a reussi

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	// ecrire le pdf (using iText API)

	public void writePdf(ByteArrayOutputStream outputStream, DossierVoyage dv) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);

		// ouvrir le document
		document.open();

		// donn�es du document
		document.addTitle("Facture PDF");
		document.addSubject("Testing email PDF");
		document.addKeywords("iText, email");
		document.addAuthor("Steven, Amandine, J-D et Claire");
		document.addCreator("Steven, Amandine, J-D et Claire");

		// r�cup de la liste des lignes commandes associ�es � la commande
		// List<LigneCommande> listeLc =
		// lcDao.getListeLigneCommandeByComId(com);

		// calcul du prix total =
		// Double d = 0.0;
		// for (LigneCommande lc : listeLc) {
		// d += lc.getPrix();
		// }

		// composition du pdf

		Image img = Image.getInstance(getClass().getClassLoader().getResource("logoPDF.png"));
		document.add(img);

		Paragraph paragraph = new Paragraph();
		paragraph.add(
				new Chunk("\n\n Cher(e) Mr(Mme) " + dv.getClient().getNom() + " " + dv.getClient().getPrenom() + ";"));
		document.add(paragraph);

		Paragraph paragraph1 = new Paragraph();
		paragraph1.add(new Chunk("\n n� de dossier:" + dv.getIdDossier() + "\n Statut de votre dossier: "
				+ dv.getStatut() + "\n\n voici le recapitulatif de votre facture:\n\n"));
		document.add(paragraph1);

		// // On cr�er un objet table dans lequel on intialise �a taille.
		// PdfPTable table = new PdfPTable(5);
		// // ajout des cellules ent�tes
		// Font f = new Font(FontFamily.HELVETICA, 15, Font.BOLD,
		// GrayColor.BLACK);
		// PdfPCell cell = new PdfPCell(new Phrase("Voyage", f));
		// cell.setBackgroundColor(GrayColor.LIGHT_GRAY);
		// cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// table.addCell(cell);
		// PdfPCell cell1 = new PdfPCell(new Phrase("Caution", f));
		// cell1.setBackgroundColor(GrayColor.LIGHT_GRAY);
		// cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		// table.addCell(cell1);
		// PdfPCell cell2 = new PdfPCell(new Phrase("Options", f));
		// cell2.setBackgroundColor(GrayColor.LIGHT_GRAY);
		// cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		// table.addCell(cell2);
		// PdfPCell cell3 = new PdfPCell(new Phrase("Prix initial", f));
		// cell3.setBackgroundColor(GrayColor.LIGHT_GRAY);
		// cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		// table.addCell(cell3);
		// PdfPCell cell4 = new PdfPCell(new Phrase("Reduction", f));
		// cell4.setBackgroundColor(GrayColor.LIGHT_GRAY);
		// cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		// table.addCell(cell4);

		// // Creation du recapitulatif de la commande
		// for (LigneCommande lc1 : listeLc) {
		//
		// // on ajoute les cellules
		// table.addCell(prDao.rechProduit(lc1.getProduit()).getDesignation());
		// table.addCell("x " + lc1.getQuantite());
		// table.addCell(prDao.rechProduit(lc1.getProduit()).getPrix() + "� x "
		// + lc1.getQuantite());
		//
		// }
		// document.add(table);

		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(new Chunk("______________________________________________________________________________"));
		document.add(paragraph2);

		// Paragraph paragraph3 = new Paragraph();
		// paragraph3.add(new Chunk("Prix total: " + d + " �"));
		// document.add(paragraph3);

		Paragraph paragraph4 = new Paragraph();
		paragraph4.add(new Chunk(
				"\n\n\n l'equipe Amandine, J-D, Steven et Claire esp�re vous revoir bient�t pour de nouvelles aventures avec Marmotte vacances!"
						+ "\n en cas de reclamation veillez nous contacter � l'adresse suivante:  nomane.boulmerdj@gmail.com"));
		document.add(paragraph4);

		// fermer le document
		document.close();
	}


	

	
}
