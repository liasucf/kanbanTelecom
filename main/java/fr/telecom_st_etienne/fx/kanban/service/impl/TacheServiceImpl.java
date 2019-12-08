package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.dao.TacheDao;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;

@Service
public class TacheServiceImpl implements TacheService {

	@Autowired
	private TacheDao tacheDAO;
	
	@Override
	public Tache ajouterTache(String intitule, Colonne colonne, int nbHeuresPrevues,List<Developpeur> developpeurs, TypeTache typeTache, Projet projet ) {
		Tache tache = new Tache(intitule, colonne,  nbHeuresPrevues, developpeurs, typeTache,projet);
		tacheDAO.save(tache);
		return tache;
	}

	@Override
	public List<Tache> recupererTaches() {
		return tacheDAO.findAll();
	}

	@Override
	public Tache recupererTache(Long id) {
		return tacheDAO.findOne(id);
	}

	@Override
	public void supprimerTache(Tache tache) {
		tacheDAO.delete(tache);
	}

	@Override
	public Tache enregisterTache(Tache tache) {
		return tacheDAO.save(tache);
	}

	@Override
	public Tache changeColonne(Tache tache, Colonne colonne) {
		tache.setColonneActuelle(colonne);
		tacheDAO.save(tache);
		return tache;
	}
	



}
