package model;

import java.util.ArrayList;
import java.util.Random;

public class Order
{
	private String whoOrdered;
	private ArrayList<ItemsInMenu> shoppingCart;
	private double totalPrice;
	private int orderNumber;
	private String cretidCardNumber;
	private String validityCreditCard;
	
	public Order(String username)
	{
		this.totalPrice=0;
		this.whoOrdered = username;
        Random rand = new Random(); 
        this.orderNumber = rand.nextInt(100000);
        this.shoppingCart= new ArrayList<>();
	}
	public void setShoppingCart(ArrayList<ItemsInMenu> shoppingCart)
	{
		this.shoppingCart = shoppingCart;
	}
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public ArrayList<ItemsInMenu> getShoppingCart()
	{
		return this.shoppingCart;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setCreditCartNumber(String creditCardNumber)
	{
		this.cretidCardNumber = creditCardNumber;
	}
	public void setValidityCreditCard(String validity)
	{
		this.validityCreditCard = validity;
	}

}
