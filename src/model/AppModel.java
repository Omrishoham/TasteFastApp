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
	public void signUpClient(String username, String password, String email, String firstName, String lastName) {
		clientsDB.insertInfo(username, password, email, firstName, lastName);
	}
	
	//put new order in database
	public void inserNewOrder(String username,int orderNumber,double totalPrice,String creditCardNum,String creditCardVal) {
		ordersDB.insertOrder(username, orderNumber, totalPrice, creditCardNum, creditCardVal);
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
