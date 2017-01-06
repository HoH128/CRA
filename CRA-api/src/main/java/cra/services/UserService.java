package cra.services;

import java.util.List;

import cra.model.User;


public interface UserService 
{
	List<User> findAllUsers();
	boolean getDBUser (String login, String password);
}
