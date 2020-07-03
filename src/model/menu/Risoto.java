package model.menu;

import model.ItemsInMenu;

public class Risoto extends ItemsInMenu
{
	private static Risoto instance=null;
	
	private Risoto() 
	{
		super("Risoto",40, " Cheesy Risoto with white wine reduction", 4);
	}
	
	public static Risoto getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new Risoto();
		}
		return instance;
	}


}
