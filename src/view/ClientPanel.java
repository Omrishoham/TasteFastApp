package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class ClientPanel {
	
	private PropertyChangeSupport propertyChangeHandler;
	private String username;
	
	public ClientPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(String username) {
		
		this.username = username;
		System.out.println("Hi "+username+"!");
		System.out.println("1.Make an order");
		Scanner input = new Scanner(System.in);
		int numPress = input.nextInt();
		
		switch (numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("OrderPanel",0,1); //goes to resturant menu
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
	public String getClientPanelUsername() {
		return this.username;
	}

}
