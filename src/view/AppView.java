package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AppView implements PropertyChangeListener {
	private PropertyChangeSupport propertyChangeHandler;
	private OrderPanel orderPanel;
	private IntroPanel introPanel;
	private ClientLoginPanel clientLoginPanel;
	private ClientPanel clientPanel;
	private SignUpPanel signUpPanel;
	private CartPanel cartPanel;
	private ConfirmOrderPanel confirmOrderPanel;

	public AppView() {
		setPropertyChangeSupport();

		orderPanel = new OrderPanel();
		introPanel = new IntroPanel();
		clientLoginPanel = new ClientLoginPanel();
		clientPanel = new ClientPanel();
		signUpPanel = new SignUpPanel();
		cartPanel = new CartPanel();
		confirmOrderPanel = new ConfirmOrderPanel();

		orderPanel.addPropertyChangeListener(this);
		introPanel.addPropertyChangeListener(this);
		clientLoginPanel.addPropertyChangeListener(this);
		clientPanel.addPropertyChangeListener(this);
		signUpPanel.addPropertyChangeListener(this);
		cartPanel.addPropertyChangeListener(this);
		confirmOrderPanel.addPropertyChangeListener(this);

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
			changeWindows("OrderPanel");
		} else if (event.getPropertyName().equals("ClientLoginPanel")) {
			changeWindows("ClientLoginPanel");

		} else if (event.getPropertyName().equals("EmployeeLogin")) {
			changeWindows("EmployeeLogin");

		} else if (event.getPropertyName().equals("SignUpPanel")) {
			changeWindows("SignUpPanel");
		} else if (event.getPropertyName().equals("ClientLoginPanel")) {
			changeWindows("ClientLoginPanel");
		} else {
			// send the property change to the controller
			propertyChangeHandler.firePropertyChange(event.getPropertyName(), event.getOldValue(), event.getNewValue());
		}

	}

	public void changeWindows(String newPanel) {
		switch (newPanel) {
		case "SignUpPanel":
			signUpPanel.panelActivity();
			break;

		case "ClientLoginPanel":
			clientLoginPanel.panelActivity();
			break;

		case "ClientPanel":
			clientPanel.panelActivity(clientLoginPanel.getClientLoginUsername());
			break;

		case "OrderPanel":
			orderPanel.panelActivity();
			break;
			
		case "CartPanel":
			cartPanel.panelActivity(orderPanel.getShoppingCart());
			break;
		}
	}

	// getting username string from signup panel
	public String getUsernameSignUp() {
		return this.signUpPanel.getUsernameSignUPClient();
	}

	// getting first name string from signup panel
	public String getFirstNameSignUp() {
		return this.signUpPanel.getFirstNameSignUpClient();
	}

	// getting last name string from signup panel
	public String getLastNameSignUp() {
		return this.signUpPanel.getLastNameSignUpClient();
	}
	
	public String getEmailSignUp() {
		return this.signUpPanel.getEmailSignUpClient();
	}

	// getting password string from signup panel
	public String getPasswordSignUp() {
		return this.signUpPanel.getPasswordSignUPClient();
	}

	// getting username string from client login panel
	public String getUsernameClientLogin() {
		return this.clientLoginPanel.getClientLoginUsername();
	}

	// getting password string from client login panel
	public String getPasswordClientLogin() {
		return this.clientLoginPanel.getClientLoginPassword();
	}

	public void loginErrorMsg() {
		System.out.println("User is not found!");
	}

}
