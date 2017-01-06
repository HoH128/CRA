package cra.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void addUser(User user) {
		
	}
}
