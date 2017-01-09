package cra.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cra.dao.UserDao;
import cra.model.User;


@Repository
public class UserDaoImpl implements UserDao  {

	/** The EntityManager. */
	@PersistenceContext(unitName = "craUnit")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		List<User> list = new ArrayList<>();
		try {
			list = (List<User>) em.createNamedQuery("get.all.users", User.class).getResultList();
		} catch (Exception e) {
			System.out.println("Error ");
		}
		return list;
	}

	@Override
	public boolean getDBUser(String login, String password) { 
		try {
		User user = em.createNamedQuery("login.control", User.class).setParameter("login", login).setParameter("password", password).getSingleResult();
		if(user!=null){
			return true;
		}
		} catch (Exception e) {
			System.out.println("User not found!");
		}
		return false;
	}

	@Override
    public void addUser(String login, String nom, String password, String prenom, String email) {
		try {
			User user = new User();
			user.setLogin(login);
			user.setNom(nom);
			user.setPassword(password);
			user.setPrenom(prenom);
			user.setEmail(email);
			em.persist(user);
			em.getTransaction().commit();
			//em.close();
		} catch (Exception e) {
			
		}
	}
	
}
