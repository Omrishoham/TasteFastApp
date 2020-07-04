package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Scanner;

import model.menu.MyMenu;
import model.ItemsInMenu;
import model.Order;
import model.Client;

public class OrderPanel 
{
	private PropertyChangeSupport propertyChangeHandler;
	private Order newOrder;
	private ArrayList<ItemsInMenu> menu;
	public OrderPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity(Client client)
	{
		Scanner input1 = new Scanner(System.in);
		System.out.println("1.Continue to make order/n0.Back");
		int numPress1 = input1.nextInt();
		switch (numPress1){
		case 0:
			propertyChangeHandler.firePropertyChange("ClientPanel", 0, client);
			break;
		case 1:
		this.menu = MyMenu.getInstance();
		//menu.clear();
		this.newOrder = new Order(client.getUsername());
		makeOrder(this.newOrder);
		}
	}
	public void makeOrder(Order order)
	{
		//setting temp shopping cart and total price
		ArrayList<ItemsInMenu> shoppingCart=new ArrayList<>(order.getShoppingCart());
		double totalPrice=order.getTotalPrice();
		Scanner input = new Scanner(System.in);
		
		//items
				System.out.println("Menu:\n");
				
				//print menu
				int i = 0;
				while(i< menu.size()) {
					System.out.print( (i+1) + ". ");
					menu.get(i).printItem();
					i++;
				}
		
		System.out.println("\nInstructions:\n"
				+ "Write \"add\" and the number of the item from menu to add it to cart\n"
				+ "Write \"remove\" and the number of the item from menu to remove from cart\n"
				+ "Example: \"add 2\" or \"remove 5\"\n"
				+ "Enter 0 to accept order and procceed\n");
		
		
		//if cart is already been changed
		if(!shoppingCart.isEmpty()) {
			System.out.println("Cart:");
			for(ItemsInMenu itemsInMenu : shoppingCart) {
				itemsInMenu.printItem();
			}
			System.out.println("Total price: " +totalPrice + " ILS");
		}
		
		String removeOrAddInput = input.nextLine();
		
		while(!removeOrAddInput.equals("0")) {
			int j;
	
			switch (removeOrAddInput) {
			case "add 1":
				j = 0;
				shoppingCart.add(menu.get(j));
				System.out.println(menu.get(j).getProductName()+" added to cart");
				totalPrice+=menu.get(j).getPrice();
				break;
				
			case "remove 1":
				j = 0;
				
				if(shoppingCart.contains(menu.get(j))) {
					shoppingCart.remove(menu.get(j));
					System.out.println(menu.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu.get(j).getPrice();
				}
				else {
					System.out.println(menu.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 2":
				j = 1;
				shoppingCart.add(menu.get(j));
				System.out.println(menu.get(j).getProductName()+" added to cart");
				totalPrice+=menu.get(j).getPrice();
				break;
				
			case "remove 2":
				j = 1;
				if(shoppingCart.contains(menu.get(j))) {
					shoppingCart.remove(menu.get(j));
					System.out.println(menu.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu.get(j).getPrice();
				}
				else {
					System.out.println(menu.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 3":
				j = 2;
				shoppingCart.add(menu.get(j));
				System.out.println(menu.get(j).getProductName()+" added to cart");
				totalPrice+=menu.get(j).getPrice();
				break;
				
			case "remove 3":
				j = 2;
				if(shoppingCart.contains(menu.get(j))) {
					shoppingCart.remove(menu.get(j));
					System.out.println(menu.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu.get(j).getPrice();
				}
				else {
					System.out.println(menu.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 4":
				j = 3;
				shoppingCart.add(menu.get(j));
				System.out.println(menu.get(j).getProductName()+" added to cart");
				totalPrice+=menu.get(j).getPrice();
				break;
				
			case "remove 4":
				j = 3;
				if(shoppingCart.contains(menu.get(j))) {
					shoppingCart.remove(menu.get(j));
					System.out.println(menu.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu.get(j).getPrice();
				}
				else {
					System.out.println(menu.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 5":
				j = 4;
				shoppingCart.add(menu.get(j));
				System.out.println(menu.get(j).getProductName()+" added to cart");
				totalPrice+=menu.get(j).getPrice();
				break;
				
			case "remove 5":
				j = 4;
				if(shoppingCart.contains(menu.get(j))) {
					shoppingCart.remove(menu.get(j));
					System.out.println(menu.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu.get(j).getPrice();
				}
				else {
					System.out.println(menu.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 6":
				j = 5;
				shoppingCart.add(menu.get(j));
				System.out.println(menu.get(j).getProductName()+" added to cart");
				totalPrice+=menu.get(j).getPrice();
				break;
				
			case "remove 6":
				j = 5;
				if(shoppingCart.contains(menu.get(j))) {
					shoppingCart.remove(menu.get(j));
					System.out.println(menu.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu.get(j).getPrice();
				}
				else {
					System.out.println(menu.get(j).getProductName()+" not in cart!");
				}
				break;

			default:
				System.out.println("Please select valid item");
				break;
			}
			
			//continue to get input until 0
			removeOrAddInput = input.nextLine();
		}
		
		//print order details
		System.out.println("Cart:");
		for(ItemsInMenu itemsInMenu : shoppingCart) {
			itemsInMenu.printItem();
		}
		System.out.println("Total price: " +totalPrice);
		
		order.setShoppingCart(shoppingCart);
		order.setTotalPrice(totalPrice);
		
		//move to cart panel to select payment method
		System.out.println("1.Proceed to checkout");
		int numPress = input.nextInt();
		if(numPress == 1)
		{
			propertyChangeHandler.firePropertyChange("CheckoutPanel", 0, order);
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
