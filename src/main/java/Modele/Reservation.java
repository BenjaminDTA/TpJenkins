package Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Reservation {
	@Id
	@GeneratedValue()
	private Integer id;
	@Column
	@NotBlank
	private Long nReservation;
	@Column
	@NotBlank
	private String Nom;
	@Column
	@NotBlank
	private String Prenom;
	@Column
	@NotBlank
	private Integer Age;
	@ManyToOne
	private Vol vol;

	public Reservation(Long nReservation, String nom, String prenom, Integer age) {
		super();
		this.nReservation = nReservation;
		Nom = nom;
		Prenom = prenom;
		Age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNReservation() {
		return nReservation;
	}

	public void setN_Reservation(Long nReservation) {
		this.nReservation = nReservation;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

}
