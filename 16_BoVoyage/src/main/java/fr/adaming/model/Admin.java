package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
//	/** Association
//	 */
//	@OneToMany(mappedBy="admin")
//	Pack pack;
//	
//	@OneToMany(mappedBy="admin")
//	Voyage voyage;
//
//	
//	
////	@OneToMany(mappedBy="admin")
////	DossierVoyage dossierVoyage;
////	
//	
//	/** Constructeurs
//	 */
//	public Admin() {
//		super();
//	}
//
//
//
//	public Admin(int id, String nom, String prenom, String identifiant, String motDePasse, Pack pack, Voyage voyage) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.pack = pack;
//		this.voyage = voyage;
//	}
//
//
//
//	public Admin(String nom, String prenom, String identifiant, String motDePasse, Pack pack, Voyage voyage) {
//		super();
//		this.nom = nom;
//		this.prenom = prenom;
//		this.identifiant = identifiant;
//		this.motDePasse = motDePasse;
//		this.pack = pack;
//		this.voyage = voyage;
//	}
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
//	public Voyage getVoyage() {
//		return voyage;
//	}
//
//
//
//	public void setVoyage(Voyage voyage) {
//		this.voyage = voyage;
//	}
//	
//	
//
//	
//	
//	
	
}
