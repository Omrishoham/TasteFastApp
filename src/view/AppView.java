package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AppView implements PropertyChangeListener {
	private PropertyChangeSupport propertyChangeHandler;
	private OrderPanel orderPanel;
	private Intro loginPanel;
	private ClientLogin clientLogin;
	private SignUpPanel signUpPanel;
	
	public AppView()
	{
		setPropertyChangeSupport();
		orderPanel = new OrderPanel();
		loginPanel = new Intro();
		clientLogin = new ClientLogin();
		orderPanel.addPropertyChangeListener(this);
		loginPanel.addPropertyChangeListener(this);
		clientLogin.addPropertyChangeListener(this);
		loginPanel.panelActivity();
	 
	}
	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeHandler.addPropertyChangeListener(listener); 
	}
	public void propertyChange(PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals("OrderPanel"))
		{
			changeWindows("OrderPanel");
		}
		else if(event.getPropertyName().equals("ClientLogin"))
		{
			changeWindows("ClientLogin");
			
		}
		else if(event.getPropertyName().equals("EmployeeLogin"))
		{
			changeWindows("EmployeeLogin");
			
		}
		else if(event.getPropertyName().equals("SignUpPanel"))
		{
			changeWindows("SignUpPanel");
		}
			
		else {
				//send the property change to the controller
				propertyChangeHandler.firePropertyChange(event.getPropertyName(), event.getOldValue(), event.getNewValue());	
			}
			
		}
		
	
	public void changeWindows(String newPanel)
	{
		switch(newPanel)
		{
		case "OrderPanel":
			orderPanel.panelActivity();
			break;
			
		case "ClientLogin":
			clientLogin.panelActivity();
			break;
		case "EmployeeLogin":
			clientLogin.panelActivity();
			break;
		case "SignUpPanel":
			signUpPanel.panelActivity();
			break;
			
			
	
		
		}
	}
	public String getUsernameSignUp(){
		return this.signUpPanel.getUsername();
	}
	
	public String getPasswordSignUp(){
		return this.signUpPanel.getPassword();
	}

}
