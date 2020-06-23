package model;

import java.util.Date;

public class Employee implements User {
	protected String username;
	protected String password;
	protected double salaryPerHour;
	protected Date login_time;
	protected boolean isManager;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String username, String password,double salaryPerHour)
	{
		this.username = username;
		this.password = password;
		this.salaryPerHour = salaryPerHour;
	}

	
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	public double getsalaryPerHour() 
	{
		return this.salaryPerHour;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setSalaryPerHour(double salary)
	{
		this.salaryPerHour = salary;;
	}
	public void setLoginTime()
	{
		this.login_time=new Date();
	}
	public boolean getIsManager()
	{
		return this.isManager;
	}
	public void setIsManager(boolean bol)
	{
		this.isManager = bol;
	}
	
	
//On log out will calculate the total income of the shift for the employee
	public double calcWorkTime() 
	{
		
		//"new" get the time now
		Date end_working=new Date();
		
		//calculate the time from login until logout
		double total_time=end_working.getTime()-login_time.getTime();
		
		//calculate the amount of minutes in the work
		total_time=total_time/1000/60;
		
		//calculate of wages per minute of the employee
		double salary_per_minute=salaryPerHour/60;
		
		//calculate of wages for that day
		double total=total_time*salary_per_minute;
		
		return total;
	}
}


