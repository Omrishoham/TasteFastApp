package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import model.Employee;
import model.Waiter;

public class WaiterPanel {
	private PropertyChangeSupport propertyChangeHandler;
	private Waiter waiter;
	
	public WaiterPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Waiter waiter)
	{
		this.waiter = waiter;
		Scanner input = new Scanner(System.in);
		System.out.println("Hi Waiter "+this.waiter.getFirstName()+",");
		System.out.println("Here are your options:\n1.See how your salary in resturant since you working\n2.Logout(from shift also)");
		int numPress = input.nextInt();
		switch(numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("PrintSalaryEvent",0, this.waiter);
			break;
		case 2:
		propertyChangeHandler.firePropertyChange("LogoutEmployeeEvent", 0, this.waiter);
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
