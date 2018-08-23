package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** jd : Déclaration de la classe persistante Assurance */

@Entity /** jd: annotation pour rendre la classe persistante */
@Table(name = "assurances") /**
							 * jd: annotation pour créer la table au nom
							 * "assurances"
							 */
public class Assurance {

	/** jd: Déclaration des attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_a")
	private int idAssurance;

	private int numeroDossier;
	private boolean assuranceAnnulation;
	private boolean assuranceComplementaire;

	/** jd : Mapping de l'association One to One */
	@OneToOne
	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
	private Voyage voyage;

	/** jd: Déclaration des constructeurs */
	public Assurance() {
		super();
	}

	public Assurance(int numeroDossier, boolean assuranceAnnulation, boolean assuranceComplementaire) {
		super();
		this.numeroDossier = numeroDossier;
		this.assuranceAnnulation = assuranceAnnulation;
		this.assuranceComplementaire = assuranceComplementaire;
	}

	public Assurance(int idAssurance, int numeroDossier, boolean assuranceAnnulation, boolean assuranceComplementaire) {
		super();
		this.idAssurance = idAssurance;
		this.numeroDossier = numeroDossier;
		this.assuranceAnnulation = assuranceAnnulation;
		this.assuranceComplementaire = assuranceComplementaire;
	}

	public Assurance(int numeroDossier, boolean assuranceAnnulation, boolean assuranceComplementaire, Voyage voyage) {
		super();
		this.numeroDossier = numeroDossier;
		this.assuranceAnnulation = assuranceAnnulation;
		this.assuranceComplementaire = assuranceComplementaire;
		this.voyage = voyage;
	}

	public Assurance(int idAssurance, int numeroDossier, boolean assuranceAnnulation, boolean assuranceComplementaire,
			Voyage voyage) {
		super();
		this.idAssurance = idAssurance;
		this.numeroDossier = numeroDossier;
		this.assuranceAnnulation = assuranceAnnulation;
		this.assuranceComplementaire = assuranceComplementaire;
		this.voyage = voyage;
	}

	/** jd : Déclaration des getters et setters */
	public int getIdAssurance() {
		return idAssurance;
	}

	public void setIdAssurance(int idAssurance) {
		this.idAssurance = idAssurance;
	}

	public int getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(int numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public boolean isAssuranceAnnulation() {
		return assuranceAnnulation;
	}

	public void setAssuranceAnnulation(boolean assuranceAnnulation) {
		this.assuranceAnnulation = assuranceAnnulation;
	}

	public boolean isAssuranceComplementaire() {
		return assuranceComplementaire;
	}

	public void setAssuranceComplementaire(boolean assuranceComplementaire) {
		this.assuranceComplementaire = assuranceComplementaire;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

}
