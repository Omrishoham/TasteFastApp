package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class SignUpPanel
{
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
		System.out.println("enter first name:");
		String firstName = input.nextLine();
		while(firstName=="")
		{
			System.out.println("enter valid first name:");
			firstName = input.nextLine();
		}
		this.firstName = firstName;
		
		System.out.println("enter last name:");
		String lastName = input.nextLine();
		while(lastName=="")
		{
			System.out.println("enter valid last name:");
			lastName = input.nextLine();
		}
		this.lastName = lastName;
		
		System.out.println("enter last name:");
		String email = input.nextLine();
		while(email=="")
		{
			System.out.println("enter valid last name:");
			email = input.nextLine();
		}
		this.email = email;
		
		System.out.println("enter username:");
		String username = input.nextLine();
		while(username=="")
		{
			System.out.println("enter valid last username");
			username = input.nextLine();
		}
		this.username = username;
		
		System.out.println("enter password:");
		String password = input.nextLine();
		while(password=="")
		{
			System.out.println("enter valid password:");
			password = input.nextLine();
		}
		this.password = password;
		
		propertyChangeHandler.firePropertyChange("SignUpEvent",0,1);
		System.out.println("user sign up successfuly");
		System.out.println("To login press 1");
		int numPress = input.nextInt();
		if(numPress==1)
		{
			propertyChangeHandler.firePropertyChange("ClientLoginPanel", 0, 1);
		}
	}
	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeHandler.addPropertyChangeListener(listener);
	}
	
	public String getUsernameSignUPClient() {
		return this.username;
	}
	
	public String getPasswordSignUPClient() {
		return this.password;
		
	}
	
	public String getFirstNameSignUpClient() {
		return this.firstName;
	}
	
	public String getLastNameSignUpClient() {
		return this.password;
		
	}
	
	public String getEmailSignUpClient() {
		return this.username;
	}
	

}
