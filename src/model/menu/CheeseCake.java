package model.menu;

import model.ItemInMenu;

public class CheeseCake extends ItemInMenu {
	private static CheeseCake instance=null;
	
	private CheeseCake() 
	{
		super("Cheese Cake",20);
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
