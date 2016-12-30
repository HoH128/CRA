package cra.dao;

import java.util.List;

import cra.model.User;


public interface UserDao  {

	List<User> findAllUsers();
	
	
}
