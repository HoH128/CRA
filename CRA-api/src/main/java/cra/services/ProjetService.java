package cra.services;

import java.util.List;

import cra.model.Projet;


public interface ProjetService 
{
	List<Projet> findAllprojects();
	void addProject(String nomProjet, String entite, String responsable, String description);
}
