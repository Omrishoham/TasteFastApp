package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class IntroPanel 
{
	private PropertyChangeSupport propertyChangeHandler;
	
	public IntroPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("1.Sign up as client\n2.Login as client\n3.Login as waiter to shift\n4.Login as manager to shift" );
		int numPress = input.nextInt();
		
		switch(numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("SignUpPanel",0,1);
			break;
		case 2:
			propertyChangeHandler.firePropertyChange("ClientLoginPanel", 0, 1);
			break;
		case 3:
			propertyChangeHandler.firePropertyChange("EmployeeLoginPanel",0,1);
			break;
		case 4:
			propertyChangeHandler.firePropertyChange("EmployeeLoginPanel", 0, 1);
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
