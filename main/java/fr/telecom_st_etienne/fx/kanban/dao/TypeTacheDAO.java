package fr.telecom_st_etienne.fx.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.telecom_st_etienne.fx.kanban.business.TypeTache;

public interface TypeTacheDAO extends JpaRepository<TypeTache, Long> {

}
