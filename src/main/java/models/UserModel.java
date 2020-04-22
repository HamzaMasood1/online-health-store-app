package models;

import org.springframework.data.repository.CrudRepository;

import entities.User;

public interface UserModel extends CrudRepository<User, Integer> {
	User findByName(String name);
	User findByPassword(String password);
	User findByEmail(String email);
}
