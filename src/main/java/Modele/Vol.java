package Modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Vol {
	@Id
	@GeneratedValue()
	private Integer id;
	@Column
	@NotBlank
	private Long nVol;
	@Column
	@NotBlank
	private String typeAvion;
	@Column
	@NotBlank
	private String villeDepart;
	@Column
	@NotBlank
	private String villeArrivee;
	@Column
	@NotBlank
	private Integer nbPlace;
	@Column
	@NotBlank
	private Date date;
	@OneToMany (mappedBy ="vol")
	List<Reservation> reservations;
	
	
	
	
	public Vol(Long nVol, String typeAvion, String villeDepart, String villeArrivee, Integer nbPlace, Date date) {
		super();
		this.nVol = nVol;
		this.typeAvion = typeAvion;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.nbPlace = nbPlace;
		this.date = date;
		
	}
	
	public Vol() {
		
	}
	
	public Long getnVol() {
		return nVol;
	}
	public void setnVol(Long nVol) {
		this.nVol = nVol;
	}
	public Integer getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNVol() {
		return nVol;
	}
	public void setNVol(Long nVol) {
		this.nVol = nVol;
	}
	public String getTypeAvion() {
		return typeAvion;
	}
	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	
}
