package fr.telecom_st_etienne.fx.kanban.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.telecom_st_etienne.fx.kanban.business.Tache;

public interface TacheDao extends JpaRepository<Tache, Long> {

	List<Tache> findTacheByIntituleStartingWith(String intitule);
	
	List<Tache> findTacheByDateCreationBetween(Date dateDebut, Date dateFin);
	
}