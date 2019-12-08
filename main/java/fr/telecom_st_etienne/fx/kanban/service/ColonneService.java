package fr.telecom_st_etienne.fx.kanban.service;


import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;

public interface ColonneService {
	
	Colonne ajouterColonne(String nom);
	Colonne recupererColonne(Long id);
	List<Colonne> recupererColonnes();
	void supprimerColonne(Colonne colonne);

}
