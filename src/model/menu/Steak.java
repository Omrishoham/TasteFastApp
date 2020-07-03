package model.menu;

import model.ItemsInMenu;

public class Steak extends ItemsInMenu {
	
	private static Steak instance=null;
	
	private Steak() 
	{
		super("Steak",90, "Great cut with lots of fat", 2);
	}
	
	public static Steak getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new Steak();
		}
		return instance;
	}

}
