package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.stream.ImageInputStream;

import model.ItemsInMenu;
import model.Order;

public class CheckoutPanel {

	private PropertyChangeSupport propertyChangeHandler;

	// private ArrayList<ItemsInMenu> shoppingCart;

	public CheckoutPanel() {
		setPropertyChangeSupport();
	}

	public void panelActivity(Order order) {
		Scanner input = new Scanner(System.in);
		System.out.println("Order ID: " + order.getOrderID());
		System.out.println("Cart:");
		for (ItemsInMenu itemsInMenu : order.getShoppingCart()) {
			itemsInMenu.printItem();
		}
		System.out.println("Total price: " + order.getTotalPrice());
		System.out.println();
		
		System.out.println("1.To confirm order and make payment\n2.Return to make changes");

		int numPress = input.nextInt();
		switch (numPress){
		//enter payment details
		case 1:
			Scanner input2 = new Scanner(System.in);
			System.out.println("Make payment with credit card:\n");
			System.out.println("Enter Credit Card Number: ");
			String creditCard = input2.nextLine();

			while (creditCard.equals("")) {
				System.out.println("error! enter again credit card number:");
				creditCard = input2.nextLine();
			}
			order.setCreditCartNumber(creditCard);

			System.out.println("Enter validity Credit Card(like \"05/21\"): ");
			String validity = input2.nextLine();

			while (validity.equals("")) {
				System.out.println("error! enter again validity credit card:");
				validity = input2.nextLine();
			}
			order.setValidityCreditCard(validity);
			System.out.println("Thanks, Your Order received successfuly!");
			order.setDateAndTime();

			// taking care of insert order to orders database
			propertyChangeHandler.firePropertyChange("InsertNewOrderEvent", 0, order);
			break;
			//return to order panel
		case 2:
			propertyChangeHandler.firePropertyChange("ReturnToOrderPanel", 0, order);
			break;
		}
	       Random rand = new Random();
	       int low = 20;
	       int high = 30;
	       int result = rand.nextInt(high-low) + low;
		System.out.println("In "+result+" Minutes You Will Get Your Order");
		System.out.println("Press 1 to client menu");
		Scanner input3 = new Scanner(System.in);
		numPress = input3.nextInt();
		switch(numPress) {
		case 1:
			propertyChangeHandler.firePropertyChange("IntroPanel", 0, 1);
		}
		
		

	}

	
	
	
	public void setPropertyChangeSupport() {
		propertyChangeHandler = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeHandler.addPropertyChangeListener(listener);
	}
}
