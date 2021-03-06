package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Employee;
import model.Manager;

public class RemoveEmployeePanel {
	private PropertyChangeSupport propertyChangeHandler;

	public RemoveEmployeePanel() {
		setPropertyChangeSupport();
	}

	public void panelActivity(Manager manager) {
		
		Scanner input = new Scanner(System.in);		
		propertyChangeHandler.firePropertyChange("PrintEmployeesEvent", 0, 1);
		
		System.out.println("Enter employee's username you wanna remove or press 0 to go back: ");
		String username = input.nextLine();
		if(username.equals("0")) {
			propertyChangeHandler.firePropertyChange("ManagerPanel",0, manager);
		}
		else {
		while (username.equals("")) {
			System.out.println("error! enter again username:");
			username = input.nextLine();
		}
		propertyChangeHandler.firePropertyChange("RemoveEmployeeEvent", manager, username);
		}
		
	}

	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}

}
