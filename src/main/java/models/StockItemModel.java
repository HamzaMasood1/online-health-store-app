package models;

import org.springframework.data.repository.CrudRepository;

import entities.StockItem;

public interface StockItemModel extends CrudRepository<StockItem,Integer>{
	StockItem findByTitle(String title);
}
