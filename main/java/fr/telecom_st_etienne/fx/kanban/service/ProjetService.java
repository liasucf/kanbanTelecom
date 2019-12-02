package fr.telecom_st_etienne.fx.kanban.service;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Projet;

public interface ProjetService {

	Projet recupererProjet(Long id);
	Projet ajouterProjet(String nom);

}
