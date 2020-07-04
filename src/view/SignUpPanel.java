package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Client;

public class SignUpPanel
{
	private Client client;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	private PropertyChangeSupport propertyChangeHandler;
	
	public SignUpPanel()
	{
		setPropertyChangeSupport();
	}
	public void panelActivity()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("enter first name or press 0 to go back :");
		String firstName = input.nextLine();
		if(firstName.equals("0")) {
			propertyChangeHandler.firePropertyChange("IntroPanel", 0, 1);
		}
		else {
		while(firstName.equals(""))
		{
			System.out.println("enter valid first name:");
			firstName = input.nextLine();
		}
		this.firstName = firstName;
		
		System.out.println("enter last name:");
		String lastName = input.nextLine();
		while(lastName.equals(""))
		{
			System.out.println("enter valid last name:");
			lastName = input.nextLine();
		}
		this.lastName = lastName;
		
		System.out.println("enter email:");
		String email = input.nextLine();
		while(email.equals(""))
		{
			System.out.println("enter valid last name:");
			email = input.nextLine();
		}
		this.email = email;
		
		System.out.println("enter username:");
		String username = input.nextLine();
		while(username.equals(""))
		{
			System.out.println("enter valid last username");
			username = input.nextLine();
		}
		this.username = username;
		
		System.out.println("enter password:");
		String password = input.nextLine();
		while(password.equals(""))
		{
			System.out.println("enter valid password:");
			password = input.nextLine();
		}
		this.password = password;
		
		//create new client object
		this.client = new Client(username,password,email,firstName,lastName);
		
		//fire info to controller that push data to clientDB
		propertyChangeHandler.firePropertyChange("SignUpClientEvent",0,this.client);
		
		System.out.println("To login press 1");
		int numPress = input.nextInt();
		if(numPress==1)
		{
			propertyChangeHandler.firePropertyChange("ClientLoginPanel", 0, 1);
		}
	}
	}
	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeHandler.addPropertyChangeListener(listener);
	}
	

}
