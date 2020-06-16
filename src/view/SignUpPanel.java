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
		
		
		System.out.println("enter password:");
		String password = input.nextLine();
		
		propertyChangeHandler.firePropertyChange("SignUpEvent",0,1);
	}
	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeHandler.addPropertyChangeListener(listener);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
		
	}

}
