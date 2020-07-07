package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sun.org.apache.xerces.internal.util.Status;

import model.menu.MyMenu;
import sun.util.calendar.Gregorian;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelTest {

	AppModel model;
	ModelTest test;

	static Employee employee;
	static Client client;

	@Before
	public void setUp() {
		model = new AppModel();
		test = new ModelTest();
	}

	@BeforeClass
	public static void createPeople() {
		// sign up as client and insert to DB once
		client = new Client("omriSh", "2222", "omri_shoham@gmail.com", "omri", "shoham");
		employee = new Employee("tomersh8", "1111", false, 80, 0, "tomer", "shitrit");
	}

	@Test
	public void testAEmployeeLogin() {
		// login as employee (as admin)
		assertTrue("employee login success!", model.loginEmployeeAuth("admin", "admin"));
	}

	@Test
	public void testBEmployeeLoginFail() {
		// login as not yet an employee
		assertFalse("cannot login! not an employee!",
				model.loginEmployeeAuth(employee.getUsername(), employee.getPassword()));
	}

	@Test
	public void testCEmployeeNotExist() {
		// check if the employee we want to add exist already
		assertFalse("employee does not exist!", model.ifEmployeeExist(employee.getUsername()));
	}

	@Test
	public void testDAddEmployee() {

		// check if employee added successfully
		assertTrue("employee added!", model.addEmployee(employee));
	}

	@Test
	public void testEEmployeeExist() {
		// employee does exist
		assertTrue("employee exist!", model.ifEmployeeExist(employee.getUsername()));
	}

	@Test
	public void testFIsNotManager() {
		// ask if the new added employee is manager
		assertFalse("this employee is not a manager",
				model.ifEmployeeManager(employee.getUsername(), employee.getPassword()));
	}

	@Test
	public void testGIsManager() {

		// upgrade to manager
		model.updateToManager("tomersh8", 120);

		// now a manager
		assertTrue("the emplyoee is now a manager",
				model.ifEmployeeManager(employee.getUsername(), employee.getPassword()));
	}

	@Test
	public void testHEmployeeUpdateSalary() {

		double currSalary = employee.getSalaryPerHour();

		// check if salary can be updated
		assertTrue("salary per hour changed", model.updateSalaryPerHour(employee.getUsername(), 120));

		employee = model.placeValues(employee.getUsername(), employee.getPassword());

		// actually changed
		assertFalse("not matching salaries", currSalary == employee.getSalaryPerHour());
	}

	@Test
	public void testIEmployeeRemove() {

		// must check if employee exist
		if (model.ifEmployeeExist(employee.getUsername())) {

			assertTrue("employee is removed", model.removeEmployee(employee.getUsername()));
		}

		else {

			assertFalse("invalid employee username, cannot remove!", model.removeEmployee(employee.getUsername()));
		}

	}

	@Test
	public void testKClientSignUp() {
		
		if (!model.ifClientExist(client.getUsername(), client.getEmail())) {

			assertFalse("client does not exist", model.ifClientExist(client.getUsername(), client.getEmail()));
			model.signUpClient(client);
			
		} 
		else {

			assertTrue("client does not exist", model.ifClientExist(client.getUsername(), client.getEmail()));
		}

	}

	@Test
	public void testLCLientLogin() {

		// check if existing client can login
		assertTrue("client logged in successfully!", model.loginClientAuth(client.getUsername(), client.getPassword()));

		// fake client login
		assertFalse("client cannot login, does not exist!", model.loginClientAuth("noOne", "1234"));
	}

	@Test
	public void testMOrder() {

		ArrayList<ItemInMenu> menu = MyMenu.getInstance(); // instance of menu
		double menuSum = 0;

		// sum all the prices of all the menu to check if fits
		for (ItemInMenu itemInMenu : menu) {
			menuSum += itemInMenu.getPrice();
		}

		// add same items to order cart
		Order order3 = new Order("yosef");
		order3.setShoppingCart(menu);
		double cartSum = 0;
		for (ItemInMenu itemInMenu : order3.getShoppingCart()) {
			cartSum += itemInMenu.getPrice();
		}
		order3.setTotalPrice(cartSum);

		// check if prices are right
		assertTrue("this is the right sum of prices", menuSum == cartSum);
	}
	
	@AfterClass
	public static void testGetAllEmployees() {
		// show updated list of employees after changes (removes, adds)
		ArrayList<Employee> employees = new ArrayList<Employee>();
		assertFalse("employee does not work here", employees.contains(employee));
	}

}
