package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class SignUpPanel
{
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
		System.out.println("enter username:");
		String username = input.nextLine();
		while(username=="")
		{
			System.out.println("error! enter again username:");
			username = input.nextLine();
		}
		this.username = username;
		System.out.println("enter password:");
		String password = input.nextLine();
		while(password=="")
		{
			System.out.println("error! enter again password:");
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

}
