package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entities.StockItem;

public class SortByPrice implements SortingStrategy {


	@Override
	public ArrayList<StockItem> ascendingSort(ArrayList<StockItem> items) {
		Collections.sort(items, new Comparator<StockItem>() {
		    @Override
		    public int compare(StockItem c1, StockItem c2) {
		        return Double.compare(c1.getPrice(), c2.getPrice());
		    }
		});
		
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getPrice());
		}

		return items;
	}

	@Override
	public ArrayList<StockItem> descendingSort(ArrayList<StockItem> items) {
		Collections.sort(items, new Comparator<StockItem>() {
		    @Override
		    public int compare(StockItem c1, StockItem c2) {
		        return Double.compare(c1.getPrice(), c2.getPrice());
		    }
		});
		Collections.reverse(items);
		
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getPrice());
		}
		return items;
	}


}