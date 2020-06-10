package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.CheeseCake;
import model.ChocolateMousse;
import model.PastaAlfredo;
import model.PastaBolognese;
import model.Product;
import model.RegularPizza;
import model.VeganPizza;

public class OrderPanel 
{
	private PropertyChangeSupport propertyChangeHandler;
	private HashMap<String,Integer> shoppingCart= new HashMap<String,Integer>();
	private ArrayList<Product> menu;
	
	
	
	public OrderPanel()
	{
		setPropertyChangeSupport();
	}
	
	public void panelActivity()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Instructions:\nTo add item and his quentity to cart use this action-\"+serial number of product,quentity\"\nFor example-\"+1,2\"\nTo remove item and his quentity use this action-\"-serial number of product,quentity\"\nFor Example-\"-5,1\"");
		System.out.println("Menu:\n"
				+RegularPizza.getInstance().getSerialNumber()+"."+"Regular pizza"+"-"+RegularPizza.getInstance().getPrice()+" ils\n"
				+VeganPizza.getInstance().getSerialNumber()+"."+"Vegan pizza"+"-"+VeganPizza.getInstance().getPrice()+" ils\n"
				+PastaBolognese.getInstance().getSerialNumber()+"."+"Pasta bolognese"+"-"+PastaBolognese.getInstance().getPrice()+" ils\n"
				+PastaAlfredo.getInstance().getSerialNumber()+"."+"Pasta alfredo"+"-"+PastaAlfredo.getInstance().getPrice()+" ils\n"
				+ChocolateMousse.getInstance().getSerialNumber()+"."+"Chocolate mousse"+"-"+ChocolateMousse.getInstance().getPrice()+" ils\n"
				+CheeseCake.getInstance().getSerialNumber()+"."+"Cheesecake"+"-"+CheeseCake.getInstance().getPrice()+" ils");
		String[] addOrRemove = new String().split(input.nextLine());	
		
		
		
		if(addOrRemove.toString().contains("+"))
		{
			menu.put(addOrRemove[1],)//in programming
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
