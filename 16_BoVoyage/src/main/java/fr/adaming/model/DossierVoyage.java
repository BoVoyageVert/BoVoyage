package fr.adaming.model;

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
	private long numDossier;
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

	public DossierVoyage(long numDossier, String statut) {
		super();
		this.numDossier = numDossier;
		this.statut = statut;
	}

	public DossierVoyage(int idDossier, long numDossier, String statut) {
		super();
		this.idDossier = idDossier;
		this.numDossier = numDossier;
		this.statut = statut;
	}

	public DossierVoyage(long numDossier, String statut, Client client, Admin admin, Voyage voyage) {
		super();
		this.numDossier = numDossier;
		this.statut = statut;
		this.client = client;
		this.admin = admin;
		this.voyage = voyage;
	}

	public DossierVoyage(int idDossier, long numDossier, String statut, Client client, Admin admin, Voyage voyage) {
		super();
		this.idDossier = idDossier;
		this.numDossier = numDossier;
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

	public long getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(long numDossier) {
		this.numDossier = numDossier;
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
