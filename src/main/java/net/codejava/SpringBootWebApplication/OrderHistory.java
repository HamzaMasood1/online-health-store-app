package net.codejava.SpringBootWebApplication;

import java.util.ArrayList;

import entities.Order;

public class OrderHistory implements Container{
	
	public ArrayList<Order>orders;
	
	public OrderHistory(ArrayList<Order>orderList) {
		orders = orderList;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new OrderIterator();
	}
	
	private class OrderIterator implements  Iterator{
		int index;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < orders.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()) {
				return orders.get(index ++);
			}
			return null;
		}
	}

}
