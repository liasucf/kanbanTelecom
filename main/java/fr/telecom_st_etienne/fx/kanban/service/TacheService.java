package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;

public interface TacheService {

	Tache ajouterTache(String intitule, Colonne colonne, int nbHeuresPrevues,List<Developpeur> developpeurs, TypeTache typeTache, Projet projet );
	
	
	List<Tache> recupererTaches();

	Tache recupererTache(Long id);

	void supprimerTache(Tache tache);

	Tache enregisterTache(Tache tache);


	Tache changeColonne(Tache tache, Colonne colonne);


}
