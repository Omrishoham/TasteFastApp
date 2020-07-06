package model;

public abstract class ItemInMenu implements Product {
	protected String itemName;
	protected double price;
	
	public ItemInMenu(String itemName,double price) 
	{
		this.itemName=itemName;
		this.price=price;
	}
	
	public String getProductName()
	{
		return this.itemName;
	}
	public double getPrice()
	{
		return this.price;
	}
	
	public void printItem() {
		System.out.println(this.getProductName()+": " +this.getPrice()+" ILS");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return this.getProductName()+": " +this.getPrice()+" ILS\n";
		
	}

}

