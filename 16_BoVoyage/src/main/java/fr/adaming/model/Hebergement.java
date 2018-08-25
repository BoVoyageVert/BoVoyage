package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
 * 
 * @author Amandine
 * classe model Hebergement
 *
 */

@Entity
@Table(name="hebergements")
public class Hebergement {

	//attribut
	/** 
	 * 
	 * @author Amandine
	 * classe model Hebergement
	 * declaration des attributs
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_h")
	private int id;
	private String type;
	private boolean disponibilite;
	private double prix;
	private double reduction;
	private String lieux;
	private String ville;
	private int codePostal;
	private String menage;
	private long numHebergement;
	private String description;
	@Lob
	private byte [] photo;
	@Transient
	private String image;
	
	
	
	//association
	/** 
	 * 
	 * @author Amandine
	 * classe model Hebergement
	 * association
	 *
	 */
	@OneToOne
	@JoinColumn(name="v_id", referencedColumnName="id_v")
	private Voyage voyage;


	
	//Constructeurs
	/** 
	 * classe model Hebergement
	 * constructeur vide
	 *
	 */
	public Hebergement() {
		super();
	}


	//Constructeurs
		/** 
		 * classe model Hebergement
		 * constructeur avec param avec id
		 *
		 */


	public Hebergement(int id, String type, boolean disponibilite, double prix, double reduction, String lieux,
			String ville, int codePostal, String menage, long numHebergement, String description, byte[] photo,
			String image, Voyage voyage) {
		super();
		this.id = id;
		this.type = type;
		this.disponibilite = disponibilite;
		this.prix = prix;
		this.reduction = reduction;
		this.lieux = lieux;
		this.ville = ville;
		this.codePostal = codePostal;
		this.menage = menage;
		this.numHebergement = numHebergement;
		this.description = description;
		this.photo = photo;
		this.image = image;
		this.voyage = voyage;
	}
	
	

	public Hebergement(String type, boolean disponibilite, double prix, double reduction, String lieux, String ville,
			int codePostal, String menage, long numHebergement, String description, byte[] photo, String image,
			Voyage voyage) {
		super();
		this.type = type;
		this.disponibilite = disponibilite;
		this.prix = prix;
		this.reduction = reduction;
		this.lieux = lieux;
		this.ville = ville;
		this.codePostal = codePostal;
		this.menage = menage;
		this.numHebergement = numHebergement;
		this.description = description;
		this.photo = photo;
		this.image = image;
		this.voyage = voyage;
	}


	//getters et setters
	/** 
	 * classe model Hebergement
	 * Getters et Setters
	 *
	 */
	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public boolean isDisponibilite() {
		return disponibilite;
	}



	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public double getReduction() {
		return reduction;
	}



	public void setReduction(double reduction) {
		this.reduction = reduction;
	}



	public String getLieux() {
		return lieux;
	}



	public void setLieux(String lieux) {
		this.lieux = lieux;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public int getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}



	public String isMenage() {
		return menage;
	}



	public void setMenage(String menage) {
		this.menage = menage;
	}



	public long getNumHebergement() {
		return numHebergement;
	}



	public void setNumHebergement(long numHebergement) {
		this.numHebergement = numHebergement;
	}



	public Voyage getVoyage() {
		return voyage;
	}



	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
	
	
}
