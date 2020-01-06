package fr.telecom_st_etienne.fx.kanban.service;

import java.util.Date;
import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;
import fr.telecom_st_etienne.fx.kanban.business.Tache;

public interface HistoriqueDeplacementService {

	HistoriqueDeplacement ajouterHistory(Tache tache, Colonne colonne, Date date);

	List<HistoriqueDeplacement> recupererHistory();
	
	HistoriqueDeplacement recupererHistoriqueDeplacement(Long id);
	void supprimerHistoriqueDeplacement(HistoriqueDeplacement historiqueDeplacement);

	HistoriqueDeplacement enregisterHistoriqueDeplacement(HistoriqueDeplacement historiqueDeplacement);
	
}
