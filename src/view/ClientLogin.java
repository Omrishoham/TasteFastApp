package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.Scanner;

public class ClientLogin 
{
	private PropertyChangeSupport propertyChangeHandler;
	
	public ClientLogin()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("hi client,\nchoose one of your options:\n1.make order");
		int numPress = input.nextInt();
		System.out.println("\n");
		switch(numPress) 
		{
		case 1:
			propertyChangeHandler.firePropertyChange("OrderPanel",0,1);
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