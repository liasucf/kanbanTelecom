package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.dao.TypeTacheDAO;
import fr.telecom_st_etienne.fx.kanban.service.TypeTacheService;

@Service
public class TypeTacheServiceImpl implements TypeTacheService {

	@Autowired 
	private TypeTacheDAO typeTacheDao;
	
	@Override
	public TypeTache ajouterTypeTache(String nom) {
		TypeTache typeTache = new TypeTache(nom);
		typeTacheDao.save(typeTache);
		return typeTache;
	}

	@Override
	public List<TypeTache> recupererTypeTaches() {
		return typeTacheDao.findAll();
		
	}

	@Override
	public TypeTache recupererTypeTache(Long id) {
		return typeTacheDao.findOne(id);

	}

	@Override
	public void supprimerTypeTache(TypeTache typeTache) {
			typeTacheDao.delete(typeTache);
		
	}

}
