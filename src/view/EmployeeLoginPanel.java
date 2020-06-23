package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Client;
import model.Employee;

public class EmployeeLoginPanel {
	private PropertyChangeSupport propertyChangeHandler;
	private Employee employee;
	
	public EmployeeLoginPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity()
	{
		
		Scanner input = new Scanner(System.in);
		employee = new Employee();
		System.out.println("Login:");
		
		System.out.println("username: ");
		String username = input.nextLine();
		while(username.equals(""))
		{
			System.out.println("error! enter again username:");
			username = input.nextLine();
		}
		this.employee.setUsername(username);
		
		System.out.println("password:");
		String password = input.nextLine();
		while(password.equals(""))
		{
			System.out.println("error! enter again password:");
			password = input.nextLine();
		}
		this.employee.setPassword(password);
		
		propertyChangeHandler.firePropertyChange("EmployeeLoginEvent", 0,this.employee);
	}
	
	public void setPropertyChangeSupport() 
	{
		propertyChangeHandler = new PropertyChangeSupport(this);
	}
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeHandler.addPropertyChangeListener(listener); 
	}
}
