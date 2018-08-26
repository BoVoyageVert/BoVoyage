package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "voyages")
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_v")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	private Double prixTotal;
	private int nombrePlaces;
	@Lob
	private byte[] photo;
	@Transient
	private String image;
	public Voyage() {
		super();
	}
	
	@OneToMany(mappedBy="voyage")
	List<Loisir> listeLoisir;
	
	@OneToOne(mappedBy="voyage")
	Destination destination;
	
	@OneToOne(mappedBy="voyage")
	Hebergement hebergement;
	
	@OneToOne(mappedBy="voyage")
	Voiture voiture;
	
	
	
	
	public Voyage(Date dateArrivee, Date dateDepart, int nombrePlaces) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.nombrePlaces = nombrePlaces;
	}
	public Voyage(Date dateArrivee, Date dateDepart, Double prixTotal, int nombrePlaces, byte[] photo, String image) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prixTotal = prixTotal;
		this.nombrePlaces = nombrePlaces;
		this.photo = photo;
		this.image = image;
	}
	public Voyage(int id, Date dateArrivee, Date dateDepart, Double prixTotal, int nombrePlaces, byte[] photo,
			String image) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prixTotal = prixTotal;
		this.nombrePlaces = nombrePlaces;
		this.photo = photo;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart + ", prixTotal="
				+ prixTotal + ", nombrePlaces=" + nombrePlaces + ", photo=" + Arrays.toString(photo) + ", image="
				+ image + "]";
	}
}
