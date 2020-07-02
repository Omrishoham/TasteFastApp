package model;

import java.util.Date;

public class Manager extends Employee {

	public Manager(String username, String password,double salaryPerHour,double salarySum,String firstName,String lastName)
	{
		super(username, password,true,salaryPerHour,salarySum,firstName,lastName);
		this.dateObj=new Date();
		this.isManager = true;
	}
	public Manager(){
		
	}
	
	
}
