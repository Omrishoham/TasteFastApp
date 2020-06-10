package model;

public abstract class Employee implements User {
	protected String userName;
	protected String password;
	
	public Employee(String username, String password)
	{
		this.userName = username;
		this.password = password;
	}
	public String getUserName() {
		return this.userName;
	}

}
