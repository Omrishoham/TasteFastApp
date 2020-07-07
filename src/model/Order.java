package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;

public class Order
{
	private String username;
	private ArrayList<ItemInMenu> shoppingCart;
	private double totalPrice;
	private String orderID;
	private String creditCardNumber;
	private String validityCreditCard;
	private String orderTime;
	private String orderDate;
	
	//constructor for new order to insert to database
	public Order(String username)
	{
		this.totalPrice=0;
		this.username = username;
        this.orderID=UUID.randomUUID().toString();
        this.shoppingCart= new ArrayList<ItemInMenu>();
	}
	
	//constructor for order we pull from database
	public Order(String username,double totalPrice,String orderID,String orderTime,String orderDate,String creditCardNum,String creditCardVal)
	{
		this.username = username;
		this.totalPrice = totalPrice;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.creditCardNumber = creditCardNum;
		this.validityCreditCard = creditCardVal;
		this.shoppingCart = new ArrayList<ItemInMenu>();
	}
	
	
	
	public void printOrder() {
		System.out.println("Order ID: " +this.orderID
							+"\nTotal Price: " +this.totalPrice
							+"\nOrder Time:"+this.orderTime
							+"\nOrder Date:"+this.orderDate
							+"\nOrdered by: " +this.username+"\n" );
							
	}
	public void setShoppingCart(ArrayList<ItemInMenu> shoppingCart)
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
	public void setUsername(String whoOrdered) {
		this.username = whoOrdered;
	}
	
	public ArrayList<ItemInMenu> getShoppingCart()
	{
		return this.shoppingCart;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public String getUsername() {
		return username;
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
	public String getOrderDate() {
		return this.orderDate;
	}
	public String getOrderTime() {
		return this.orderTime;
	}
	public void setDateAndTime()
	{
		Date dateObj = new Date();
		int year = dateObj.getYear()+1900;
		int month = dateObj.getMonth()+1;
		this.orderDate = dateObj.getDate()+"/"+month+"/"+year;
		this.orderTime=dateObj.getHours()+":"+dateObj.getMinutes();
		
	}
	
}
