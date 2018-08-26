package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dossiers")
public class DossierVoyage {

	/** Déclaration des attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_do")
	private int idDossier;
	private Date date;
	private String statut;

	/** Mapping des associations One To One */
	@OneToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;

	@OneToOne
	@JoinColumn(name = "ad_id", referencedColumnName = "id_ad")
	private Admin admin;

	@OneToOne
	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
	private Voyage voyage;

	/** Déclaration des constructeurs */
	public DossierVoyage() {
		super();
	}

	public DossierVoyage(Date date, String statut) {
		super();
		this.date = date;
		this.statut = statut;
	}

	public DossierVoyage(int idDossier, Date date, String statut) {
		super();
		this.idDossier = idDossier;
		this.date = date;
		this.statut = statut;
	}

	public DossierVoyage(Date date, String statut, Client client, Admin admin, Voyage voyage) {
		super();
		this.date = date;
		this.statut = statut;
		this.client = client;
		this.admin = admin;
		this.voyage = voyage;
	}

	public DossierVoyage(int idDossier, Date date, String statut, Client client, Admin admin, Voyage voyage) {
		super();
		this.idDossier = idDossier;
		this.date = date;
		this.statut = statut;
		this.client = client;
		this.admin = admin;
		this.voyage = voyage;
	}

	/** Déclaration des getters et setters */
	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

}
