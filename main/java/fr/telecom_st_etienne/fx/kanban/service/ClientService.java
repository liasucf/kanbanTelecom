package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import fr.telecom_st_etienne.fx.kanban.business.Client;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.dao.ClientDAO;

public interface ClientService {
	
	public Client ajouterClient(String nom);

	List<Client> recupererClients();

	


}
