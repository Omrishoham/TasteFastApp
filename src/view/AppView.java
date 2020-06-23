package view;

import java.awt.Event;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import model.Client;
import model.Order;

public class AppView implements PropertyChangeListener {
	private PropertyChangeSupport propertyChangeHandler;
	private OrderPanel orderPanel;
	private IntroPanel introPanel;
	private ClientLoginPanel clientLoginPanel;
	private ClientPanel clientPanel;
	private SignUpPanel signUpPanel;
	private CheckoutPanel checkoutPanel;
	private EmployeeLoginPanel employeeLoginPanel;

	public AppView() {
		setPropertyChangeSupport();

		orderPanel = new OrderPanel();
		introPanel = new IntroPanel();
		clientLoginPanel = new ClientLoginPanel();
		clientPanel = new ClientPanel();
		signUpPanel = new SignUpPanel();
		checkoutPanel = new CheckoutPanel();
		employeeLoginPanel = new EmployeeLoginPanel();

		orderPanel.addPropertyChangeListener(this);
		introPanel.addPropertyChangeListener(this);
		clientLoginPanel.addPropertyChangeListener(this);
		clientPanel.addPropertyChangeListener(this);
		signUpPanel.addPropertyChangeListener(this);
		checkoutPanel.addPropertyChangeListener(this);
		employeeLoginPanel.addPropertyChangeListener(this);

	}
	
	public void start() {
		introPanel.panelActivity();
	}

	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("OrderPanel")) {
			changeWindows("OrderPanel",event.getNewValue());
		} else if (event.getPropertyName().equals("ClientLoginPanel")) {
			changeWindows("ClientLoginPanel",null);

		} else if (event.getPropertyName().equals("EmployeeLogin")) {
			changeWindows("EmployeeLogin",null);

		} else if (event.getPropertyName().equals("SignUpPanel")) {
			changeWindows("SignUpPanel",null);
		} else if(event.getPropertyName().equals("IntroPanel")){
			changeWindows("IntroPanel",null);
		}
		else if(event.getPropertyName().equals("CheckoutPanel")) {
			changeWindows("CheckoutPanel",event.getNewValue());
		}
		else if(event.getPropertyName().equals("ReturnToOrderPanel"))
		{
			changeWindows("ReturnToOrderPanel",event.getNewValue());
		}

		else {
			// send the property change to the controller
			propertyChangeHandler.firePropertyChange(event.getPropertyName(), event.getOldValue(), event.getNewValue());
		}

	}
	//change to window and getting some value if we need to
	public void changeWindows(String newPanel,Object obj) {
		switch (newPanel) {
		case "IntroPanel":
			introPanel.panelActivity();
			
		case "SignUpPanel":
			signUpPanel.panelActivity();
			break;

		case "ClientLoginPanel":
			clientLoginPanel.panelActivity();
			break;

		case "ClientPanel":
			clientPanel.panelActivity((Client)obj);
			break;

		case "OrderPanel":
			orderPanel.panelActivity((Client)obj);
			break;
			
		case "ReturnToOrderPanel":
			orderPanel.makeOrder((Order) obj);
			break;

		case "CheckoutPanel":
			checkoutPanel.panelActivity((Order)obj);
			break;
		}
	}


	public void loginErrorMsg() {
		System.out.println("User is not found!");
	}

}
