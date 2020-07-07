package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sun.util.calendar.Gregorian;

public class ModelTest {

	AppModel model;
	ModelTest test;
	
	boolean firtTimeOrder = true;

	@Before
	public void setUp() {
		model = new AppModel();
		test = new ModelTest();
	}

	@Test
	public void testEmployeeManagmentSequence() { // manager actions tests

		Employee employee = new Employee("tomersh8", "1111", false, 80, 0, "tomer", "shitrit");

		// login as employee
		assertTrue("employee login success!", model.loginEmployeeAuth("admin", "admin"));

		// ask if he is manager
		assertTrue("this is a manager", model.ifEmployeeManager("admin", "admin"));

		// check if the employee we want to add exist already
		assertFalse("employee does not exist!", model.ifEmployeeExist("tomersh8"));

		// check if employee added successfully
		assertTrue("employee added!", model.addEmployee(employee));

		// the employee is not yet manager
		assertFalse("the emplyoee is not a manager",
				model.ifEmployeeManager(employee.getUsername(), employee.getPassword()));

		// upgrade to manager
		model.updateToManager(employee.getUsername(), 120);

		// now a manager
		assertTrue("the emplyoee is now a manager",
				model.ifEmployeeManager(employee.getUsername(), employee.getPassword()));

		// employee does exist
		assertTrue("employee exist!", model.ifEmployeeExist("tomersh8"));

		// check if can remove the employee from DB
		assertTrue("employee is removed", model.removeEmployee("tomersh8"));

		// check if the removed employee exist
		assertFalse("employee does not exist!", model.ifEmployeeExist("tomersh8"));

	}

	@Test
	public void testEmployeeSalary() { // employee salary update tests

		Employee employee = new Employee("sagiv", "1111", false, 80, 0, "sag", "rud");

		// check if employee added successfully
		assertTrue("employee added!", model.addEmployee(employee));

		// check previous salary vs new salary
		double currSalary = employee.getSalaryPerHour();

		// check if salary can be updated
		assertTrue("salary per hour changed", model.updateSalaryPerHour(employee.getUsername(), 120));

		// import from DB
		employee = model.placeValues("sagiv", "1111");

		// compare salaries
		assertFalse("not matching salaries", currSalary == employee.getSalaryPerHour());

		// remove from DB
		assertTrue("employee removed", model.removeEmployee("sagiv"));
	}

	@Test
	public void testClientEventSequence() {

		//sign up as client and insert to DB once
		Client client = new Client("omriSh","2222" ,"omri_shoham@gmail.com" ,"omri" ,"shoham");
			
		if(!model.ifClientExist(client.getUsername(), client.getEmail())) {
			assertFalse("client does not exist",model.ifClientExist(client.getUsername(), client.getEmail()));
			model.signUpClient(client);
		}
		else {
			assertTrue("client does not exist",model.ifClientExist(client.getUsername(), client.getEmail()));
		}
		
		//check if existing client can login
		assertTrue("client logged in successfully!",model.loginClientAuth(client.getUsername(), client.getPassword()));
		
		//fake client login
		assertFalse("client cannot login, does not exist!",model.loginClientAuth("noOne", "1234"));
		
	}
	
	@Test
	public void testOrder() {
		
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
		assertTrue("order inserted successfully!",model.insertNewOrder(order));
		
		//get updated order DB
		allOrders = model.getOrdersDB();
		
		String id = order.getOrderID();
		
		for(Order order2 : allOrders) {
			order2.printOrder();
		}
		
		System.out.println("\n the current order");
		order.printOrder();
		
		assertTrue("order is in list",allOrders.contains(order));
		
	}

}
