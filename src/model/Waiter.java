package model;

import java.util.Date;

public class Waiter extends Employee {
	
	public Waiter(String username, String password,double salaryPerHour) {
		super(username, password,salaryPerHour);
		this.login_time=new Date();
		
	}



}
