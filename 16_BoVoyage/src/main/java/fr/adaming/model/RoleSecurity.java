package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleSecurity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_r")
	private int id;
	private String role;

	
	@ManyToOne
	@JoinColumn(name = "ad_id", referencedColumnName = "id_ad")
	private Admin admin;


	public RoleSecurity() {
		super();
	}


	public RoleSecurity(String role, Admin admin) {
		super();
		this.role = role;
		this.admin = admin;
	}


	public RoleSecurity(int id, String role, Admin admin) {
		super();
		this.id = id;
		this.role = role;
		this.admin = admin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
