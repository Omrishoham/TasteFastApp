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
		
		System.out.println("Hi Client "+client.getUsername()+"!");
		System.out.println("1.Make an order\n2.Call waiter for assistance\n3.Logout");
		Scanner input = new Scanner(System.in);
		int numPress = input.nextInt();
		
		switch (numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("OrderPanel",0,client); // goes to menu panel
			break;
		case 2:
			System.out.println("The waiter will be there shortly :)\n");
			propertyChangeHandler.firePropertyChange("ClientPanel",0,client);
		case 3:
			propertyChangeHandler.firePropertyChange("IntroPanel", 0, 1);
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
