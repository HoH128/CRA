package cra.managedbean;

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
public class AuthentificationBean {

	User user;
	
	@Autowired
	UserService userService;	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@PostConstruct
	private void init() {
		user = new User();
	}
	
	public String doLogin(){
		if(userService.getDBUser(user.getLogin(), user.getPassword()))
			return "/List_users.xhtml";
		else	
			return "/index.xhtml";
	}
	 
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	public String formAdd(){
		return "/addUser.xhtml";
	}
	
	/*public String addUser(){
		if(userService.addUser(user))
			return "/List_users.xhtml";
		return "/addUser.xhtml";
	}*/
	
	public String addUser(){
		userService.addUser(user.getLogin(), user.getNom(), user.getPassword(), user.getPrenom(), user.getEmail());
		return "/List_users.xhtml";
	}
	
	public String resetAdd(){
		return "/addUser.xhtml";
	}
}

