package model;

public class CheeseCake extends ItemsInMenu {
	private static CheeseCake instance=null;
	
	//ohh i LOVE CheeseCake
	private CheeseCake() 
	{
		super("Cheese Cake",20, " Cheese Cake", 6);
	}
	
	public static CheeseCake getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new CheeseCake();
		}
		return instance;
	}

}
