package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ConfirmOrderPanel 
{
	private PropertyChangeSupport propertyChangeHandler;
	
	public ConfirmOrderPanel()
	{
		setPropertyChangeSupport();
	}
	public void activity()
	{
		
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