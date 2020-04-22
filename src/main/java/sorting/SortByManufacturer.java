package sorting;

import java.util.ArrayList;
import java.util.Collections;

import entities.StockItem;

public class SortByManufacturer implements SortingStrategy {

	

	@Override
	public ArrayList<StockItem> ascendingSort(ArrayList<StockItem> items) {
		Collections.sort(items, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));

		return items;

	}

	@Override
	public ArrayList<StockItem> descendingSort(ArrayList<StockItem> items) {
		// TODO Auto-generated method stub
		Collections.sort(items, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
		Collections.reverse(items);
		
		return items;
	}

}
