package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Client;
import fr.telecom_st_etienne.fx.kanban.dao.ClientDAO;
import fr.telecom_st_etienne.fx.kanban.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDao;
	
	public Client ajouterClient(String nom) {
		Client client = new Client(nom);
		clientDao.save(client);
		return client;}

	@Override
	public List<Client> recupererClients(){
		return clientDao.findAll();
	}

	@Override
	public Client recupererClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerClient(Client client) {
		// TODO Auto-generated method stub
		clientDao.delete(client);
	}
	@Override
	public Client enregisterClient(Client client) {
		return clientDao.save(client);
	}

}
