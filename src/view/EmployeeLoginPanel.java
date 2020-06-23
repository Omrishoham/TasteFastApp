package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

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
