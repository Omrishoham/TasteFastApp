package model;

public abstract class ItemsInMenu implements Product {
	protected String itemName;
	protected double price;
	protected String description;
	protected int serialNumber;
	
	public ItemsInMenu(String itemName,double price,String description,int serialNumber) 
	{
		this.itemName=itemName;
		this.price=price;
		this.description=description;
		this.serialNumber = serialNumber;
	}
	
	public String getProductName()
	{
		return this.itemName;
	}
	public double getPrice()
	{
		return this.price;
	}
	public String getDescription()
	{
		return this.description;
	}
	public int getSerialNumber()
	{
		return this.serialNumber;
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

