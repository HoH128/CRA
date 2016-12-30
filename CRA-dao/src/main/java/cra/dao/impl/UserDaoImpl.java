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
			list = (List<User>) ((EntityManager) em).createQuery(
					"SELECT t from User t").getResultList();
		} catch (Exception e) {
			System.out.println("Error ");
		}


		return list;

	}
}
