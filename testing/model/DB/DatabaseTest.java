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
		
		ArrayList<ItemInMenu> menu = MyMenu.getInstance(); //instance of menu
		double menuSum = 0;
		
		//sum all the prices of all the menu to check if fits
		for (ItemInMenu itemInMenu : menu) {
			menuSum+= itemInMenu.getPrice();
		}
		
		//add same items to order cart
		Order order = new Order("yosef");
		order.setShoppingCart(menu);
		double cartSum = 0;
		for(ItemInMenu itemInMenu : order.getShoppingCart()) {
			cartSum+=itemInMenu.getPrice();
		}
		order.setTotalPrice(cartSum);
		
		//check if prices are right
		assertTrue("this is the right sum of prices", menuSum == cartSum);
	}
}
