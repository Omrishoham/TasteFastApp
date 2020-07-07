package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import model.DB.ClientsDB;
import model.DB.EmployeesDB;
import model.DB.OrdersDB;

public class AppModel {
	private PropertyChangeSupport propertyChangeHandler;
	private ClientsDB clientsDB;
	private OrdersDB ordersDB;
	private EmployeesDB employeesDB;

	public AppModel() {
		setPropertyChangeSupport();
		clientsDB = ClientsDB.getInstance();
		ordersDB = OrdersDB.getInstance();
		employeesDB = EmployeesDB.getInstance();

	}

	public boolean loginEmployeeAuth(String username, String password) {

		return employeesDB.loginAuthentication(username, password);
	}

	public boolean ifEmployeeManager(String username, String password) {
		return employeesDB.isManager(username, password);
	}

	public boolean ifEmployeeExist(String username) {
		return employeesDB.ifEmployeeExist(username);
	}

	// update waiter to manager and new salary for him
	public void updateToManager(String username, double newsalarypaerhour) {
		employeesDB.updateToManager(username, newsalarypaerhour);

	}

	// put new client info in Database
	public void signUpClient(Client client) {
		clientsDB.insertInfo(client.getUsername(), client.getPassword(), client.getEmail(), client.getFirstName(),
				client.getLastName());
	}

	// return if client is in the Database
	public boolean loginClientAuth(String username, String password) {

		return clientsDB.loginAuthentication(username, password);
	}

	public boolean ifClientExist(String username, String email) {

		return clientsDB.ifClientExist(username, email);
	}

	// put new waiter to database
	public boolean addEmployee(Employee employee) {
		return employeesDB.addEmployee(employee.getUsername(), employee.getPassword(), employee.getIsManager(),
				employee.getSalaryPerHour(), employee.getSalarySum(), employee.getFirstName(), employee.getLastName());
	}

	public boolean removeEmployee(String username) {
		return employeesDB.removeEmployee(username);
	}

	// put new order in database
	public boolean insertNewOrder(Order order) {
		return ordersDB.insertOrder(order.getUsername(), order.getOrderID(), order.getTotalPrice(),
				order.getCreditCardNumber(), order.getValidityCreditCard(), order.getOrderTime(), order.getOrderDate());
	}

	// update salary to employee
	public boolean updateSalaryPerHour(String username, double salaryPerHour) {
		return employeesDB.updateSalaryPerHour(username, salaryPerHour);
	}

	public Employee placeValues(String username, String password) {
		return employeesDB.placeValues(username, password);
	}

	public void updateSalarySum(String username, double todayIncome) {
		employeesDB.updateSalarySum(username, todayIncome);
	}

	public double getSalaryCount(String username) {
		return employeesDB.getSalaryCount(username);
	}

	public ArrayList<Order> getOrdersDB() {
		return ordersDB.getOrdersDB();
	}

	public ArrayList<Employee> getAllEmployees() {
		return employeesDB.getAllEmployees();
	}

	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}

}
