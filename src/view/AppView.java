package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AppView implements PropertyChangeListener {
	private PropertyChangeSupport propertyChangeHandler;
	private OrderPanel orderPanel;
	private LoginPanel loginPanel;
	private ClientPanel clientPanel;
	
	public AppView()
	{
		setPropertyChangeSupport();
		orderPanel = new OrderPanel();
		loginPanel = new LoginPanel();
		clientPanel = new ClientPanel();
		orderPanel.addPropertyChangeListener(this);
		loginPanel.addPropertyChangeListener(this);
		clientPanel.addPropertyChangeListener(this);
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
		else if(event.getPropertyName().equals("ClientView"))
		{
			changeWindows("ClientView");
			
		}
		
	}
	
	public void changeWindows(String newPanel)
	{
		switch(newPanel)
		{
		case "OrderPanel":
			orderPanel.panelActivity();
			break;
			
		case "ClientView":
			clientPanel.panelActivity();
			break;
	
		
		}
	}

}
