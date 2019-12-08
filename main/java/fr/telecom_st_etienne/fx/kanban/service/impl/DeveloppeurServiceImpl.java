package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Client;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.dao.ClientDAO;
import fr.telecom_st_etienne.fx.kanban.dao.DeveloppeurDAO;
import fr.telecom_st_etienne.fx.kanban.service.DeveloppeurService;

@Service
public class DeveloppeurServiceImpl implements DeveloppeurService {
	@Autowired
	private DeveloppeurDAO developpeurDao;
	
	@Override
	public List<Developpeur> recupererDeveloppeurs() {
		return developpeurDao.findAll();
	}
	
	
	public Developpeur ajouterDeveloppeur(String prenom, String nom,String email, Date date) {
		Developpeur developpeur = new Developpeur(prenom, nom, email, date);
		developpeurDao.save(developpeur);
		return developpeur;
		}
	
	@Override
	public Developpeur recupererDeveloppeur(Long id) {
		return developpeurDao.findOne(id);
	}

	@Override
	public void supprimerDeveloppeur(Developpeur developpeur) {
		developpeurDao.delete(developpeur);
	}
	@Override
	public Developpeur enregisterDeveloppeur(Developpeur developpeur) {
		return developpeurDao.save(developpeur);
	}


	@Override
	public Page<Developpeur> recupererDeveloppeurs(Pageable pageable) {
		return developpeurDao.findAll(pageable);	
	}
}
