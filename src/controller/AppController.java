package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.AppModel;
import model.Client;
import model.Order;
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
				view.loginErrorMsg(); //prints error message
				view.changeWindows("ClientLoginPanel",null); //login again if wrong user
			}
		}
		else if(event.getPropertyName().equals("InsertNewOrderEvent"))
		{
			model.inserNewOrder(((Order)event.getNewValue()));
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
