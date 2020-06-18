package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.Scanner;

public class ClientLoginPanel 
{
	String username;
	String password;
	
	private PropertyChangeSupport propertyChangeHandler;
	
	public ClientLoginPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity()
	{////////שיטרית צריך פה לשנות לחלון של לוגין לקליינטים שבו נאמת את הלקוח ואז נעבור לאפשרויות שלו בחלון אחר שנעשה
		Scanner input = new Scanner(System.in);
		System.out.println("Login:\n");
		
		System.out.println("username: ");
		String username = input.nextLine();
		while(username=="")
		{
			System.out.println("error! enter again username:");
			username = input.nextLine();
		}
		this.username = username;
		
		System.out.println("password:");
		String password = input.nextLine();
		while(password=="")
		{
			System.out.println("error! enter again password:");
			password = input.nextLine();
		}
		this.password = password;
		
		//controller checks if client in DB
		propertyChangeHandler.firePropertyChange("ClientLoginEvent",0,1);
	}

	public String getClientLoginUsername() {
		return this.username;
	}
	
	public String getClientLoginPassword() {
		return this.password;
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