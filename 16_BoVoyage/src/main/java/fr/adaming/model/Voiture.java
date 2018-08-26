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

@Entity
@Table(name="voitures")
public class Voiture {

	//claire: attributs 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voit")
	private int idVoiture;
	private String modele;
	private int nbPlaces;
	private double prix;
	@Lob
	private byte[] photo;
	@Transient
	private String image;
	



	
	//claire: constructeurs
	/**
	 * constructeur vide
	 */
	public Voiture() {
		super();
	}


	/**
	 * 
	 * @param modele
	 * @param nbPlaces
	 * @param prix
	 * @param photo
	 * @param image
	 */
	
	public Voiture(String modele, int nbPlaces, double prix, byte[] photo, String image) {
		super();
		this.modele = modele;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		this.photo = photo;
		this.image = image;
	}
	
	/**
	 * 
	 * @param idVoiture
	 * @param modele
	 * @param nbPlaces
	 * @param prix
	 * @param photo
	 * @param image
	 */

	public Voiture(int idVoiture, String modele, int nbPlaces, double prix, byte[] photo, String image) {
		super();
		this.idVoiture = idVoiture;
		this.modele = modele;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		this.photo = photo;
		this.image = image;
	}


	//Getters et setters
	/**
	 * @return the idVoiture
	 */
	public int getIdVoiture() {
		return idVoiture;
	}


	/**
	 * @param idVoiture the idVoiture to set
	 */
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}


	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}


	/**
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}


	/**
	 * @return the nbPlaces
	 */
	public int getNbPlaces() {
		return nbPlaces;
	}


	/**
	 * @param nbPlaces the nbPlaces to set
	 */
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}


	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}


	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}


	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}


	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}




	
	
	
	
	
	
	
}
