package cra.dao;

import java.util.List;

import cra.model.User;


public interface UserDao  {

	List<User> findAllUsers();
	boolean getDBUser(String login, String password);
	void addUser(String login, String nom, String password, String prenom, String email);
	boolean addUser(User user);
}
