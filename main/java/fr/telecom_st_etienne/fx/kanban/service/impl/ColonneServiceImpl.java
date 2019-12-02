package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Client;
import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.dao.ColonneDAO;
import fr.telecom_st_etienne.fx.kanban.service.ColonneService;

@Service
public class ColonneServiceImpl implements ColonneService {
	@Autowired
	private ColonneDAO colonneDao;

	@Override
	public Colonne ajouterColonne(String nom) {
		Colonne colonne = new Colonne(nom);
		//Adcionar o meu objeto ao banco de dados
		colonneDao.save(colonne);
		return colonne;
	}
	public Colonne recupererColonne(Long id) {
		return colonneDao.findOne(id);
	}
	@Override
	public List<Colonne> recupererColonnes(){
		return colonneDao.findAll();
	}

}
