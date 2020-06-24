package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import model.AppModel;
import model.Client;
import model.Employee;
import model.Manager;
import model.Order;
import model.Waiter;
import view.AppView;


public class AppController implements PropertyChangeListener {
	private AppModel model;
    private AppView view;
    
	public AppController(AppModel model,AppView view)//constructor
	{
		this.model=model;
		this.view=view;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) 
	{
		if(event.getPropertyName().equals("SignUpClientEvent"))
		{
			model.signUpClient((Client)event.getNewValue());
		}
		else if(event.getPropertyName().equals("ClientLoginEvent")) {
			
			if (model.loginClientAuth(((Client)event.getNewValue()).getUsername(),((Client) event.getNewValue()).getPassword())) {
				
				view.changeWindows("ClientPanel",event.getNewValue()); //after success login move to client panel
			}
			else {
				view.Msg("user is not found!!"); //prints error message
				view.changeWindows("ClientLoginPanel",null); //login again if wrong user
			}
		}
		else if(event.getPropertyName().equals("InsertNewOrderEvent"))
		{
			model.inserNewOrder(((Order)event.getNewValue()));
		}
		//check if employee exist in database ,after that check if its a manager or employee
		else if(event.getPropertyName().equals("EmployeeLoginEvent"))
		{
			//check if employee in database
			if(model.loginEmployeeAuth(((Employee)event.getNewValue()).getUsername(),((Employee) event.getNewValue()).getPassword()))
			{
				//check if is a manager, and wither way place the other values to object employee 
				if(model.ifEmployeeManager(((Employee)event.getNewValue()).getUsername(),((Employee) event.getNewValue()).getPassword()))
				{		
					      Employee employee = model.placeValues(((Employee) event.getNewValue()).getUsername(), ((Employee) event.getNewValue()).getPassword());
					      Manager manager = new Manager(employee.getUsername(),employee.getPassword(),employee.getsalaryPerHour());
					      view.changeWindows("ManagerPanel",(Object)manager);
				}		
				else 
				{
				Employee employee = model.placeValues(((Employee) event.getNewValue()).getUsername(), ((Employee) event.getNewValue()).getPassword());
			    Waiter waiter = new Waiter(employee.getUsername(),employee.getPassword(),employee.getsalaryPerHour());
			    view.changeWindows("WaiterPanel",(Object)waiter);
				}
			}
			else
			{
			view.Msg("user is not found!!");
			view.changeWindows("EmployeeLoginPanel", null);
			}
		}
		else if(event.getPropertyName().equals("PrintOrdersEvent")) {
			model.printOrders();
			view.changeWindows("ManagerPanel", event.getNewValue());
		}
		else if(event.getPropertyName().equals("AddEmployeeEvent")) {
			if(!model.ifExist(((Employee) event.getNewValue()).getUsername())) {
				model.addEmployee((Employee)event.getNewValue());
				view.Msg("employee added successfuly!");
				view.changeWindows("ManagerPanel", event.getOldValue());
			}
			else {
				view.Msg("username's employee is exist!!");
				view.changeWindows("AddEmployeePanel", event.getOldValue());
			}		
		}
		else if(event.getPropertyName().equals("RemoveEmployeeEvent")){
			if(model.ifExist((String)event.getNewValue())) {
				model.removeEmployee((String)event.getNewValue());
				view.Msg("employee removed successfuly!");
				view.changeWindows("ManagerPanel", event.getOldValue());
			}
			else {
				view.Msg("employee not found!!");
				view.changeWindows("RemoveEmployeePanel", event.getOldValue());
			}		
		}
			
	}

	public static void main(String[] args) {
	AppModel model = new AppModel();		
	AppView view = new AppView();
	AppController controller = new AppController(model, view);
	
	////our controller will listen to the model and the view events
	view.addPropertyChangeListener(controller);
	model.addPropertyChangeListener(controller);
	
	//start display after connecting items
	view.start();
	
	}
}
