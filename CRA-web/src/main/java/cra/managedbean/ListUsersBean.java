package cra.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cra.model.User;
import cra.services.UserService;

@Component
@ManagedBean
@Scope("request")
public class ListUsersBean {

	User user;	
	List<User> users = new ArrayList<>();
	
	@Autowired
	UserService userService;	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@PostConstruct
	public void init() {
		user = new User();
		users = getAllUsers();
	}
	 
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	public void addUser(){
		userService.addUser(user.getLogin(), user.getNom(), user.getPassword(), user.getPrenom(), user.getEmail());
		users = getAllUsers();
	}
	
}

