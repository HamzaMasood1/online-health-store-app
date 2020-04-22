package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.StockItem;
import models.StockItemModel;

@Service
public class ItemService {
	@Autowired
private StockItemModel itemRepository;
	
	
	public List<StockItem>getAllItems(){
		List<StockItem>itemsList = new ArrayList<>();
	itemRepository.findAll().forEach(itemsList::add);
	return itemsList;
	}
	
	
	public StockItem getItem(int id) {
		return itemRepository.findById(id).get();
	}
}
