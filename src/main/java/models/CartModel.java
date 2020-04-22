package models;

import org.springframework.data.repository.CrudRepository;

import entities.Card;
public interface CartModel extends CrudRepository<Card, Integer>{
	Card findById(int id);
}
