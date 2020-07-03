package model.menu;

import model.ItemsInMenu;

public class CheeseCake extends ItemsInMenu {
	private static CheeseCake instance=null;
	
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
