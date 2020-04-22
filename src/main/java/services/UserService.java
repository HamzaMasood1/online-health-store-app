package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import models.UserModel;
@Service
public class UserService {
	@Autowired
	private UserModel userRepo;
	
	public User register(String name, String password, String email, String address) {
		
		
		List<User>users = new ArrayList<>();
		
		userRepo.findAll().forEach(users::add);
		User user = new User(name,email,password,address);

		for(int i =0; i< users.size();i++) {
			if(user.getEmail().equals(users.get(i).getEmail()) && user.getPassword().equals(users.get(i).getPassword())) {
				return null;
			}
		}
		return user;	
	}
	
	public User login(String name, String password) {
		User u = this.getUserName(name);
		if(u != null && u.getName().equals(name) && u.getPassword().equals(password)) {
			return u;
		}
		return null;
	}
	
	public List<User>getAllUsers(){
		List<User>users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users;
	}

	public User getUser(int id) {
		return userRepo.findById(id).get();
	}
	
	public User getUserName(String name) {
		return userRepo.findByName(name);
	}
	
	public User getEmail(String email) {
		return userRepo.findByEmail(email);
	}
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser(int id, User user) {
		userRepo.save(user);
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
}
