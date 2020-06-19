package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.stream.ImageInputStream;

import model.ItemsInMenu;
import model.Order;

public class CartPanel {
	
	private PropertyChangeSupport propertyChangeHandler;
	
	//private ArrayList<ItemsInMenu> shoppingCart;
	
	public CartPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Order order) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cart:");
		for(ItemsInMenu itemsInMenu : order.getShoppingCart()) {
			itemsInMenu.printItem();
		}
		System.out.println("Total price: " +order.getTotalPrice());
		System.out.println("For doing changes in cart- press 1\nFor confirm order and make payment in credit card press 2");
		int numPress = input.nextInt();
		switch (numPress) {
		case 1:
			//פה יהיה קייס שבו יש אפשרות להוסיף או למחוק מההזמנה (עדיף שיהיה כפעולה מהאובייקט אורדר)
			break;
		case 2:
			System.out.println("Enter Credit Card Number: ");
			String creditCard = input.nextLine();
			
			while(creditCard=="")
			{
				System.out.println("error! enter again credit card number:");
				creditCard= input.nextLine();
			}
			order.setCreditCartNumber(creditCard);
			
			System.out.println("Enter validity Credit Card(like \"05/21\"): ");
			String validity = input.nextLine();
			
			while(validity=="")
			{
				System.out.println("error! enter again validity credit card:");
				validity= input.nextLine();
			}
			order.setValidityCreditCard(validity);
			System.out.println("Thanks, Your Order received successfuly!");
			
			//פה צריך להכניס את ההזמנה לדטה בייס של הזמנות
			
			
		}	
	}
	
	public void setPropertyChangeSupport() 
	{
		propertyChangeHandler = new PropertyChangeSupport(this);
	}
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeHandler.addPropertyChangeListener(listener); 
	}
}

