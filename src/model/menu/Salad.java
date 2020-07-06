package model.menu;

import model.ItemInMenu;

public class Salad extends ItemInMenu {
	private static Salad instance=null;
	
	private Salad() 
	{
		super("Salad",15);
	}
	
	public static Salad getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new Salad();
		}
		return instance;
	}

}
