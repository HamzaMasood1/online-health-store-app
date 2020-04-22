package sorting;

import java.util.ArrayList;
import java.util.List;

import entities.StockItem;

public interface SortingStrategy {
	
	
	public ArrayList<StockItem> ascendingSort(ArrayList<StockItem>items);
	public ArrayList<StockItem> descendingSort(ArrayList<StockItem>items);

}
