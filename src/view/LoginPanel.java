package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class LoginPanel 
{
	private PropertyChangeSupport propertyChangeHandler;
	
	public LoginPanel()
	{
		setPropertyChangeSupport();
	}
	public void panelActivity()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Connect as a:\n1.Client\n2.Waiter\n3.Manager");
		int numPress = input.nextInt();
		
		switch(numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("ClientView",0,1);
			
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
