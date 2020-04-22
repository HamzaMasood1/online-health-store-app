package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import Cards.LoyaltyCardDiscount;


@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double total = 0.0;
	@ManyToMany
	List<StockItem> items = new ArrayList<>();

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, double total, List<StockItem> items) {
		super();
		this.id = id;
		this.total = total;
		this.items = items;
	}

	public double calcTotalCost() {

		for (StockItem item : items) {

			total += item.getPrice() * item.getInCartQuantity();
		}

		return total;
	}

	public double discount(LoyaltyCardDiscount method) {
		double totalCost = calcTotalCost();
		return method.discount(totalCost);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<StockItem> getItems() {
		return items;
	}

	public void setItems(List<StockItem> items) {
		this.items = items;
	}



}
