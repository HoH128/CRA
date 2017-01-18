package cra.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cra.dao.ProjetDao;
import cra.model.Projet;
import cra.services.ProjetService;

@Service
@Transactional
public class ProjetServiceImpl  implements ProjetService {
    
	@Autowired
	ProjetDao projetDao;

	@Override
	public List<Projet> findAllprojects() {
		return projetDao.findAllprojects();
	}

	@Override
	public void addProject(String nomProjet, String entite, String responsable, String description) {
		projetDao.addProject(nomProjet, entite, responsable, description);
	}
	
	@Override
	public void deleteProject(int idP) {
		projetDao.deleteProject(idP);
	}
	
}
