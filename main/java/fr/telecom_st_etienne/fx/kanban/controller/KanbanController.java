package fr.telecom_st_etienne.fx.kanban.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.service.ClientService;
import fr.telecom_st_etienne.fx.kanban.service.ColonneService;
import fr.telecom_st_etienne.fx.kanban.service.DeveloppeurService;
import fr.telecom_st_etienne.fx.kanban.service.HistoriqueDeplacementService;
import fr.telecom_st_etienne.fx.kanban.service.ProjetService;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;
import fr.telecom_st_etienne.fx.kanban.service.TypeTacheService;

@Controller
@RequestMapping("/")
public class KanbanController {

	private ClientService clientService;
	private ProjetService projetService;
	private TypeTacheService typeTacheService;
	private TacheService tacheService;
	private ColonneService colonneService;
	private DeveloppeurService developpeurService;
	private HistoriqueDeplacementService historiqueDeplacementService;
	
	public KanbanController(ClientService clientService, ProjetService projetService, TypeTacheService typeTacheService, TacheService tacheService, ColonneService colonneService, 
			DeveloppeurService developpeurService,HistoriqueDeplacementService historiqueDeplacementService ) {
		super();
		this.clientService = clientService;
		this.projetService = projetService;
		this.typeTacheService = typeTacheService;
		this.tacheService = tacheService;
		this.colonneService = colonneService;
		this.developpeurService = developpeurService;
		this.historiqueDeplacementService = historiqueDeplacementService;
	}

	@RequestMapping(value = { "/index", "/" })
	public ModelAndView accueil(Pageable pageable) {
		ModelAndView mav = new ModelAndView("index");	
		mav.addObject("taches", tacheService.recupererTaches());
		mav.addObject("colonnes",colonneService.recupererColonnes());
		mav.addObject("histories",historiqueDeplacementService.recupererHistory());
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
		
		Projet projet = projetService.recupererProjet((long) 1);
		TypeTache tyTache = typeTacheService.recupererTypeTache(typeTache);
		Colonne colonneActuelle = colonneService.recupererColonne(id);
		List <Developpeur> e = developpeurService.recupererDeveloppeurs() ;
		e.clear();
		for (int i = 0; i < developpeurs.size(); i++) {
			Developpeur dev = developpeurService.recupererDeveloppeur(developpeurs.get(i));
			e.add(dev);
			}
		
		tacheService.ajouterTache(intitule,colonneActuelle, nbHeuresPrevues, e, tyTache,projet );
	
	return new ModelAndView("redirect:/");
	  }
	
	@GetMapping("moveCard")
	public ModelAndView deplacementGet(@RequestParam("IDC") Long idColonne,@RequestParam("IDT") Long idTache) {
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis); 
		tacheService.changeColonne(tacheService.recupererTache(idTache), colonneService.recupererColonne(idColonne));
		historiqueDeplacementService.ajouterHistory(tacheService.recupererTache(idTache),colonneService.recupererColonne(idColonne),date);
		return accueil(new PageRequest(0, 10));
	}
	
	@RequestMapping(value = { "/developpeurs" })
	public ModelAndView dev(@PageableDefault(size = 8)  @SortDefault.SortDefaults({
        @SortDefault(sort = "nom"),
        @SortDefault(sort = "prenom"),
        @SortDefault(sort = "email"),
        @SortDefault(sort = "dateDebutContrat")
    }) Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dev");
		mav.addObject("pageDedeveloppeurs", developpeurService.recupererDeveloppeurs(pageable));
		return mav;
	}
	
	@PostConstruct
	public void init() throws ParseException {
		System.out.println("Dans init()");
		//créer 1 client
		 if (clientService.recupererClients().isEmpty()) {
			clientService.ajouterClient("Lia");}
		//Ajouter 1 projet nommé « Projet 1 »
		projetService.ajouterProjet("Projet 1");
		//4 types de tâches (« Fonctionnalité », « Bug », « Spike », « Amélioration »),
		if (typeTacheService.recupererTypeTaches().isEmpty()){
		typeTacheService.ajouterTypeTache("Fonctionnalité");
		typeTacheService.ajouterTypeTache("Bug");
		typeTacheService.ajouterTypeTache("Spike");
		typeTacheService.ajouterTypeTache("Amélioration");
		}
		//4 colonnes (« À faire », « En cours », « À tester », « Terminé »)

		if(colonneService.recupererColonnes().isEmpty()) {
			colonneService.ajouterColonne("A faire");
			colonneService.ajouterColonne("En cours");
			colonneService.ajouterColonne("A tester");
			colonneService.ajouterColonne("Terminé");
		}
		if(developpeurService.recupererDeveloppeurs().isEmpty()) {
			developpeurService.ajouterDeveloppeur("Bia","Feijo","bia@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("06/12/2019") );
			developpeurService.ajouterDeveloppeur("Lea","Pereira", "lea@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("06/10/2019"));
			developpeurService.ajouterDeveloppeur("Leo","Siqueira","leo@gmail.com",new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019") );
			developpeurService.ajouterDeveloppeur("Tia", "Li","tia@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("06/08/2019"));
			developpeurService.ajouterDeveloppeur("Gabi", "Atan","gabi@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("06/02/2019"));
			developpeurService.ajouterDeveloppeur("Dudu","Mato","dudu@gmail.com" , new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2019"));
			developpeurService.ajouterDeveloppeur("Kit", "Hello", "kit@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("16/10/2018"));
			developpeurService.ajouterDeveloppeur("Rafa","Melo","rafa@gmail.com",new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2017") );
			developpeurService.ajouterDeveloppeur("Mandy","Kubrusly", "mandy@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("06/03/2015"));
			
			for (int i = 0; i < 10; i++) {
				developpeurService.ajouterDeveloppeur("Mandi"+i,"Kubru"+i, "mandy"+i+"@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("06/"+i+"/2015") );
			}
			
		}
		if (tacheService.recupererTaches().isEmpty()) {
			List<Developpeur> myList = new ArrayList<Developpeur>();
			myList.add(developpeurService.recupererDeveloppeur(1L));
			myList.add(developpeurService.recupererDeveloppeur(2L));
			tacheService.ajouterTache("Développer Métier", colonneService.recupererColonne((long) 1), 0,myList , typeTacheService.recupererTypeTache(1L), null);
			tacheService.ajouterTache("Développer DAO", colonneService.recupererColonne((long) 2), 0, myList, typeTacheService.recupererTypeTache(2L), null);
			tacheService.ajouterTache("Développer Services", colonneService.recupererColonne((long) 3), 0, myList, typeTacheService.recupererTypeTache(3L), null);
			tacheService.ajouterTache("Développer Contrôleur", colonneService.recupererColonne((long) 1), 0,myList, typeTacheService.recupererTypeTache(4L), null);
			
		}
		
	}
	
	
	
	public void initBinder() {
		
	}
	
}





	
