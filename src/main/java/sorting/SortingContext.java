package sorting;

import java.util.ArrayList;
import java.util.Collections;

import entities.StockItem;

public class SortingContext {

	
private SortingStrategy strategy;
	
	public void setSortingMethod(SortingStrategy strategy) {
		this.strategy = strategy;
	}
	
	public SortingStrategy getStrategy() {
		return strategy;
	}
	
	
	public ArrayList<StockItem> ascendingSort(ArrayList<StockItem> items) {
		return strategy.ascendingSort(items);
	}


	public ArrayList<StockItem> descendingSort(ArrayList<StockItem> items) {
		// TODO Auto-generated method stub
		
		return strategy.descendingSort(items);
	}
	
}
