package cra.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cra.dao.ProjetDao;
import cra.model.Projet;


@Repository
public class ProjetDaoImpl implements ProjetDao  {

	/** The EntityManager. */
	@PersistenceContext(unitName = "craUnit")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Projet> findAllprojects() {
		List<Projet> list = new ArrayList<>();
		try {
			list = (List<Projet>) em.createNamedQuery("get.all.projects", Projet.class).getResultList();
		} catch (Exception e) {
			System.out.println("");
		}
		return list;
	}

	@Override
    public void addProject(String nomProjet, String entite, String responsable, String description) {
		try {
		Projet projet = new Projet();
		projet.setNomProjet(nomProjet);
		projet.setEntite(entite);
		projet.setResponsable(responsable);
		projet.setDescription(description);
		em.persist(projet);
		em.getTransaction().commit();
		//em.close();
		} catch (Exception e) {
			System.out.println("");
		}
	}
	
}
