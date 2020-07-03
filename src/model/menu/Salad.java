package model.menu;

import model.ItemsInMenu;

public class Salad extends ItemsInMenu {
	private static Salad instance=null;
	
	private Salad() 
	{
		super("Salad",15, "Tomatos & Cucumbers", 5);
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
