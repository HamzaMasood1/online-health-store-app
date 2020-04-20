package net.codejava.SpringBootWebApplication;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Cart {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	@ManyToMany
	List<StockItem>items = new ArrayList<>();
}
