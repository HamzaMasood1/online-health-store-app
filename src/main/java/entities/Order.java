package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	String name;
	@OneToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH
        })
	Cart cart;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String name, Cart cart) {
		super();
		this.id = id;
		this.name = name;
		this.cart = cart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
