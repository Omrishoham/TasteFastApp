package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AppView implements PropertyChangeListener {
	private PropertyChangeSupport propertyChangeHandler;
	private OrderPanel orderPanel;
	private IntroPanel introPanel;
	private ClientLoginPanel clientLoginPanel;
	private SignUpPanel signUpPanel;
	private CartPanel cartPanel;
	private ConfirmOrderPanel confirmOrderPanel;
	
	public AppView()
	{
		setPropertyChangeSupport();
		
		orderPanel = new OrderPanel();
		introPanel = new IntroPanel();
		clientLoginPanel = new ClientLoginPanel();
		signUpPanel = new SignUpPanel();
		cartPanel = new CartPanel();
		confirmOrderPanel = new ConfirmOrderPanel();
		
		
		orderPanel.addPropertyChangeListener(this);
		introPanel.addPropertyChangeListener(this);
		clientLoginPanel.addPropertyChangeListener(this);
		signUpPanel.addPropertyChangeListener(this);
		cartPanel.addPropertyChangeListener(this);
		confirmOrderPanel.addPropertyChangeListener(this);
		
		
		
		introPanel.panelActivity();
	 
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
		else if(event.getPropertyName().equals("ClientLoginPanel"))
		{
			changeWindows("ClientLoginPanel");
			
		}
		else if(event.getPropertyName().equals("EmployeeLogin"))
		{
			changeWindows("EmployeeLogin");
			
		}
		else if(event.getPropertyName().equals("SignUpPanel"))
		{
			changeWindows("SignUpPanel");
		}
		else if(event.getPropertyName().equals("ClientLoginPanel"))
		{
			changeWindows("ClientLoginPanel");
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
			
		case "ClientLoginPanel":
			clientLoginPanel.panelActivity();
			break;
		case "EmployeeLogin":
			
			break;
		case "SignUpPanel":
			signUpPanel.panelActivity();
			break;
			
			
	
		
		}
	}
	public String getUsernameSignUp(){
		return this.signUpPanel.getUsernameSignUPClient();
	}
	
	public String getPasswordSignUp(){
		return this.signUpPanel.getPasswordSignUPClient();
	}

}
