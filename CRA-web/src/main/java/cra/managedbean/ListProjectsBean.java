package cra.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cra.model.Projet;
import cra.services.ProjetService;

@Component
@ManagedBean
@Scope("request")
public class ListProjectsBean {

	Projet projet;	
	List<Projet> projets = new ArrayList<>(); 
	
	@Autowired
	ProjetService projetService;
	
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}	

	@PostConstruct
	public void init() {
		projet = new Projet();
		projets = getAllProjets();
	}
	 
	public List<Projet> getProjets(){
		return projets;
	}
	
	public List<Projet> getAllProjets(){
		return projetService.findAllprojects();
	}
	
	public void addProjet(){
		projetService.addProject(projet.getNomProjet(), projet.getEntite(), projet.getResponsable(), projet.getDescription());
		projets = getAllProjets();
	}
	
}

