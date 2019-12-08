package fr.telecom_st_etienne.fx.kanban.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoriqueDeplacement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto-increment
	private Long id;
	
	private Date date;
	
	@ManyToOne
	private Tache tache;
	@ManyToOne
	private Colonne colonne;
	
	public HistoriqueDeplacement() {
		super();
	}

	public HistoriqueDeplacement(Tache tache2, Colonne colonne2, Date date2) {
		this.tache = tache2;
		this.colonne = colonne2;
		this.date = date2;
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public Colonne getColonne() {
		return colonne;
	}

	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}

	
}
