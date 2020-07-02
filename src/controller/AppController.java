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
			if(!(model.ifClientExist(((Client)event.getNewValue()).getUsername(),((Client) event.getNewValue()).getEmail()))) {
				model.signUpClient((Client)event.getNewValue());
				view.Msg("client sign up successfuly");
			}
				else {
					view.Msg("username or email exists!!");
					view.changeWindows("SignUpPanel", null);
				}
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
					      Manager manager = new Manager(employee.getUsername(),employee.getPassword(),employee.getSalaryPerHour(),employee.getSalarySum(),employee.getFirstName(),employee.getLastName());
					      model.getOnShiftEmployees().add(manager);
					      view.changeWindows("ManagerPanel",(Object)manager);
				}		
				else 
				{
				Employee employee1 = model.placeValues(((Employee) event.getNewValue()).getUsername(), ((Employee) event.getNewValue()).getPassword());
			    Waiter waiter = new Waiter(employee1.getUsername(),employee1.getPassword(),employee1.getSalaryPerHour(),employee1.getSalarySum(),employee1.getFirstName(),employee1.getLastName());
			    model.getOnShiftEmployees().add(waiter);
			    view.changeWindows("WaiterPanel",(Object)waiter);
				}
			}
			else
			{
			view.Msg("employee is not found!!");
			view.changeWindows("EmployeeLoginPanel", null);
			}
		}
		else if(event.getPropertyName().equals("PrintOrdersEvent")) {
			
			view.printOrders(model.getOrdersDB());
			view.changeWindows("ManagerPanel", event.getNewValue());
		}
		else if(event.getPropertyName().equals("AddEmployeeEvent")) {
			if(!model.ifEmployeeExist(((Employee) event.getNewValue()).getUsername())) {
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
			if(model.ifEmployeeExist((String)event.getNewValue())) {
				model.removeEmployee((String)event.getNewValue());
				view.Msg("employee removed successfuly!");
				view.changeWindows("ManagerPanel", event.getOldValue());
			}
			else {
				view.Msg("employee not found!!");
				view.changeWindows("RemoveEmployeePanel", event.getOldValue());
			}		
		}
		else if(event.getPropertyName().equals("UpdateToManagerEvent")) {
			if(model.ifEmployeeExist(((Employee) event.getNewValue()).getUsername())){
				model.updateToManager(((Employee) event.getNewValue()).getUsername(),((Employee) event.getNewValue()).getSalaryPerHour());
				view.Msg("waiter updated to manager successfuly");
				view.changeWindows("ManagerPanel", event.getOldValue());
			} else {
				view.Msg("waiter is not found");
				view.changeWindows("UpdateToManagerPanel", event.getOldValue());
					
				}
			
			}
		else if(event.getPropertyName().equals("UpdateSalaryEvent")) {
			if(model.ifEmployeeExist(((Employee) event.getNewValue()).getUsername())) {
				model.updateSalary((((Employee) event.getNewValue()).getUsername()),(((Employee) event.getNewValue()).getSalaryPerHour()));
				view.Msg("employee's salary updated successfuly");
				view.changeWindows("ManagerPanel", event.getOldValue());
			}
			 else {
					view.Msg("employee is not found");
					view.changeWindows("UpdateSalaryPanel", event.getOldValue());
						
					}
			}
		else if(event.getPropertyName().equals("LogoutEmployeeEvent")) {
			model.updateTotalSalary(((Employee) event.getNewValue()).getUsername(),((Employee) event.getNewValue()).calcWorkTime());
			model.getOnShiftEmployees().remove((Employee)event.getNewValue());
			view.Msg("logged out succefuly\n");
			view.changeWindows("IntroPanel", 1);
		}
		
		else if(event.getPropertyName().equals("PrintSalaryEvent")) {
			double salaryCount = model.getSalaryCount(((Employee) event.getNewValue()).getUsername());
			view.printSalaryCount(salaryCount);
			view.changeWindows("WaiterPanel", event.getNewValue());
		}
		
		else if(event.getPropertyName().equals("SeeOnShiftEvent")) {
			view.printOnShiftEmployees(model.getOnShiftEmployees());
			view.changeWindows("ManagerPanel", event.getNewValue());
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
