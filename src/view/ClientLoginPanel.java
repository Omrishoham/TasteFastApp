package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.Scanner;

import model.Client;

public class ClientLoginPanel 
{
	private Client client;
	private PropertyChangeSupport propertyChangeHandler;
	
	public ClientLoginPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity()
	{
		Scanner input = new Scanner(System.in);
		client = new Client();
		System.out.println("Login:");
		
		System.out.println("username: ");
		String username = input.nextLine();
		while(username=="")
		{
			System.out.println("error! enter again username:");
			username = input.nextLine();
		}
		this.client.setUsername(username);
		
		System.out.println("password:");
		String password = input.nextLine();
		while(password=="")
		{
			System.out.println("error! enter again password:");
			password = input.nextLine();
		}
		this.client.setPassword(password);
		
		//controller checks if client in DB
		propertyChangeHandler.firePropertyChange("ClientLoginEvent",0,this.client);
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