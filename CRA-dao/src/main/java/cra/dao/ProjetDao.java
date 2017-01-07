package cra.dao;

import java.util.List;

import cra.model.Projet;


public interface ProjetDao  {

	List<Projet> findAllprojects();
	void addProject(String nomProjet, String entite, String responsable, String description);
}
