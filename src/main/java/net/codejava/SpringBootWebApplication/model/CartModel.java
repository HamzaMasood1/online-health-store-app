package net.codejava.SpringBootWebApplication.model;

import org.springframework.data.repository.CrudRepository;

import entities.Card;
public interface CartModel extends CrudRepository<Card, Integer>{
	Card findById(int id);
}
