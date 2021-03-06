package net.codejava.SpringBootWebApplication.model;

import org.springframework.data.repository.CrudRepository;

import entities.Order;

public interface OrderModel extends CrudRepository<Order,Integer>{
	Order findByName(String name);
}
