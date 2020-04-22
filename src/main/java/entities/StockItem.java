package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.codejava.SpringBootWebApplication.StockState;

@Entity
public class StockItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double price;
	private String category;
	private String image;
	private boolean itemState;
	private int quantity;
	private String title;
	private String manufacturer;
	private int inCartQuantity;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    List<Comment>comments = new ArrayList<>();

	
	
	public StockItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public StockItem( String title, String manufacturer, Double price, String category, boolean itemState, int quantity, String image) {
		super();
		//this.id = id;
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.setImage(image);
		this.itemState = itemState;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isItemState() {
		return itemState;
	}

	public void setItemState(boolean itemState) {
		this.itemState = itemState;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public int getInCartQuantity() {
		return inCartQuantity;
	}



	public void setInCartQuantity(int inCartQuantity) {
		this.inCartQuantity = inCartQuantity;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	public Boolean stateOfStock(StockState state) {
		return state.stateOfStock();
	}
	
	
}
