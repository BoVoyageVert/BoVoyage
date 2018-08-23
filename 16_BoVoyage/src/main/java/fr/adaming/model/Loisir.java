package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity /** claire: Annotation pour rendre la classe persistante */
@Table(name="loisirs") /** claire: Annotation pour nommé la table avec le nom loisirs dans la bd */
public class Loisir {
	
	
	/** claire: attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_l")
	private int idLoisir;
	private String categorie;
	private String nom;
	private String description;
	private double prix;
	private double reduction;
	@Lob
	private byte[] photo;
	@Transient
	private String image;
	
	/**
	 * Transformation des associations UML en JAVA
	 */
	@ManyToOne
	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
	private Voyage voyage;
	
	/** claire: constructeurs*/
	/**vide*/
	public Loisir() {
		super();
	}

	/**sans id*/
	public Loisir(String categorie, String nom, String description, double prix, double reduction, byte[] photo,
			String image) {
		super();
		this.categorie = categorie;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.reduction = reduction;
		this.photo = photo;
		this.image = image;
	}

	/**avec id*/
	public Loisir(int idLoisir, String categorie, String nom, String description, double prix, double reduction,
			byte[] photo, String image) {
		super();
		this.idLoisir = idLoisir;
		this.categorie = categorie;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.reduction = reduction;
		this.photo = photo;
		this.image = image;
	}


	/**Getters et setters*/
	public int getIdLoisir() {
		return idLoisir;
	}

	public void setIdLoisir(int idLoisir) {
		this.idLoisir = idLoisir;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		categorie = categorie;
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

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}


	
	
	
	
	
	

}
