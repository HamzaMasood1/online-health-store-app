package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Order;
import models.OrderModel;

@Service
public class OrderService {	
	@Autowired
	private OrderModel orderRepository;
	public List<Order>getAllOrders(){
		List<Order>orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

}
