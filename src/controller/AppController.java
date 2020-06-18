package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.AppModel;
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
			model.signUpClient(
					view.getUsernameSignUp(),
					view.getPasswordSignUp(),
					view.getEmailSignUp(),
					view.getFirstNameSignUp(),
					view.getLastNameSignUp());
		}
		else if(event.getPropertyName().equals("ClientLoginEvent")) {
			
			if (model.loginClientAuth(view.getUsernameClientLogin(), view.getPasswordClientLogin())) {
				
				view.changeWindows("ClientPanel"); //after success login move to client panel
			}
			else {
				view.loginErrorMsg(); //prints error message
				view.changeWindows("ClientLoginPanel"); //login again if wrong user
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
	
	}
}
