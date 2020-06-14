package view;

import java.awt.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import model.IProduct;
import model.ItemsInMenu;
import model.CheeseCake;
import model.ChocolateMousse;
import model.PastaAlfredo;
import model.PastaBolognese;
//import model.Product;
import model.RegularPizza;
import model.VeganPizza;

public class OrderPanel 
{
	private PropertyChangeSupport propertyChangeHandler;
	private ArrayList<ItemsInMenu> shoppingCart= new ArrayList<>(); //to add dynamically
	private ArrayList<ItemsInMenu> menu2 = new ArrayList<>(); //constant menu list
	
	
	public OrderPanel()
	{
		setPropertyChangeSupport();
		
		//fill menu with items
		menu2.add(RegularPizza.getInstance());
		menu2.add(VeganPizza.getInstance());
		menu2.add(PastaBolognese.getInstance());
		menu2.add(PastaAlfredo.getInstance());
		menu2.add(ChocolateMousse.getInstance());
		menu2.add(CheeseCake.getInstance());	
	}
	
	public void panelActivity()
	{
		
		//instructions
		System.out.println("Instructions:\n"
				+ "Write \"add\" and the number of the item from menu to add it to cart\n"
				+ "Write \"remove\" and the number of the item from menu to remove from cart\n"
				+ "Example: \"add 2\" or \"remove 5\"\n"
				+ "Enter 0 to accept order and procceed\n");
		
		//items
		System.out.println("Menu:\n");
		
		//print menu
		int i = 0;
		while(i< menu2.size()) {
			System.out.print( (i+1) + ". ");
			menu2.get(i).printItem();
			i++;
		}
		
		double totalPrice = 0;
		Scanner input = new Scanner(System.in);
		String removeOrAddInput = input.nextLine();
		
		while(!removeOrAddInput.equals("0")) {
			int j;
	
			switch (removeOrAddInput) {
			case "add 1":
				j = 0;
				shoppingCart.add(menu2.get(j));
				System.out.println(menu2.get(j).getProductName()+" added to cart");
				totalPrice+=menu2.get(j).getPrice();
				break;
				
			case "remove 1":
				j = 0;
				
				if(shoppingCart.contains(menu2.get(j))) {
					shoppingCart.remove(j);
					System.out.println(menu2.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu2.get(j).getPrice();
				}
				else {
					System.out.println(menu2.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 2":
				j = 1;
				shoppingCart.add(menu2.get(j));
				System.out.println(menu2.get(j).getProductName()+" added to cart");
				totalPrice+=menu2.get(j).getPrice();
				break;
				
			case "remove 2":
				j = 1;
				if(shoppingCart.contains(menu2.get(j))) {
					shoppingCart.remove(j);
					System.out.println(menu2.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu2.get(j).getPrice();
				}
				else {
					System.out.println(menu2.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 3":
				j = 2;
				shoppingCart.add(menu2.get(j));
				System.out.println(menu2.get(j).getProductName()+" added to cart");
				totalPrice+=menu2.get(j).getPrice();
				break;
				
			case "remove 3":
				j = 2;
				if(shoppingCart.contains(menu2.get(j))) {
					shoppingCart.remove(j);
					System.out.println(menu2.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu2.get(j).getPrice();
				}
				else {
					System.out.println(menu2.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 4":
				j = 3;
				shoppingCart.add(menu2.get(j));
				System.out.println(menu2.get(j).getProductName()+" added to cart");
				totalPrice+=menu2.get(j).getPrice();
				break;
				
			case "remove 4":
				j = 3;
				if(shoppingCart.contains(menu2.get(j))) {
					shoppingCart.remove(j);
					System.out.println(menu2.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu2.get(j).getPrice();
				}
				else {
					System.out.println(menu2.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 5":
				j = 4;
				shoppingCart.add(menu2.get(j));
				System.out.println(menu2.get(j).getProductName()+" added to cart");
				totalPrice+=menu2.get(j).getPrice();
				break;
				
			case "remove 5":
				j = 4;
				if(shoppingCart.contains(menu2.get(j))) {
					shoppingCart.remove(j);
					System.out.println(menu2.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu2.get(j).getPrice();
				}
				else {
					System.out.println(menu2.get(j).getProductName()+" not in cart!");
				}
				break;
				
			case "add 6":
				j = 5;
				shoppingCart.add(menu2.get(j));
				System.out.println(menu2.get(j).getProductName()+" added to cart");
				totalPrice+=menu2.get(j).getPrice();
				break;
				
			case "remove 6":
				j = 5;
				if(shoppingCart.contains(menu2.get(j))) {
					shoppingCart.remove(j);
					System.out.println(menu2.get(j).getProductName()+" was removed from cart");
					totalPrice-=menu2.get(j).getPrice();
				}
				else {
					System.out.println(menu2.get(j).getProductName()+" not in cart!");
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
