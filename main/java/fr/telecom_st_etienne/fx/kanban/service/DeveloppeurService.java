package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.telecom_st_etienne.fx.kanban.business.Developpeur;

public interface DeveloppeurService {

	List<Developpeur> recupererDeveloppeurs();
	Developpeur ajouterDeveloppeur(String nom);
	Developpeur recupererDeveloppeur(Long id);
	void supprimerDeveloppeur(Developpeur developpeur);
	Developpeur enregisterDeveloppeur(Developpeur developpeur);
	Page<Developpeur> recupererDeveloppeurs(Pageable pageable);

}
