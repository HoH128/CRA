package cra.dao;

import java.util.List;

import cra.model.User;


public interface UserDao  {

	List<User> findAllUsers();
	boolean getDBUser (String login, String password);
	void addUser (User user);
}
