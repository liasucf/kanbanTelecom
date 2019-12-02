package fr.telecom_st_etienne.fx.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.telecom_st_etienne.fx.kanban.business.Colonne;

public interface ColonneDAO extends JpaRepository<Colonne, Long> {

}
