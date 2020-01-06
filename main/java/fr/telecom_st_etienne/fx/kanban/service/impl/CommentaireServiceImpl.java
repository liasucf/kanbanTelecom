package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Commentaire;
import fr.telecom_st_etienne.fx.kanban.dao.CommentaireDAO;
import fr.telecom_st_etienne.fx.kanban.service.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDAO commentaireDao;
	
	@Override
	public List<Commentaire> recupererCommentaires() {
		// TODO Auto-generated method stub
		return commentaireDao.findAll();
	}

	@Override
	public Commentaire ajouterCommentaire() {
		// TODO Auto-generated method stub
		Commentaire commentaire = new Commentaire();
		commentaireDao.save(commentaire);
		return commentaire;
		
	}

	@Override
	public Commentaire recupererCommentaire(Long id) {
		// TODO Auto-generated method stub
		return commentaireDao.findOne(id);
	}

	@Override
	public void supprimerCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		commentaireDao.delete(commentaire);
	}
	@Override
	public Commentaire enregisterCommentaire(Commentaire commentaire) {
		return commentaireDao.save(commentaire);
	}

}
