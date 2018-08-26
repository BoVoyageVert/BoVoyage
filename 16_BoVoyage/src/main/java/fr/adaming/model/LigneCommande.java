package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lignesCommande")
public class LigneCommande {
	/** Declaration des attributs
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lc")
	private int id;
	private String typePrestation;
	private String Designation;
	private int quantite;
	private double prixNormal;
	private double prixPromotion;
	
	/** Transformation association UML en JAVA*/
	@ManyToOne
	@JoinColumn(name="do_id", referencedColumnName="id_do")
	private DossierVoyage dossier;
	


	/**
	 * Contructeurs
	 */
	public LigneCommande() {
		super();
	}
	public LigneCommande(String typePrestation, String designation, int quantite, double prixNormal,
			double prixPromotion) {
		super();
		this.typePrestation = typePrestation;
		Designation = designation;
		this.quantite = quantite;
		this.prixNormal = prixNormal;
		this.prixPromotion = prixPromotion;
	}
	public LigneCommande(int id, String typePrestation, String designation, int quantite, double prixNormal,
			double prixPromotion) {
		super();
		this.id = id;
		this.typePrestation = typePrestation;
		Designation = designation;
		this.quantite = quantite;
		this.prixNormal = prixNormal;
		this.prixPromotion = prixPromotion;
	}
	
	/**
	 * Getters et setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypePrestation() {
		return typePrestation;
	}
	public void setTypePrestation(String typePrestation) {
		this.typePrestation = typePrestation;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixNormal() {
		return prixNormal;
	}
	public void setPrixNormal(double prixNormal) {
		this.prixNormal = prixNormal;
	}
	public double getPrixPromotion() {
		return prixPromotion;
	}
	public void setPrixPromotion(double prixPromotion) {
		this.prixPromotion = prixPromotion;
	}
	public DossierVoyage getDossier() {
		return dossier;
	}
	public void setDossier(DossierVoyage dossier) {
		this.dossier = dossier;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", typePrestation=" + typePrestation + ", Designation=" + Designation
				+ ", quantite=" + quantite + ", prixNormal=" + prixNormal + ", prixPromotion=" + prixPromotion
				+ ", dossier=" + dossier + "]";
	}
}
