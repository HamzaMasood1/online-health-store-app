package net.codejava.SpringBootWebApplication;

import java.util.ArrayList;

import entities.User;

public class UserList implements Container {
	
	public ArrayList<User> customers;
	
	 public UserList(ArrayList<User> customersList) {
		  customers = customersList;
	 }
	 
	 
	public Iterator getIterator() {
		return new CustomerIterator();
	}
	

	private class CustomerIterator implements Iterator {
		int index;

		public boolean hasNext() {
			if (index < customers.size()) {
				return true;
			}
			return false;
		}

		public Object next() {
			if (this.hasNext()) {
				return customers.get(index++);
			}
			return null;
		}
	}
}