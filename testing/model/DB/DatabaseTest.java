package model.DB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import model.Client;
import model.Employee;
import model.ItemInMenu;
import model.Order;
import model.menu.MyMenu;

public class DatabaseTest {

	ClientsDB clientsDB;
	EmployeesDB employeesDB;
	OrdersDB ordersDB;
	
	Client client;
	Employee employee;
	
	@Before
	public void setUp() { //happens before each test in this class
		
		//database instances
		clientsDB = ClientsDB.getInstance();
		employeesDB = EmployeesDB.getInstance();
		ordersDB = OrdersDB.getInstance();
		
		//one shared client to all tests here
		client = new Client("sagivRud","1111" ,"sagiv@gmail.com" ,"sagiv" ,"rudoi");
		employee = new Employee("ronench8", "1234", false, 50, 0, "Ronen", "Chen");
	}
	
	@Test
	public void testClientSignUp() { //check if can client can sign up with same username or email
		
		//insert it for the first time
		if(!clientsDB.ifClientExist(client.getUsername(), client.getEmail())) {
			clientsDB.insertInfo(client.getUsername(), client.getPassword(), client.getEmail(), client.getFirstName(), client.getLastName());
		}
		
		//the second time adding him, should return true, there is another person like him
		assertTrue("client can only apear once in the Database",clientsDB.ifClientExist(client.getUsername(), client.getEmail()));
		
		assertFalse("client does not apear in database", clientsDB.ifClientExist("noOne", "noone@gmail.com"));
	}
	
	@Test
	public void testClientLoginAuthentication() { //check if existing user can login
		
		//should be able to login
		assertTrue("client login success!",clientsDB.loginAuthentication(client.getUsername(), client.getPassword()));
		
		//not an actual client
		assertFalse("not existing client cannot login!",clientsDB.loginAuthentication("noOne", "123444"));
		
	}
	
	@Test
	public void testEmployeeDB() {
		
		//add the employee to DB once
		if(!employeesDB.ifEmployeeExist(employee.getUsername())) {
			employeesDB.addEmployee(employee.getUsername(),employee.getPassword(),employee.getIsManager(),employee.getSalaryPerHour(), employee.getSalarySum(),employee.getFirstName(), employee.getLastName());
		}
		
		//valid employee login
		assertTrue("employee login success!",employeesDB.loginAuthentication(employee.getUsername(), employee.getPassword()));
		
		//invalid employee login
		assertFalse("employee login not success! does not exist!",employeesDB.loginAuthentication("noOne", "555"));
		
		//existing employee
		assertTrue("employee exist!",employeesDB.ifEmployeeExist(employee.getUsername()));
		
		//not exist
		assertFalse("employee does not exist!",employeesDB.ifEmployeeExist("noOne"));
		
	}
	
	@Test
	public void testRemoveEmployee() {
		if(employeesDB.ifEmployeeExist(employee.getUsername())) {
			employeesDB.removeEmployee(employee.getUsername());
		}
		
		//remove employee and check if exist later
		assertFalse("employee should not be exist after removed!", employeesDB.ifEmployeeExist(employee.getUsername()));
	}
	
	@Test
	public void testOrder() { //check order
		
		//getting all current registered orders from DB
				ArrayList<Order> allOrders = new ArrayList<Order>();
				//example order instance
				Order order = new Order("sabatobi");
				order.setTotalPrice(150);
				order.setDateAndTime();
				order.setCreditCartNumber("1234567812345678");
				order.setValidityCreditCard("04/23");
				
				//order not yet in DB
				assertFalse("order not found!",allOrders.contains(order));
				
				//check if order is in DB, else insert and check insertion succeed
				assertTrue("order inserted successfully!",ordersDB.insertOrder(order.getUsername()
						, order.getOrderID(), order.getTotalPrice(), order.getCreditCardNumber(), order.getValidityCreditCard(),
						order.getOrderTime(), order.getOrderDate()));
				
				//get updated order DB
				allOrders = ordersDB.getOrdersDB();
				
				String id = order.getOrderID();
				
				String id2 = allOrders.get(allOrders.size() - 1).getOrderID();
				
				assertTrue("order is in list",id == id2);
	}
}
