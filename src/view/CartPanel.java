package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import model.ItemsInMenu;

public class CartPanel {
	
	private PropertyChangeSupport propertyChangeHandler;
	
	//private ArrayList<ItemsInMenu> shoppingCart;
	
	public CartPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(ArrayList<ItemsInMenu> shoppingCart) {
		
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

