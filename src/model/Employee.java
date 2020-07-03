package model;

import java.util.Date;

public class Employee implements User {
	protected String username;
	protected String password;
	protected double salaryPerHour;
	protected Date dateObj;
	protected boolean isManager;
	protected double salarySum;
	protected String firstName;
	protected String lastName;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String username, String password,boolean isManager,double salaryPerHour,double salarySum,String firstName,String lastName)
	{
		this.username = username;
		this.password = password;
		this.salaryPerHour = salaryPerHour;
		this.salarySum = salarySum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isManager = isManager;
	}
	
	//to pull from database all employees
	public Employee(String username,String firstName,String lastName,boolean isManager) {
		this.username = username;
		this.firstName = firstName;
		this.lastName= lastName;
		this.isManager = isManager;
		
	}

	
	
	
	
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	public double getSalaryPerHour() 
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
	public boolean getIsManager()
	{
		return this.isManager;
	}
	public void setIsManager(boolean bol)
	{
		this.isManager = bol;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public double getSalarySum() {
		return this.salarySum;
	}
	
	
//On log out will calculate the total income of the shift for the employee
	public double calcWorkTime() 
	{
		
		//"new" get the time now
		Date end_working=new Date();
		
		//calculate the time from login until logout
		double total_time=end_working.getTime()-dateObj.getTime();
		
		//calculate the amount of minutes in the work
		total_time=total_time/1000/60;
		
		//calculate of wages per minute of the employee
		double salary_per_minute=this.salaryPerHour/60;
		
		//calculate of wages for that day
		double total=total_time*salary_per_minute;
		
		return total;
	}
}


