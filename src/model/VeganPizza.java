package model;

public class VeganPizza extends ItemsInMenu {
	
	private static VeganPizza instance=null;
	
	private VeganPizza() 
	{
		super("Vegan Pizza",35, "pizza with vegan cheese", 2);
	}
	
	public static VeganPizza getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new VeganPizza();
		}
		return instance;
	}

}
