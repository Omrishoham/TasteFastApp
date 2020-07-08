package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import javax.imageio.stream.ImageInputStream;

import model.Employee;
import model.Manager;

public class ManagerPanel {
	private PropertyChangeSupport propertyChangeHandler;
	private Manager manager;
	
	public ManagerPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Manager manager)
	{
		this.manager = manager;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hi Manager "+this.manager.getFirstName()+",");
		System.out.println("Here are your options\n1.See All Orders\n"
							+ "2.Add(Sign up) employee to resturant\n"
							+ "3.Remove employee from resturant\n"
							+ "4.Make waiter a manager\n"
							+ "5.Update employee's salary per hour\n"
							+ "6.Logout(from shift also)");
		
		String numPress = input.nextLine();
		int num = 0;
		try {
			num = Integer.parseInt(numPress);
		}
		catch(NumberFormatException e) {
			e.getMessage();
			propertyChangeHandler.firePropertyChange("ManagerPanel", 0, this.manager);
		}
		
		switch(num) {
		case 1:
			propertyChangeHandler.firePropertyChange("PrintOrdersEvent",0,this.manager);
			break;
		case 2:
			propertyChangeHandler.firePropertyChange("AddEmployeePanel", 0, this.manager);
			break;
		case 3:
			propertyChangeHandler.firePropertyChange("RemoveEmployeePanel", 0, this.manager);
			break;
		case 4:
			propertyChangeHandler.firePropertyChange("UpdateToManagerPanel", 0, this.manager);
			break;
		case 5:
			propertyChangeHandler.firePropertyChange("UpdateSalaryPanel", 0,this.manager);
			break;
		case 6:
			propertyChangeHandler.firePropertyChange("LogoutEmployeeEvent", 0, this.manager);
			break;
		default:
			propertyChangeHandler.firePropertyChange("ManagerPanel", 0, this.manager);
			break;
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
