package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Employee;
import model.Manager;

public class AddEmployeePanel {
	private PropertyChangeSupport propertyChangeHandler;
	
	public AddEmployeePanel() {
		setPropertyChangeSupport();
	}
	public void panelActivity(Manager manager) {
		
		Scanner input = new Scanner(System.in);
			System.out.println("Enter employee's username: ");
			String username = input.nextLine();
			while(username.equals(""))
			{
				System.out.println("error! enter again username:");
				username = input.nextLine();
			}
			System.out.println("Enter employee's password: ");
			String password = input.nextLine();
			while(password.equals(""))
			{
				System.out.println("error! enter again password:");
				password = input.nextLine();
			}
			System.out.println("Enter employee's salary per hour: ");
			double salaryperhour = input.nextDouble();
			
			Employee newEmployee = new Employee(username,password,salaryperhour);
			
			System.out.println("Is Manager ? (if yes write-true, if no write-false): ");
			boolean isManager = input.nextBoolean();
			newEmployee.setIsManager(isManager);
			
			propertyChangeHandler.firePropertyChange("AddEmployeeEvent", manager, newEmployee);
		
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
