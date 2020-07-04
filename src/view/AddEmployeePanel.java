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
			System.out.println("Enter employee's username or press 0 to go back: ");
			String username = input.nextLine();
			if(username.equals("0"))
			{
				propertyChangeHandler.firePropertyChange("ManagerPanel",0, manager);
			}
			else {
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
			System.out.println("Enter employee's first name: ");
			String firstName = input.nextLine();
			while(firstName.equals(""))
			{
				System.out.println("error! enter again first name:");
				firstName = input.nextLine();
			}
			System.out.println("Enter employee's last name: ");
			String lastName = input.nextLine();
			while(lastName.equals(""))
			{
				System.out.println("error! enter again last name:");
				lastName = input.nextLine();
			}
			System.out.println("Is Manager ? (if yes write-true, if no write-false): ");
			boolean isManager = input.nextBoolean();
			
			System.out.println("Enter employee's salary per hour: ");
			double salaryperhour = input.nextDouble();
			

			Employee newEmployee = new Employee(username,password,isManager,salaryperhour,0,firstName,lastName);
		
			
			propertyChangeHandler.firePropertyChange("AddEmployeeEvent", manager, newEmployee);
		
	}
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
