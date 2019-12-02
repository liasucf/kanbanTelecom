package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;

public interface TypeTacheService {
		
		TypeTache ajouterTypeTache(String nom);
		
		List<TypeTache> recupererTypeTaches();
	
		TypeTache recupererTypeTache(Long id);
	
		void supprimerTypeTache(TypeTache typeTache);

}
