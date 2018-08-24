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

	/** claire: attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voit")
	private int idVoiture;
	private int nbPlaces;
	private double prix;
	@Lob
	private byte[] photo;
	@Transient
	private String image;
	
	/**Association avec voyage*/
	@OneToOne
	@JoinColumn(name="v_id", referencedColumnName="id_v")
	private Voyage voyage;


	
	/** claire: constructeurs*/
	/**vide*/
	public Voiture() {
		super();
	}


	/**sans id*/
	public Voiture(int nbPlaces, double prix, byte[] photo, String image) {
		super();
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		this.photo = photo;
		this.image = image;
	}

	/**avec id*/
	public Voiture(int idVoiture, int nbPlaces, double prix, byte[] photo, String image) {
		super();
		this.idVoiture = idVoiture;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		this.photo = photo;
		this.image = image;
	}


	/**Getters et setters*/
	public int getIdVoiture() {
		return idVoiture;
	}


	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}


	public int getNbPlaces() {
		return nbPlaces;
	}


	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
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


	public Voyage getVoyage() {
		return voyage;
	}


	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	
	
	
	
	
	
}
