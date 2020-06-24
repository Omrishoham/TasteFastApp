package model;

import java.util.Date;

public class Manager extends Employee {

	public Manager(String username, String password,double salaryPerHour)
	{
		super(username, password,salaryPerHour);
		this.login_time=new Date();
		this.isManager = true;
	}
	public Manager(){
		
	}
	
	
}
