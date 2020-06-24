package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AppModel {
	private PropertyChangeSupport propertyChangeHandler;
	private ClientsDB clientsDB;
	private OrdersDB ordersDB;
	private EmployeesDB employeesDB;
	private ArrayList<Employee> onShiftEmpolyees;
	private ArrayList<Order> allOrders;

	public AppModel() {
		setPropertyChangeSupport();
		clientsDB = ClientsDB.getInstance();
		ordersDB = OrdersDB.getInstance();
		employeesDB = EmployeesDB.getInstance();
		onShiftEmpolyees = new ArrayList<Employee>();
		allOrders = new ArrayList<Order>();

	}

//put new client info in Database
	public void signUpClient(Client client) {
		clientsDB.insertInfo(client.getUsername(), client.getPassword(), client.getEmail(), client.getFirstName(),
				client.getLastName());
	}
	//put new waiter to database
	public void addEmployee(Employee employee) {
		employeesDB.addEmployee(employee.getUsername(),employee.getPassword(),employee.getsalaryPerHour(),employee.getIsManager());
	}
	public void removeEmployee(String username) {
		employeesDB.removeEmployee(username);
	}
	
	public boolean ifExist(String username)
	{
		return employeesDB.ifExist(username);
	}

	// put new order in database
	public void inserNewOrder(Order order) {
		this.allOrders.add(order);
		ordersDB.insertOrder(order.getWhoOrdered(), order.getOrderID(), order.getTotalPrice(),
				order.getCreditCardNumber(), order.getValidityCreditCard(), order.getOrderDate());
	}

//return if client is in the Database
	public boolean loginClientAuth(String username, String password) {

		return clientsDB.loginAuthentication(username, password);
	}

	public boolean loginEmployeeAuth(String username, String password) {

		return employeesDB.loginAuthentication(username, password);
	}

	public boolean ifEmployeeManager(String username, String password) {
		return employeesDB.isManager(username, password);
	}

	public Employee placeValues(String username, String password) {
		return employeesDB.placeValues(username, password);
	}

	public void printOrders() {
		if (this.allOrders.isEmpty())
			System.out.println("There are no orders at this time");
		else {
			for (Order order : allOrders) {
				order.printOrder();
			}
		}

	}

	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}

}
