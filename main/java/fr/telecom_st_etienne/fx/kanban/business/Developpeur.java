package fr.telecom_st_etienne.fx.kanban.business;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Developpeur {
	public Developpeur(String prenom2, String nom2, String email2, Date date) {
		super();
		this.prenom = prenom2;
		this.nom = nom2;
		this.email = email2;
		this.dateDebutContrat = date;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String prenom;
	private String nom;
	
	@Past(message="Votre date de debut de contrat doit être dans le passé")
	@Temporal(TemporalType.DATE)
	private Date dateDebutContrat;
	
	@Email(message="L''adresse email renseignée n'est pas valide")
	@Column(unique=true)
	private String email;
	
	@Size(min=5, message="Le mot de passe doit contenir au minimum 5 caractères")
	private String motDePasse;


	@ManyToMany(mappedBy = "developpeurs")
	private List<Tache> taches;

	public Developpeur() {
		// TODO Auto-generated constructor stub

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	
	
}
