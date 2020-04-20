package net.codejava.SpringBootWebApplication;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User implements UserType {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Override
	public String login() {
		// TODO Auto-generated method stub
		return "success";
	}

}
