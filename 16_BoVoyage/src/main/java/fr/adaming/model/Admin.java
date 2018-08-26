package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** 
 * 
 * @author Amandine
 *Classe model Admin
 */

@Entity
@Table(name="admins")
public class Admin {
	/** 
	 * Attribut
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ad")
	private int id;
	private String nom;
	private String prenom;
	private String identifiant;
	private String motDePasse;
	private boolean active;

	
//	/** Association
//	 */
//	@OneToMany(mappedBy="admin")
//	Pack pack;
	
////	@OneToMany(mappedBy="admin")
////	Voyage voyage;

	@OneToMany(mappedBy="admin")
	private List<RoleSecurity> roleSecurity;
	
//	@OneToOne
//	@JoinColumn(name = "ad_do", referencedColumnName = "do_ad")
//	DossierVoyage dossierVoyage;
//	
//	
	/** Constructeurs
	 */
	public Admin() {
		super();
	}
//
//
//
//	public Admin(int id, String nom, String prenom, String identifiant, String motDePasse, Pack pack) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.pack = pack;
//		
//	}
//
//
//
//	public Admin(String nom, String prenom, String identifiant, String motDePasse, Pack pack) {
//		super();
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.pack = pack;
//	
//	}
//
//	
//	
//	
//	public Admin(String nom, String prenom, String identifiant, String motDePasse, boolean active, Pack pack,
//			DossierVoyage dossierVoyage) {
//		super();
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.active = active;
//		this.pack = pack;
//		this.dossierVoyage = dossierVoyage;
//	}
//
//
//
//	public Admin(int id, String nom, String prenom, String identifiant, String motDePasse, boolean active, Pack pack,
//			 DossierVoyage dossierVoyage) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.active = active;
//		this.pack = pack;
//		
//		this.dossierVoyage = dossierVoyage;
//	}
//
//
//
//	public Admin(int id, String nom, String prenom, String identifiant, String motDePasse, boolean active) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.active = active;
//	}
//
//
//
//	/** Getters et Setters
//	 */
//	public int getId() {
//		return id;
//	}
//
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//
//	public String getNom() {
//		return nom;
//	}
//
//
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//
//
//
//	public String getIdentifiant() {
//		return identifiant;
//	}
//
//
//
//	public void setIdentifiant(String identifiant) {
//		this.identifiant = identifiant;
//	}
//
//
//
//	public String getMotDePasse() {
//		return motDePasse;
//	}
//
//
//
//	public void setMotDePasse(String motDePasse) {
//		this.motDePasse = motDePasse;
//	}
//
//
//
//	public Pack getPack() {
//		return pack;
//	}
//
//
//
//	public void setPack(Pack pack) {
//		this.pack = pack;
//	}
//
//
//
//
//	public boolean isActive() {
//		return active;
//	}
//
//
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//
//
//
//	public DossierVoyage getDossierVoyage() {
//		return dossierVoyage;
//	}
//
//
//
//	public void setDossierVoyage(DossierVoyage dossierVoyage) {
//		this.dossierVoyage = dossierVoyage;
//	}
//
//
//
//	public List<RoleSecurity> getRoleSecurity() {
//		return roleSecurity;
//	}
//
//
//
//	public void setRoleSecurity(List<RoleSecurity> roleSecurity) {
//		this.roleSecurity = roleSecurity;
//	}
//
	
	


	public int getId() {
		return id;
	}


	public Admin(int id, String nom, String prenom, String identifiant, String motDePasse, boolean active) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.identifiant = identifiant;
	this.motDePasse = motDePasse;
	this.active = active;
}
	
	
	
	public Admin(String nom, String prenom, String identifiant, String motDePasse, boolean active) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.active = active;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}




	public Admin(String nom, String prenom, String identifiant, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}




	
	
	
	
}
