package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import model.Employee;
import model.Waiter;

public class WaiterPanel {
	private PropertyChangeSupport propertyChangeHandler;
	private Waiter waiter;
	
	public WaiterPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Employee employee)
	{
		this.waiter = new Waiter(employee.getUsername(),employee.getPassword(),employee.getsalaryPerHour());
		
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
