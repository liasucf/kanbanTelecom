package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.dao.TacheDao;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;

@Service
public class TacheServiceImpl implements TacheService {

	@Autowired
	private TacheDao tacheDAO;
	
	@Override
	public Tache ajouterTache(String intitule) {
		Tache tache = new Tache(intitule);
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



}
