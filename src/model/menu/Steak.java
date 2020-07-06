package model.menu;

import model.ItemInMenu;

public class Steak extends ItemInMenu {
	
	private static Steak instance=null;
	
	private Steak() 
	{
		super("Steak", 120);
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
