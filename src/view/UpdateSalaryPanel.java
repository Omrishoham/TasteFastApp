package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Employee;
import model.Manager;

public class UpdateSalaryPanel {
	private PropertyChangeSupport propertyChangeHandler;
	
	public UpdateSalaryPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Manager manager) {
		
		propertyChangeHandler.firePropertyChange("PrintEmployeesEvent", 0, 1);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the username's employee you wanna update his salary: ");
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
		propertyChangeHandler.firePropertyChange("UpdateSalaryEvent", manager, employee);
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
