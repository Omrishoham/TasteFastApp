package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Employee;
import model.Manager;

public class UpdateToManagerPanel {
	private PropertyChangeSupport propertyChangeHandler;
	
	public UpdateToManagerPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Manager manager)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the username's waiter you wanna make to manager: ");
		String username = input.nextLine();
		while(username.equals(""))
		{
			System.out.println("error! enter again username:");
			username = input.nextLine();
		}
		System.out.println("update his salary: ");
		double salaryperhour = input.nextDouble();
		Employee employee = new Employee();
		employee.setUsername(username);
		employee.setSalaryPerHour(salaryperhour);
		propertyChangeHandler.firePropertyChange("UpdateToManagerEvent", manager, employee);
		
		
		
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
