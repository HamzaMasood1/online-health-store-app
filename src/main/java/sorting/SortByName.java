package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.StockItem;

public class SortByName implements SortingStrategy {

	@Override
	public ArrayList<StockItem> ascendingSort(ArrayList<StockItem> items) {
		// TODO Auto-generated method stub
		Collections.sort(items, 
                (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
		
		
		for(int i=0;i<items.size();i++ ) {
	  System.out.println(items.get(i).getTitle());
		}
		return items;
	}

	@Override
	public ArrayList<StockItem> descendingSort(ArrayList<StockItem> items) {
		// TODO Auto-generated method stub
		Collections.sort(items, 
                (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
		Collections.reverse(items);
		for(int i=0;i<items.size();i++ ) {
			  System.out.println(items.get(i).getTitle());
				}
		return items;
	}

	
	

}
