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
		System.out.println("Hi manager "+this.manager.getUsername()+",");
		System.out.println("Here are you options\n1.See All Orders\n2.Add employee to resturant\n3.Remove employee from resturant\n4.See hou much money in checkout today\n5.Make waiter a manager\n6.update waiter's salary per hour\n7.Logout");
		int numPress = input.nextInt();
		switch(numPress) {
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
			//!!!!!!!חסר
			break;
		case 5:
			propertyChangeHandler.firePropertyChange("UpdateToManagerPanel", 0, this.manager);
			break;
		case 6:
			//!!!!!!!חסר
			break;
		case 7:
			//!!!!!!!חסר
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
