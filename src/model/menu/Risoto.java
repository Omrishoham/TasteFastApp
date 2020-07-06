package model.menu;

import model.ItemInMenu;

public class Risoto extends ItemInMenu
{
	private static Risoto instance=null;
	
	private Risoto() 
	{
		super("Risoto",40);
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
