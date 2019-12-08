package fr.telecom_st_etienne.fx.kanban.service;

import java.util.Date;
import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Commentaire;

public interface CommentaireService {

	List<Commentaire> recupererCommentaires();
	Commentaire ajouterCommentaire();
	Commentaire recupererCommentaire(Long id);
	void supprimerCommentaire(Commentaire commentaire);
}
