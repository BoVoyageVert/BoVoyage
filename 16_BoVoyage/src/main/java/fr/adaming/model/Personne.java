package fr.adaming.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

/** jd : D�claration de la classe m�re Personne */

@MappedSuperclass /**
					 * jd : Annotation permettant de mapper les attributs de la
					 * classe m�re vers les classes filles
					 */
public class Personne {

	/** jd : D�claration des attributs */
	protected String civilite;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String telephone;
	protected Date dateNaissance;

	/** jd : D�claration des constructeurs */
	public Personne() {
		super();
	}

	public Personne(String civilite, String nom, String prenom, String adresse, String telephone, Date dateNaissance) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}

	/** jd : D�claration des getters et setters */
	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
