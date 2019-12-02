package fr.telecom_st_etienne.fx.kanban.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.service.ClientService;
import fr.telecom_st_etienne.fx.kanban.service.ColonneService;
import fr.telecom_st_etienne.fx.kanban.service.DeveloppeurService;
import fr.telecom_st_etienne.fx.kanban.service.ProjetService;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;
import fr.telecom_st_etienne.fx.kanban.service.TypeTacheService;

@Controller
@RequestMapping("/")
public class KanbanController {

	private TacheService tacheService;
	private ClientService clientService;
	private ColonneService colonneService;
	private DeveloppeurService developpeurService;
	private TypeTacheService typeTacheService;
	private ProjetService projetService;
	

	public KanbanController(TacheService tacheService, DeveloppeurService developpeurService, 
			TypeTacheService typeTacheService, ClientService clientService, 
			ColonneService colonneService, ProjetService projetService) {
		this.tacheService = tacheService;
		this.developpeurService = developpeurService;
		this.typeTacheService = typeTacheService;
		this.clientService = clientService;
		this.colonneService = colonneService;
		this.projetService = projetService;
	}

	@RequestMapping(value = { "/index", "/" })
	public ModelAndView accueil(Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		//Precisa a view como index (index.jsp)
		mav.setViewName("index");
		mav.addObject("taches", tacheService.recupererTaches());
		mav.addObject("colonnes", colonneService.recupererColonnes());
		return mav;
	}
	
	@RequestMapping(value = { "/developpeurs" })
	public ModelAndView dev(Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dev");
		mav.addObject("pageDedeveloppeurs", developpeurService.recupererDeveloppeurs(pageable));
		return mav;
	}
	
	  @GetMapping ("tache")
	  public ModelAndView ajouterTacheGet( @RequestParam("ID1") Long id ) {
	    ModelAndView mav = new ModelAndView();
		mav.setViewName("tache");
		mav.addObject("typeTaches", typeTacheService.recupererTypeTaches());
		mav.addObject("colonne", colonneService.recupererColonne(id));
		mav.addObject("developpeurs", developpeurService.recupererDeveloppeurs());
		mav.addObject("projet", projetService.recupererProjet((long) 1));
		return mav;
	  }
	@PostMapping ("ajoutTache")
	  public ModelAndView ajouterTachePost(
		@RequestParam("intitule") String intitule, 
		@RequestParam("heures") int nbHeuresPrevues,
		@RequestParam("developpeur") List<Long> developpeurs,
		@RequestParam("typeTache") Long typeTache,
		@RequestParam("idcol") Long id 
		) {
		Tache tache = tacheService.ajouterTache(intitule);
		Projet projet = projetService.recupererProjet((long) 1);
		tache.setProjet(projet);
		tache.setNbHeuresPrevues(nbHeuresPrevues);
		TypeTache tyTache = typeTacheService.recupererTypeTache(typeTache);
		tache.setTypeTache(tyTache);
		Colonne colonneActuelle = colonneService.recupererColonne(id);
		tache.setColonneActuelle(colonneActuelle);
		List <Developpeur> e = developpeurService.recupererDeveloppeurs() ;
		e.clear();
		for (int i = 0; i < developpeurs.size(); i++) {
			Developpeur dev = developpeurService.recupererDeveloppeur(developpeurs.get(i));
			e.add(dev);
			}
		tache.setDeveloppeurs(e);
		System.out.println(tache.getColonneActuelle());
		System.out.println(tache.getIntitule());
		System.out.println(tache.getNbHeuresPrevues());
		System.out.println(tache.getDeveloppeurs());
		System.out.println(tache.getTypeTache());
		System.out.println(tache.getId());
		System.out.println(tache.getProjet());
		
		return new ModelAndView("redirect:/");
	  }
	
	@PostConstruct
	public void init() {
		System.out.println("Dans init()");
		//créer 1 client
		 if (clientService.recupererClients().isEmpty()) {
			clientService.ajouterClient("Lia");}
		//Ajouter 1 projet nommé « Projet 1 »
		projetService.ajouterProjet("Projet 1");
		//4 types de tâches (« Fonctionnalité », « Bug », « Spike », « Amélioration »),
		typeTacheService.ajouterTypeTache("Fonctionnalité");
		typeTacheService.ajouterTypeTache("Bug");
		typeTacheService.ajouterTypeTache("Spike");
		typeTacheService.ajouterTypeTache("Amélioration");
		//4 colonnes (« À faire », « En cours », « À tester », « Terminé »)
		colonneService.ajouterColonne("À faire");
		colonneService.ajouterColonne("En cours");
		colonneService.ajouterColonne("À tester");
		colonneService.ajouterColonne("Terminé");
		//10 développeurs
		developpeurService.ajouterDeveloppeur("Bia");
		developpeurService.ajouterDeveloppeur("Lea");
		developpeurService.ajouterDeveloppeur("Leo");
		developpeurService.ajouterDeveloppeur("Tia");
		developpeurService.ajouterDeveloppeur("Gabi");
		developpeurService.ajouterDeveloppeur("Dudu");
		developpeurService.ajouterDeveloppeur("Kit");
		developpeurService.ajouterDeveloppeur("Rafa");
		developpeurService.ajouterDeveloppeur("Mandy");
		
		if (tacheService.recupererTaches().isEmpty()) {
			Colonne colonneActuelle = colonneService.recupererColonne((long) 1);
			Tache a = tacheService.ajouterTache("Développer Métier");
			a.setColonneActuelle(colonneActuelle);
			System.out.println(a.getColonneActuelle());
			Tache b = tacheService.ajouterTache("Développer DAO");
			b.setColonneActuelle(colonneActuelle);
			Tache c = tacheService.ajouterTache("Développer Services");
			c.setColonneActuelle(colonneActuelle);
			Tache d = tacheService.ajouterTache("Développer Contrôleur");
			d.setColonneActuelle(colonneActuelle);
			System.out.println(d.getColonneActuelle());
		}}
		
	
		
		
	
}