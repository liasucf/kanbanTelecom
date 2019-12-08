package fr.telecom_st_etienne.fx.kanban.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.telecom_st_etienne.fx.kanban.business.Client;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.service.ClientService;
import fr.telecom_st_etienne.fx.kanban.service.ColonneService;
import fr.telecom_st_etienne.fx.kanban.service.DeveloppeurService;
import fr.telecom_st_etienne.fx.kanban.service.HistoriqueDeplacementService;
import fr.telecom_st_etienne.fx.kanban.service.ProjetService;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;
import fr.telecom_st_etienne.fx.kanban.service.TypeTacheService;

@RestController
@RequestMapping("/ws/")
public class KanbanRestController {

	private static final Logger logger = LogManager.getLogger(Logger.class.getName());

	@Autowired
	private TacheService tacheService;
	@Autowired
	private DeveloppeurService developpeurService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProjetService projetService;
	@Autowired
	private TypeTacheService typeTacheService;
	@Autowired
	private ColonneService colonneService;
	@Autowired
	private HistoriqueDeplacementService historiqueDeplacementService;
	
	/********************    CLIENT       **********************************/

	//Ajouter une developpeur via service web (METHOD POST)
		@PostMapping("/clients/{nom}")
		public Client ajouterClient(@PathVariable String nom)
		{	
			System.out.println("Demande d'ajout d'une client");
			Client client = clientService.ajouterClient(nom);
			return client;
		}
		//View touts les developpeurs via service web (METHOD GET)
		@GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Client> recupererClients()
		{
			logger.info("Appel à la méthode recupererTaches()");
		    return clientService.recupererClients();
		}
		// Méthode permettant de supprimer un developpeur en précisant son id
		@DeleteMapping("/clients/{id}")
		public boolean effacerClients(@PathVariable Long id)
		{
			Developpeur developpeurs = developpeurService.recupererDeveloppeur(id);
			if (developpeurs == null) return false;
			developpeurService.supprimerDeveloppeur(developpeurs);
			return true;
		}
		// Méthode permettant de mettre a jour un developpeur en précisant son id
		@PutMapping("/developpeurs/{id}")
		public Developpeur mettreAJourDeveloppeur(@PathVariable Long id )
		{
			Developpeur developpeur = developpeurService.recupererDeveloppeur(id);
			developpeurService.enregisterDeveloppeur(developpeur);
			return developpeur;
		}
		// Méthode permettant de recuperer un developpeur en précisant son id
		@GetMapping(value = "/developpeurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Developpeur recupererDeveloppeur(@PathVariable Long id)
		{
			logger.info("Appel à la méthode recupererTache()");
		    return developpeurService.recupererDeveloppeur(id);
	
	
	
	
	
	
	
	/********************    COLONNE       **********************************/

	
	
	
	
	
	
	
	
	/********************    COMMENTAIRE       **********************************/

	
	
	
	
	
	
	
	
	
	
	/********************    HISTORIQUE DEPLACEMENT       **********************************/
	
	
	
	
	
	
	
	
	/********************    PROJET       **********************************/
	
	
	
	
	
	/********************    TYPE TACHE       **********************************/
	
	
	
	
	
	
	
	/********************    DEVELOPPEURS       **********************************/
	//Ajouter une developpeur via service web (METHOD POST)
	@PostMapping("/developpeurs/{prenom}/{nom}/{email}/{date}")
	public Developpeur ajouterDeveloppeur(@PathVariable String prenom, @PathVariable String nom, @PathVariable String email,
			@PathVariable Date date)
	{	
		System.out.println("Demande d'ajout d'une developpeur");
		Developpeur developpeur = developpeurService.ajouterDeveloppeur(prenom, nom, email, date);
		return developpeur;
	}
	//View touts les developpeurs via service web (METHOD GET)
	@GetMapping(value = "/developpeurs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Developpeur> recupererDeveloppeurs()
	{
		logger.info("Appel à la méthode recupererTaches()");
	    return developpeurService.recupererDeveloppeurs();
	}
	// Méthode permettant de supprimer un developpeur en précisant son id
	@DeleteMapping("/developpeurs/{id}")
	public boolean effacerDeveloppeurs(@PathVariable Long id)
	{
		Developpeur developpeurs = developpeurService.recupererDeveloppeur(id);
		if (developpeurs == null) return false;
		developpeurService.supprimerDeveloppeur(developpeurs);
		return true;
	}
	// Méthode permettant de mettre a jour un developpeur en précisant son id
	@PutMapping("/developpeurs/{id}")
	public Developpeur mettreAJourDeveloppeur(@PathVariable Long id )
	{
		Developpeur developpeur = developpeurService.recupererDeveloppeur(id);
		developpeurService.enregisterDeveloppeur(developpeur);
		return developpeur;
	}
	// Méthode permettant de recuperer un developpeur en précisant son id
	@GetMapping(value = "/developpeurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Developpeur recupererDeveloppeur(@PathVariable Long id)
	{
		logger.info("Appel à la méthode recupererTache()");
	    return developpeurService.recupererDeveloppeur(id);
	}
	/********************    TACHES       **********************************/

		//Effacer  avec le method DELETE
	@PostMapping
	public List<Tache> tachesGet()
	{
		return tacheService.recupererTaches();
	}
	//Ajouter une tache via service web (METHOD POST)
	@PostMapping("/taches")
	public Tache ajouterTache()
	{
		Tache tache = tacheService.ajouterTache("TestmeHoney", null, 0, null, null, null);
		return tache;
	}
	@PostMapping("/taches/{intitule}")
	public Tache ajouterTache(@PathVariable String intitule)
	{	
		System.out.println("Demande d'ajout d'une tache");
		Tache tache = tacheService.ajouterTache(intitule, null, 0, null, null, null);
		return tache;
	}
	// Méthode permettant de supprimer une tâche en précisant son id

	@DeleteMapping("/taches/{id}")
	public boolean effacerTache(@PathVariable Long id)
	{
		Tache tache = tacheService.recupererTache(id);
		if (tache== null) return false;
		tacheService.supprimerTache(tache);
		return true;
	}
	@PutMapping("/taches/{id}/{nouvelIntitule}")
	public Tache mettreAJourTache(@PathVariable Long id,@PathVariable String nouvelIntitule )
	{
		Tache tache = tacheService.recupererTache(id);
		tache.setIntitule(nouvelIntitule);
		tacheService.enregisterTache(tache);
		return tache;
	}
	// Méthode permettant d’obtenir toutes les tâches dont l’intitulé contient le mot précisé 
	// dans l’URL
	@GetMapping(value = "/taches", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tache> recupererTaches()
	{
		logger.info("Appel à la méthode recupererTaches()");
	    return tacheService.recupererTaches();
	}

	// Méthode permettant d’obtenir toutes les tâches dont l’intitulé contient le mot précisé 
	// dans l’URL
	@GetMapping(value = "/taches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tache recupererTache(@PathVariable Long id)
	{
		logger.info("Appel à la méthode recupererTache()");
	    return tacheService.recupererTache(id);
	}


	@PostMapping(value="/taches/{intitule}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tache tachePost(@PathVariable String intitule) {
		Tache tache = new Tache();
		tache.setIntitule(intitule);
		return tache;
	}
	
	public Tache tachePostAvecParametre(@RequestParam("intitule") String intitule) {
		Tache tache = new Tache();
		tache.setIntitule(intitule);
		return tache;		
	}
	
	
	// Méthode permettant d’obtenir toutes les tâches dont l’intitulé contient le mot précisé 
	// dans l’URL
	@GetMapping(value = "/tachesFiltrees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tache> recupererTachesFiltrees(@RequestParam String filtre)
	{
		List<Tache> tachesFiltrees = new ArrayList<>();
	    for (Tache tache : tacheService.recupererTaches()) {
	      if (tache.getIntitule().contains(filtre)) {
	        tachesFiltrees.add(tache);
	      }
	    }
	    return tachesFiltrees;
	}

	@ResponseBody
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public String handleHttpMediaTypeNotAcceptableException() {
	    return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
	}

}