package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/** 
 * 
 * @author Amandine
 *Classe model Pack
 */

@Entity
@Table(name="packs")
public class Pack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pack")
	private int id;
	private String nom;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	private Double prixTotal;
	private Double prixPromo;
	private int nombrePlaces;
	private String loisir1;
	private String loisir2;
	private String hebergement;
	private String destination;
	@Lob
	private byte[] photo;
	@Transient
	private String image;
	
	
	/** Association
	 */

	
	@ManyToOne
	@JoinColumn(name = "ad_id", referencedColumnName = "id_ad")
	Admin admin;


	/** Constructeurs
	 */
	public Pack() {
		super();
	}


	
	
	public Pack(int id, String nom, String description, Date dateArrivee, Date dateDepart, Double prixTotal,
			Double prixPromo, int nombrePlaces, String loisir1, String loisir2, String hebergement, String destination,
			byte[] photo, String image) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prixTotal = prixTotal;
		this.prixPromo = prixPromo;
		this.nombrePlaces = nombrePlaces;
		this.loisir1 = loisir1;
		this.loisir2 = loisir2;
		this.hebergement = hebergement;
		this.destination = destination;
		this.photo = photo;
		this.image = image;
		
	}




	public Pack(String nom, String description, Date dateArrivee, Date dateDepart, Double prixTotal, Double prixPromo,
			int nombrePlaces, String loisir1, String loisir2, String hebergement, String destination, byte[] photo,
			String image) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prixTotal = prixTotal;
		this.prixPromo = prixPromo;
		this.nombrePlaces = nombrePlaces;
		this.loisir1 = loisir1;
		this.loisir2 = loisir2;
		this.hebergement = hebergement;
		this.destination = destination;
		this.photo = photo;
		this.image = image;
	
	}



	
	
	

	public Pack(String nom, String description, Date dateArrivee, Date dateDepart, Double prixTotal, Double prixPromo,
			int nombrePlaces, String loisir1, String loisir2, String hebergement, String destination, byte[] photo,
			String image, Admin admin) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prixTotal = prixTotal;
		this.prixPromo = prixPromo;
		this.nombrePlaces = nombrePlaces;
		this.loisir1 = loisir1;
		this.loisir2 = loisir2;
		this.hebergement = hebergement;
		this.destination = destination;
		this.photo = photo;
		this.image = image;
		this.admin = admin;
	}




	public Pack(int id, String nom, String description, Date dateArrivee, Date dateDepart, Double prixTotal,
			Double prixPromo, int nombrePlaces, String loisir1, String loisir2, String hebergement, String destination,
			byte[] photo, String image, Admin admin) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prixTotal = prixTotal;
		this.prixPromo = prixPromo;
		this.nombrePlaces = nombrePlaces;
		this.loisir1 = loisir1;
		this.loisir2 = loisir2;
		this.hebergement = hebergement;
		this.destination = destination;
		this.photo = photo;
		this.image = image;
		this.admin = admin;
	}




	/** Getters et Setters
	 */

	public int getId() {
		return id;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateArrivee() {
		return dateArrivee;
	}


	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}


	public Date getDateDepart() {
		return dateDepart;
	}


	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}


	public Double getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}


	public Double getPrixPromo() {
		return prixPromo;
	}


	public void setPrixPromo(Double prixPromo) {
		this.prixPromo = prixPromo;
	}


	public int getNombrePlaces() {
		return nombrePlaces;
	}


	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}





	public String getLoisir1() {
		return loisir1;
	}




	public void setLoisir1(String loisir1) {
		this.loisir1 = loisir1;
	}




	public String getLoisir2() {
		return loisir2;
	}




	public void setLoisir2(String loisir2) {
		this.loisir2 = loisir2;
	}




	public String getHebergement() {
		return hebergement;
	}




	public void setHebergement(String hebergement) {
		this.hebergement = hebergement;
	}




	public String getDestination() {
		return destination;
	}




	public void setDestination(String destination) {
		this.destination = destination;
	}




	public Admin getAdmin() {
		return admin;
	}




	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	





	
}
