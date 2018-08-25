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

/** jd : Déclaration de la classe persistante Destination */

@Entity /** jd : Annotation pour rendre la classe persistante */
@Table(name = "destinations") /**
								 * jd : Annotation pour créer la table dans la
								 * base au nom "destinations"
								 */
public class Destination {

	/** jd : Déclaration des attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_d")
	private int idDestination;

	private String nomDestination;

	private String descriptionDesti;

	@Lob
	private byte[] photoDesti;

	private double prixDesti;

	/** Mapping de l'association One to One unidirectionnelle */
	@OneToOne
	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
	private Voyage voyage;

	/** jd : Déclaration des constructeurs */
	public Destination() {
		super();
	}

	public Destination(String descriptionDesti, byte[] photoDesti, double prixDesti) {
		super();
		this.descriptionDesti = descriptionDesti;
		this.photoDesti = photoDesti;
		this.prixDesti = prixDesti;
	}

	public Destination(int id, String descriptionDesti, byte[] photoDesti, double prixDesti) {
		super();
		this.idDestination = id;
		this.descriptionDesti = descriptionDesti;
		this.photoDesti = photoDesti;
		this.prixDesti = prixDesti;
	}

	public Destination(int idDestination, String descriptionDesti, byte[] photoDesti, String imageDesti,
			double prixDesti, Voyage voyage) {
		super();
		this.idDestination = idDestination;
		this.descriptionDesti = descriptionDesti;
		this.photoDesti = photoDesti;
		this.imageDesti = imageDesti;
		this.prixDesti = prixDesti;
		this.voyage = voyage;
	}

	public Destination(String descriptionDesti, byte[] photoDesti, String imageDesti, double prixDesti, Voyage voyage) {
		super();
		this.descriptionDesti = descriptionDesti;
		this.photoDesti = photoDesti;
		this.imageDesti = imageDesti;
		this.prixDesti = prixDesti;
		this.voyage = voyage;
	}

	public Destination(String nomDestination, String descriptionDesti, byte[] photoDesti, String imageDesti,
			double prixDesti, Voyage voyage) {
		super();
		this.nomDestination = nomDestination;
		this.descriptionDesti = descriptionDesti;
		this.photoDesti = photoDesti;
		this.imageDesti = imageDesti;
		this.prixDesti = prixDesti;
		this.voyage = voyage;
	}

	public Destination(int idDestination, String nomDestination, String descriptionDesti, byte[] photoDesti,
			String imageDesti, double prixDesti, Voyage voyage) {
		super();
		this.idDestination = idDestination;
		this.nomDestination = nomDestination;
		this.descriptionDesti = descriptionDesti;
		this.photoDesti = photoDesti;
		this.imageDesti = imageDesti;
		this.prixDesti = prixDesti;
		this.voyage = voyage;
	}

	/** jd : Déclaration des getters et setters */
	public int getId() {
		return idDestination;
	}

	public void setId(int id) {
		this.idDestination = id;
	}

	public String getDescriptionDesti() {
		return descriptionDesti;
	}

	public void setDescriptionDesti(String descriptionDesti) {
		this.descriptionDesti = descriptionDesti;
	}

	public byte[] getPhotoDesti() {
		return photoDesti;
	}

	public void setPhotoDesti(byte[] photoDesti) {
		this.photoDesti = photoDesti;
	}

	public double getPrixDesti() {
		return prixDesti;
	}

	public void setPrixDesti(double prixDesti) {
		this.prixDesti = prixDesti;
	}

	public int getIdDestination() {
		return idDestination;
	}

	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}

	public String getImageDesti() {
		return imageDesti;
	}

	public void setImageDesti(String imageDesti) {
		this.imageDesti = imageDesti;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public String getNomDestination() {
		return nomDestination;
	}

	public void setNomDestination(String nomDestination) {
		this.nomDestination = nomDestination;
	}

}
