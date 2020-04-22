package sorting;

import java.util.ArrayList;
import java.util.Collections;

import entities.StockItem;

public class SortByCategory implements SortingStrategy {



	@Override
	public ArrayList<StockItem> ascendingSort(ArrayList<StockItem> items) {
		Collections.sort(items, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));

		return items;
	}

	@Override
	public ArrayList<StockItem> descendingSort(ArrayList<StockItem> items) {
		Collections.sort(items, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));
		Collections.reverse(items);
	
		return items;
	}
	

}