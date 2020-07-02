package model;

import java.util.Date;

import javax.swing.table.TableStringConverter;

public class Waiter extends Employee {
	
	public Waiter(String username, String password,double salaryPerHour,double salarySum,String firstName,String lastName) {
		super(username, password,false,salaryPerHour,salarySum,firstName,lastName);
		this.dateObj=new Date();
		this.isManager = false;
		
	}
	public Waiter() {}




}
