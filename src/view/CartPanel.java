package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CartPanel {
	private PropertyChangeSupport propertyChangeHandler;
	
	public CartPanel()
	{
		setPropertyChangeSupport();
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

