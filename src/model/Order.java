package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;

public class Order
{
	private String whoOrdered;
	private ArrayList<ItemsInMenu> shoppingCart;
	private double totalPrice;
	private String orderID;
	private String creditCardNumber;
	private String validityCreditCard;
	private Date orderTime;
	
	public Order(String username)
	{
		this.totalPrice=0;
		this.setWhoOrdered(username);
        this.orderID=UUID.randomUUID().toString();
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
	public void setCreditCartNumber(String creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}
	public void setValidityCreditCard(String validity)
	{
		this.validityCreditCard = validity;
	}
	public void setWhoOrdered(String whoOrdered) {
		this.whoOrdered = whoOrdered;
	}
	
	public ArrayList<ItemsInMenu> getShoppingCart()
	{
		return this.shoppingCart;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public String getWhoOrdered() {
		return whoOrdered;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public String getValidityCreditCard()
	{
		return this.validityCreditCard;
	}
	public Date getOrderDate()
	{
		return this.orderTime;
	}
	public void setOrderDate()
	{
		this.orderTime = new Date();
	}
	
}
