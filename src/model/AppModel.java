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

	public AppModel() {
		setPropertyChangeSupport();
		clientsDB = ClientsDB.getInstance();
		ordersDB = OrdersDB.getInstance();
		employeesDB = EmployeesDB.getInstance();
		onShiftEmpolyees = new ArrayList<Employee>();

	}
	//update waiter to manager and new salary for him
	public void updateToManager(String username,double newsalarypaerhour) {
		employeesDB.updateToManager(username,newsalarypaerhour);
		
	}

//put new client info in Database
	public void signUpClient(Client client) {
		clientsDB.insertInfo(client.getUsername(), client.getPassword(), client.getEmail(), client.getFirstName(),
				client.getLastName());
	}
	//put new waiter to database
	public void addEmployee(Employee employee) {
		employeesDB.addEmployee(employee.getUsername(),employee.getPassword(),employee.getIsManager(),employee.getSalaryPerHour(),employee.getSalarySum(),employee.getFirstName(),employee.getLastName());
	}
	public void removeEmployee(String username) {
		employeesDB.removeEmployee(username);
	}
	
	public boolean ifEmployeeExist(String username)
	{
		return employeesDB.ifExist(username);
	}

	// put new order in database
	public void inserNewOrder(Order order) {
		ordersDB.insertOrder(order.getWhoOrdered(), order.getOrderID(), order.getTotalPrice(),
				order.getCreditCardNumber(), order.getValidityCreditCard(), order.getOrderTime(),order.getOrderDate());
	}
	
	//update salary to employee
	public void updateSalary(String username, double salaryPerHour)
	{
		employeesDB.updateSalary(username,salaryPerHour);
	}

//return if client is in the Database
	public boolean loginClientAuth(String username, String password) {

		return clientsDB.loginAuthentication(username, password);
	}

	public boolean ifClientExist(String username,String email) {
		return clientsDB.ifClientExist(username,email);
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
	
	public void updateTotalSalary(String username,double todayIncome) {
		employeesDB.updateTotalSalary(username, todayIncome);
	}
	
	public double getSalaryCount(String username) {
		return employeesDB.getSalaryCount(username);
	}
	
	
	public ArrayList<Order> getOrdersDB(){
		return ordersDB.getOrdersDB();
	}
	
	public ArrayList<Employee> getOnShiftEmployees(){
		return this.onShiftEmpolyees;
	}

	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}

}
