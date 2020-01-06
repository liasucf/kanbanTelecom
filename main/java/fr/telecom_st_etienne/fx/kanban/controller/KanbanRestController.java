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
	import fr.telecom_st_etienne.fx.kanban.business.Colonne;
	import fr.telecom_st_etienne.fx.kanban.business.Commentaire;
	import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
	import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;
	import fr.telecom_st_etienne.fx.kanban.business.Projet;
	import fr.telecom_st_etienne.fx.kanban.business.Tache;
	import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
	import fr.telecom_st_etienne.fx.kanban.service.ClientService;
	import fr.telecom_st_etienne.fx.kanban.service.ColonneService;
	import fr.telecom_st_etienne.fx.kanban.service.CommentaireService;
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
		@Autowired
		private CommentaireService commentaireService;
		
		/********************    CLIENT       **********************************/
	
	//Ajouter une client via service web (METHOD POST)
		@PostMapping("/clients/{nom}")
		public Client ajouterClient(@PathVariable String nom)
		{	
			System.out.println("Demande d'ajout d'une client");
			Client client = clientService.ajouterClient(nom);
			return client;
		}
		//View touts les clients via service web (METHOD GET)
		@GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Client> recupererClients()
		{
			logger.info("Appel à la méthode recupererTaches()");
		    return clientService.recupererClients();
		}
		// Méthode permettant de supprimer un client en précisant son id
		@DeleteMapping("/clients/{id}")
		public boolean effacerClients(@PathVariable Long id)
		{
			
			Client client = clientService.recupererClient(id);
			if (client == null) return false;
			clientService.supprimerClient(client);
			return true;
		}
		// Méthode permettant de mettre a jour un client en précisant son id
		@PutMapping("/clients/{id}")
		public Client mettreAJourClient(@PathVariable Long id )
		{
			Client client = clientService.recupererClient(id);
			clientService.enregisterClient(client);
			return client;
		}
		// Méthode permettant de recuperer un client en précisant son id
		@GetMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Client recupererClient(@PathVariable Long id)
		{
			logger.info("Appel à la méthode recupererClient()");
		    return clientService.recupererClient(id);
		}
	
	/********************    COLONNE       **********************************/
		
		//Ajouter une client via service web (METHOD POST)
		@PostMapping("/colonnes/{nom}")
		public Colonne ajouterColonne(@PathVariable String nom)
		{	
			System.out.println("Demande d'ajout d'une client");
			Colonne colonne = colonneService.ajouterColonne(nom);
			return colonne;
		}
		//View touts les clients via service web (METHOD GET)
		@GetMapping(value = "/colonnes", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Colonne> recupererColonnes()
		{
			logger.info("Appel à la méthode recupererTaches()");
		    return colonneService.recupererColonnes();
		}
		// Méthode permettant de supprimer un client en précisant son id
		@DeleteMapping("/colonnes/{id}")
		public boolean effacerColonnes(@PathVariable Long id)
		{
			
			Colonne colonne = colonneService.recupererColonne(id);
			if (colonne == null) return false;
			colonneService.supprimerColonne(colonne);
			return true;
		}
		// Méthode permettant de mettre a jour un client en précisant son id
		@PutMapping("/colonnes/{id}")
		public Colonne mettreAJourColonne(@PathVariable Long id )
		{
			Colonne colonne = colonneService.recupererColonne(id);
			colonneService.enregisterColonne(colonne);
			return colonne;
		}
		// Méthode permettant de recuperer un client en précisant son id
		@GetMapping(value = "/colonnes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Colonne recupererColonne(@PathVariable Long id)
		{
			logger.info("Appel à la méthode recupererClient()");
		    return colonneService.recupererColonne(id);
		}
	
	/********************    COMMENTAIRE       **********************************/
		//Ajouter une Commentaire via service web (METHOD POST)
		@PostMapping("/commentaires/{nom}")
		public Commentaire ajouterCommentaire(@PathVariable String nom)
		{	
			System.out.println("Demande d'ajout d'une Commentaire");
			Commentaire commentaire = commentaireService.ajouterCommentaire();
			return commentaire;
		}
		//View touts les Commentaires via service web (METHOD GET)
		@GetMapping(value = "/commentaires", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Commentaire> recupererCommentaires()
		{
			logger.info("Appel à la méthode recupererCommentaires()");
		    return commentaireService.recupererCommentaires();
		}
		// Méthode permettant de supprimer un Commentaire en précisant son id
		@DeleteMapping("/commentaires/{id}")
		public boolean effacerCommentaires(@PathVariable Long id)
		{
			
			Commentaire commentaire = commentaireService.recupererCommentaire(id);
			if (commentaire == null) return false;
			commentaireService.supprimerCommentaire(commentaire);
			return true;
		}
		// Méthode permettant de mettre a jour un Commentaire en précisant son id
		@PutMapping("/commentaires/{id}")
		public Commentaire mettreAJourCommentaire(@PathVariable Long id )
		{
			Commentaire commentaire = commentaireService.recupererCommentaire(id);
			commentaireService.enregisterCommentaire(commentaire);
			return commentaire;
		}
		// Méthode permettant de recuperer un Commentaire en précisant son id
		@GetMapping(value = "/commentaires/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Commentaire recupererCommentaire(@PathVariable Long id)
		{
			logger.info("Appel à la méthode recupererCommentaire()");
		    return commentaireService.recupererCommentaire(id);
		}
	
	/********************    HISTORIQUE DEPLACEMENT       **********************************/
	
		//Ajouter une historiqueDeplacement via service web (METHOD POST)
			@PostMapping("/historiqueDeplacement/{tache}/{colonne}/{date}")
			public HistoriqueDeplacement ajouterHistorique(@PathVariable Tache tache, @PathVariable Colonne colonne, @PathVariable  Date date)
			{	
				System.out.println("Demande d'ajout d'une client");
				HistoriqueDeplacement historiqueDeplacement = historiqueDeplacementService.ajouterHistory(tache, colonne, date);
				return historiqueDeplacement;
			}
			//View touts les historiqueDeplacements via service web (METHOD GET)
			@GetMapping(value = "/historiqueDeplacements", produces = MediaType.APPLICATION_JSON_VALUE)
			public List<HistoriqueDeplacement> recupererHistoriqueDeplacements()
			{
				logger.info("Appel à la méthode recupererHistory()");
			    return historiqueDeplacementService.recupererHistory();
			}
			// Méthode permettant de supprimer un historiqueDeplacement en précisant son id
			@DeleteMapping("/historiqueDeplacements/{id}")
			public boolean effacerHistoriqueDeplacements(@PathVariable Long id)
			{
				
				HistoriqueDeplacement historiqueDeplacement = historiqueDeplacementService.recupererHistoriqueDeplacement(id);
				if (historiqueDeplacement == null) return false;
				historiqueDeplacementService.supprimerHistoriqueDeplacement(historiqueDeplacement);
				return true;
			}
			// Méthode permettant de mettre a jour un historiqueDeplacement en précisant son id
			@PutMapping("/historiqueDeplacements/{id}")
			public HistoriqueDeplacement mettreAJourHistoriqueDeplacement(@PathVariable Long id )
			{
				HistoriqueDeplacement historiqueDeplacement = historiqueDeplacementService.recupererHistoriqueDeplacement(id);
				historiqueDeplacementService.enregisterHistoriqueDeplacement(historiqueDeplacement);
				return historiqueDeplacement;
			}
			// Méthode permettant de recuperer un historiqueDeplacement en précisant son id
			@GetMapping(value = "/historiqueDeplacements/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
			public HistoriqueDeplacement recupererHistoriqueDeplacement(@PathVariable Long id)
			{
				logger.info("Appel à la méthode recupererHistoriqueDeplacement()");
			    return historiqueDeplacementService.recupererHistoriqueDeplacement(id);
			}
	
	/********************    PROJET       **********************************/
	
			//Ajouter une TypeTache via service web (METHOD POST)
			@PostMapping("/typeTache/{nom}")
			public TypeTache ajouterTypeTache(@PathVariable String nom)
			{	
				System.out.println("Demande d'ajout d'une TypeTache");
				TypeTache typeTache = typeTacheService.ajouterTypeTache(nom);
				return typeTache;
			}
			//View touts les TypeTache via service web (METHOD GET)
			@GetMapping(value = "/typeTaches", produces = MediaType.APPLICATION_JSON_VALUE)
			public List<TypeTache> recupererTypeTaches()
			{
				logger.info("Appel à la méthode recupererTypeTache()");
			    return typeTacheService.recupererTypeTaches();
			}
			// Méthode permettant de supprimer un TypeTache en précisant son id
			@DeleteMapping("/typeTaches/{id}")
			public boolean effacerTypeTaches(@PathVariable Long id)
			{
				
				TypeTache typeTache = typeTacheService.recupererTypeTache(id);
				if (typeTache == null) return false;
				typeTacheService.supprimerTypeTache(typeTache);
				return true;
			}
			// Méthode permettant de mettre a jour un TypeTache en précisant son id
			@PutMapping("/typeTaches/{id}")
			public TypeTache mettreAJourTypeTache(@PathVariable Long id )
			{
				TypeTache typeTache = typeTacheService.recupererTypeTache(id);
				typeTacheService.enregisterTypeTache(typeTache);
				return typeTache;
			}
			// Méthode permettant de recuperer un TypeTache en précisant son id
			@GetMapping(value = "/typeTaches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
			public TypeTache recupererTypeTache(@PathVariable Long id)
			{
				logger.info("Appel à la méthode recupererTypeTache()");
			    return typeTacheService.recupererTypeTache(id);
			}
	
	/********************    TYPE TACHE       **********************************/
	
			//Ajouter une Projet via service web (METHOD POST)
			@PostMapping("/projet/{nom}")
			public Projet ajouterProjet(@PathVariable String nom)
			{	
				System.out.println("Demande d'ajout d'une Projet");
				Projet projet = projetService.ajouterProjet(nom);
				return projet;
			}
			//View touts les Projet via service web (METHOD GET)
			@GetMapping(value = "/projets", produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Projet> recupererProjets()
			{
				logger.info("Appel à la méthode recupererProjet()");
			    return projetService.recupererProjets();
			}
			// Méthode permettant de supprimer un Projet en précisant son id
			@DeleteMapping("/projets/{id}")
			public boolean effacerProjets(@PathVariable Long id)
			{
				
				Projet projet = projetService.recupererProjet(id);
				if (projet == null) return false;
				projetService.supprimerProjet(projet);
				return true;
			}
			// Méthode permettant de mettre a jour un Projet en précisant son id
			@PutMapping("/projets/{id}")
			public Projet mettreAJourProjet(@PathVariable Long id )
			{
				Projet projet = projetService.recupererProjet(id);
				projetService.enregisterProjet(projet);
				return projet;
			}
			// Méthode permettant de recuperer un Projet en précisant son id
			@GetMapping(value = "/projets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
			public Projet recupererProjet(@PathVariable Long id)
			{
				logger.info("Appel à la méthode recupererProjet");
			    return projetService.recupererProjet(id);
			}
	
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