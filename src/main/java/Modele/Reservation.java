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
	private Long numeroReservation;
	@Column
	@NotBlank
	private String nom;
	@Column
	@NotBlank
	private String prenom;
	@Column
	@NotBlank
	private Integer age;
	@ManyToOne
	private Vol vol;

	public Reservation(Long numeroReservation, String nom, String prenom, Integer age) {
		super();
		this.numeroReservation = numeroReservation;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Long getNumeroReservation() {
		return numeroReservation;
	}

	public void setNumeroReservation(Long numeroReservation) {
		this.numeroReservation = numeroReservation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
