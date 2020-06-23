package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import model.Employee;
import model.Manager;

public class ManagerPanel {
	private PropertyChangeSupport propertyChangeHandler;
	private Manager manager;
	
	public ManagerPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Employee employee)
	{
		this.manager = new Manager(employee.getUsername(),employee.getPassword(),employee.getsalaryPerHour());
		System.out.println("Hi manager "+this.manager.getUsername()+",");
		System.out.println("Here are you options\n1.See All Orders\n2.Add waiter to resturant employees\n3.Remove waiter from resturant employees\n4.See hou much money in checkout today\n5.Make waiter a manager");
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
