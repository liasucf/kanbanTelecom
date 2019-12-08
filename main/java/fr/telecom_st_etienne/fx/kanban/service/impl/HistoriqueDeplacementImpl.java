package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.dao.HistoriqueDeplacementDAO;
import fr.telecom_st_etienne.fx.kanban.service.HistoriqueDeplacementService;

@Service
public class HistoriqueDeplacementImpl implements HistoriqueDeplacementService {
	@Autowired
	private HistoriqueDeplacementDAO historiqueDAO;
	
	@Override
	public HistoriqueDeplacement saveHistory(Tache tache, Colonne colonne, Date date) {
		HistoriqueDeplacement history = new HistoriqueDeplacement(tache, colonne, date);
		return historiqueDAO.save(history);}
		// TODO Auto-generated method stub
	@Override
	public List<HistoriqueDeplacement> recupererHistory() {
		return historiqueDAO.findAll();
	
		
	}

}
