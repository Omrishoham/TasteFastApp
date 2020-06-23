package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AppModel {
	private PropertyChangeSupport propertyChangeHandler;
	private ClientsDB clientsDB;
	private OrdersDB ordersDB;
	

	public AppModel() {
		setPropertyChangeSupport();
		clientsDB = ClientsDB.getInstance();
		ordersDB = OrdersDB.getInstance();
			
		
	}

//put new client info in Database
	public void signUpClient(Client client) {
		clientsDB.insertInfo(client.getUsername(),client.getPassword(),client.getEmail(),client.getFirstName(),client.getLastName());
	}
	
	//put new order in database
	public void inserNewOrder(Order order) {
		ordersDB.insertOrder(order.getWhoOrdered(), order.getOrderID(), order.getTotalPrice(), order.getCreditCardNumber(), order.getValidityCreditCard());
	}

//return if client is in the Database
	public boolean loginClientAuth(String username, String password) {

		return clientsDB.loginAuthentication(username, password);
	}

	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}

}
