package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** jd : déclaration de la classe persistante Participant */

@Entity /** jd : Annotation rendant la classe persistante */
@Table(name = "participants") /**
								 * jd : Annotation permettant de créer la table
								 * avec le nom "participants"
								 */
public class Participant extends Personne {

	/** jd : Déclaration des attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pa")
	private int idParticipant;

	private String tranche;

	/** jd : Déclaration des constructeurs */
	public Participant() {
		super();
	}

	public Participant(int idParticipant, String tranche) {
		super();
		this.idParticipant = idParticipant;
		this.tranche = tranche;
	}

	public Participant(String civilite, String nom, String prenom, String adresse, String telephone, Date dateNaissance,
			String tranche) {
		super(civilite, nom, prenom, adresse, telephone, dateNaissance);
		this.tranche = tranche;
	}

	public Participant(String civilite, String nom, String prenom, String adresse, String telephone, Date dateNaissance,
			int idParticipant, String tranche) {
		super(civilite, nom, prenom, adresse, telephone, dateNaissance);
		this.idParticipant = idParticipant;
		this.tranche = tranche;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getTranche() {
		return tranche;
	}

	public void setTranche(String tranche) {
		this.tranche = tranche;
	}

}
