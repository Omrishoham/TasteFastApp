package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AppModel
{
	private PropertyChangeSupport propertyChangeHandler;
	private ArrayList<IProduct> menu;//The restaurant menu, has all products for sale

public AppModel()
{
	setPropertyChangeSupport();
	menu=new ArrayList<IProduct>();
	menu.add(RegularPizza.getInstance());
	menu.add(VeganPizza.getInstance());
	menu.add(PastaBolognese.getInstance());
	menu.add(CheeseCake.getInstance());
	menu.add(ChocolateMousse.getInstance());

}

public void setPropertyChangeSupport()
{
	propertyChangeHandler = new PropertyChangeSupport(this);
}
	
public void addPropertyChangeListener(PropertyChangeListener listener)
{
		propertyChangeHandler.addPropertyChangeListener(listener); 
}
public ArrayList<IProduct> getMenu()
{
	return menu;
}

}
