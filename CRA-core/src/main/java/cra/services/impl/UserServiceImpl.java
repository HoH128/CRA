package cra.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cra.dao.UserDao;
import cra.model.User;
import cra.services.UserService;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
    
	@Autowired
	UserDao userDao;

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public boolean getDBUser(String login, String password) {
		return userDao.getDBUser(login,password);
	}

	@Override
	public void addUser(String login, String nom, String password, String prenom, String email) {
		userDao.addUser(login, nom, password, prenom, email);
	}
	
}
