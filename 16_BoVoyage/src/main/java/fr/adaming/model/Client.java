package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** jd : Déclaration de la classe persistante Client */

@Entity /** jd : Annotation pour rentre la classe persistante */
@Table(name = "clients") /**
							 * jd : Annotation pour créer une table avec le nom
							 * "clients"
							 */
public class Client extends Personne {

	/** jd : Déclaration des attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int idClient;

	private String numCb;
	private String numSequentiel;
	private String mdp;
	private String mail;


	/** jd : Déclaration des constructeurs */
	public Client() {
		super();
	}

	public Client(int idClient, String numCb, String numSequentiel, String mdp, String mail) {
		super();
		this.idClient = idClient;
		this.numCb = numCb;
		this.numSequentiel = numSequentiel;
		this.mdp = mdp;
		this.mail = mail;
	}
	
	

	public Client(String numCb, String numSequentiel, String mdp, String mail) {
		super();
		this.numCb = numCb;
		this.numSequentiel = numSequentiel;
		this.mdp = mdp;
		this.mail = mail;
	}

	
	public Client(String civilite, String nom, String prenom, String adresse, String telephone, Date dateNaissance,
			String numCb, String numSequentiel, String mdp, String mail) {
		super(civilite, nom, prenom, adresse, telephone, dateNaissance);
		this.numCb = numCb;
		this.numSequentiel = numSequentiel;
		this.mdp = mdp;
		this.mail = mail;
	}
	
	

	public Client(String civilite, String nom, String prenom, String adresse, String telephone, Date dateNaissance,
			int idClient, String numCb, String numSequentiel, String mdp, String mail) {
		super(civilite, nom, prenom, adresse, telephone, dateNaissance);
		this.idClient = idClient;
		this.numCb = numCb;
		this.numSequentiel = numSequentiel;
		this.mdp = mdp;
		this.mail = mail;
	}

	/** jd : Déclaration des getters et setters */
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNumCb() {
		return numCb;
	}

	public void setNumCb(String numCb) {
		this.numCb = numCb;
	}

	public String getNumSequentiel() {
		return numSequentiel;
	}

	public void setNumSequentiel(String numSequentiel) {
		this.numSequentiel = numSequentiel;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
