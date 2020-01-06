package fr.telecom_st_etienne.fx.kanban.business;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto-increment
	private Long id;
	@NotBlank
	@Size(min=7, message="Le institule doit contenir au minimum 7 caractères")
	private String intitule;

	@JsonIgnore
	private Date dateCreation;
	
	@Min(value = 0)
	@Max(value = 144)
	private int nbHeuresPrevues;
	
	private int nbHeuresEffectives;
	
	
	@ManyToOne
	private Projet projet;
	
	@ManyToOne
	private Colonne colonneActuelle;
	
	@ManyToOne
	private TypeTache typeTache;
	
	@NotEmpty
	@ManyToMany
	private List<Developpeur> developpeurs;
	


	public Tache() {
		setDateCreation(new Date());
	}
	
	public Tache(String intitule2, Colonne colonne, int nbHeuresPrevues2, List<Developpeur> developpeurs2, TypeTache typeTache2, Projet projet2) {
		this();
		this.intitule = intitule2;
		this.colonneActuelle = colonne;
		this.nbHeuresPrevues = nbHeuresPrevues2;
		this.developpeurs = developpeurs2;
		this.typeTache = typeTache2;
		this.projet = projet2;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getNbHeuresPrevues() {
		return nbHeuresPrevues;
	}

	public void setNbHeuresPrevues(int nbHeuresPrevues) {
		this.nbHeuresPrevues = nbHeuresPrevues;
	}

	public int getNbHeuresEffectives() {
		return nbHeuresEffectives;
	}

	public void setNbHeuresEffectives(int nbHeuresEffectives) {
		this.nbHeuresEffectives = nbHeuresEffectives;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Colonne getColonneActuelle() {
		return colonneActuelle;
	}

	public void setColonneActuelle(Colonne colonneActuelle) {
		this.colonneActuelle = colonneActuelle;
	}

	public TypeTache getTypeTache() {
		return typeTache;
	}

	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", intitule=" + intitule + ", dateCreation=" + dateCreation + "]";
	}
		
}