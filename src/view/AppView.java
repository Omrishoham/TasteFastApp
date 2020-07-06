package view;

import java.awt.Event;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import model.Client;
import model.Employee;
import model.Manager;
import model.Order;
import model.Waiter;

public class AppView implements PropertyChangeListener {
	private PropertyChangeSupport propertyChangeHandler;
	private OrderPanel orderPanel;
	private IntroPanel introPanel;
	private ClientLoginPanel clientLoginPanel;
	private ClientPanel clientPanel;
	private SignUpPanel signUpPanel;
	private CheckoutPanel checkoutPanel;
	private EmployeeLoginPanel employeeLoginPanel;
	private WaiterPanel waiterPanel;
	private ManagerPanel managerPanel;
	private AddEmployeePanel addEmployeePanel;
	private RemoveEmployeePanel removeEmployeePanel;
	private UpdateToManagerPanel updateToManagerPanel;
	private UpdateSalaryPanel updateSalaryPanel;

	public AppView() {
		setPropertyChangeSupport();

		orderPanel = new OrderPanel();
		introPanel = new IntroPanel();
		clientLoginPanel = new ClientLoginPanel();
		clientPanel = new ClientPanel();
		signUpPanel = new SignUpPanel();
		checkoutPanel = new CheckoutPanel();
		employeeLoginPanel = new EmployeeLoginPanel();
		waiterPanel = new WaiterPanel();
		managerPanel = new ManagerPanel();
		addEmployeePanel = new AddEmployeePanel();
		removeEmployeePanel = new RemoveEmployeePanel();
		updateToManagerPanel = new UpdateToManagerPanel();
		updateSalaryPanel = new UpdateSalaryPanel();

		orderPanel.addPropertyChangeListener(this);
		introPanel.addPropertyChangeListener(this);
		clientLoginPanel.addPropertyChangeListener(this);
		clientPanel.addPropertyChangeListener(this);
		signUpPanel.addPropertyChangeListener(this);
		checkoutPanel.addPropertyChangeListener(this);
		employeeLoginPanel.addPropertyChangeListener(this);
		waiterPanel.addPropertyChangeListener(this);
		managerPanel.addPropertyChangeListener(this);
		addEmployeePanel.addPropertyChangeListener(this);
		removeEmployeePanel.addPropertyChangeListener(this);
		updateToManagerPanel.addPropertyChangeListener(this);
		updateSalaryPanel.addPropertyChangeListener(this);

	}

	public void start() {
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
			changeWindows("OrderPanel", event.getNewValue());
		} else if (event.getPropertyName().equals("ClientLoginPanel")) {
			changeWindows("ClientLoginPanel", null);

		} else if (event.getPropertyName().equals("ClientPanel")) {
			changeWindows("ClientPanel", event.getNewValue());

		} else if (event.getPropertyName().equals("EmployeeLogin")) {
			changeWindows("EmployeeLogin", null);
		} else if (event.getPropertyName().equals("EmployeeLoginPanel")) {
			changeWindows("EmployeeLoginPanel", null);

		} else if (event.getPropertyName().equals("ManagerPanel")) {
			changeWindows("ManagerPanel", event.getNewValue());

		} else if (event.getPropertyName().equals("SignUpPanel")) {
			changeWindows("SignUpPanel", null);
		} else if (event.getPropertyName().equals("IntroPanel")) {
			changeWindows("IntroPanel", null);
		} else if (event.getPropertyName().equals("CheckoutPanel")) {
			changeWindows("CheckoutPanel", event.getNewValue());
		} else if (event.getPropertyName().equals("ReturnToOrderPanel")) {
			changeWindows("ReturnToOrderPanel", event.getNewValue());
		} else if (event.getPropertyName().equals("AddEmployeePanel")) {
			changeWindows("AddEmployeePanel", event.getNewValue());
		} else if (event.getPropertyName().equals("RemoveEmployeePanel")) {
			changeWindows("RemoveEmployeePanel", event.getNewValue());
		} else if (event.getPropertyName().equals("UpdateToManagerPanel")) {
			changeWindows("UpdateToManagerPanel", event.getNewValue());
		} else if (event.getPropertyName().equals("UpdateSalaryPanel")) {
			changeWindows("UpdateSalaryPanel", event.getNewValue());
		}

		else {
			// send the property change to the controller
			propertyChangeHandler.firePropertyChange(event.getPropertyName(), event.getOldValue(), event.getNewValue());
		}

	}

	// change to window and getting some value if we need to
	public void changeWindows(String newPanel, Object obj) {
		switch (newPanel) {
		case "IntroPanel":
			introPanel.panelActivity();

		case "SignUpPanel":
			signUpPanel.panelActivity();
			break;

		case "ClientLoginPanel":
			clientLoginPanel.panelActivity();
			break;

		case "ClientPanel":
			clientPanel.panelActivity((Client) obj);
			break;

		case "OrderPanel":
			orderPanel.panelActivity((Client) obj);
			break;

		case "ReturnToOrderPanel":
			orderPanel.makeOrder((Order) obj);
			break;

		case "CheckoutPanel":
			checkoutPanel.panelActivity((Order) obj);
			break;
		case "WaiterPanel":
			waiterPanel.panelActivity((Waiter) obj);
			break;

		case "ManagerPanel":
			managerPanel.panelActivity((Manager) obj);
			break;

		case "EmployeeLoginPanel":
			employeeLoginPanel.panelActivity();
			break;
		case "AddEmployeePanel":
			addEmployeePanel.panelActivity((Manager) obj);
			break;
		case "RemoveEmployeePanel":
			removeEmployeePanel.panelActivity((Manager) obj);
			break;
		case "UpdateToManagerPanel":
			updateToManagerPanel.panelActivity((Manager) obj);
			break;
		case "UpdateSalaryPanel":
			updateSalaryPanel.panelActivity((Manager) obj);
			break;
		}
	}

	public void printOrders(ArrayList<Order> orders) {
		if (orders.isEmpty())
			System.out.println("There are no orders at this time");
		else {
			for (Order order : orders) {
				order.printOrder();
				System.out.println("\n\n");
			}
		}

	}

	// print employees from database
	public void printAllEmployees(ArrayList<Employee> employees) {
		int i = 1;
		System.out.println("Employees of the resturant:");
		for (Employee employee : employees) {
			String managerOrWaiter = employee.getIsManager() ? "(Manager)" : "(Waiter)";
			System.out.println(i + "." + employee.getUsername() + " - " + employee.getFirstName() + " "
					+ employee.getLastName() + " " + managerOrWaiter);
			i++;
		}
		System.out.println("\n");

	}

	public void printSalaryCount(double salaryCount) {
		System.out.println("Your salary since you working in the resturant is: " + salaryCount + "\n");
	}

	public void Msg(String alert) {
		System.out.println(alert + "\n");
	}

}
