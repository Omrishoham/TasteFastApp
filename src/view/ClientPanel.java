package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Client;

public class ClientPanel {
	
	private PropertyChangeSupport propertyChangeHandler;
	
	public ClientPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Client client) {
		
		System.out.println("Hi "+client.getUsername()+"!");
		System.out.println("1.Make an order");
		Scanner input = new Scanner(System.in);
		int numPress = input.nextInt();
		
		switch (numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("OrderPanel",0,client); //goes to resturant menu
			break;

		default:
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
