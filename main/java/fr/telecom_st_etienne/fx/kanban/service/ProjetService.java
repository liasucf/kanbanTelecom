package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;



import fr.telecom_st_etienne.fx.kanban.business.Projet;

public interface ProjetService {

	Projet recupererProjet(Long id);
	Projet ajouterProjet(String nom);
	List<Projet> recupererProjets();
	void supprimerProjet(Projet projet);
	Projet enregisterProjet(Projet projet);

}
