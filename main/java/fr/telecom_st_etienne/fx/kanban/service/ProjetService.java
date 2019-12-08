package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;
import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.business.Tache;

public interface ProjetService {

	Projet recupererProjet(Long id);
	Projet ajouterProjet(String nom);
	List<Projet> recupererProjets();
	void supprimerProjet(Projet projet);

}
