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
	
	public void panelActivity(Waiter waiter)
	{
		this.waiter = waiter;
		
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
