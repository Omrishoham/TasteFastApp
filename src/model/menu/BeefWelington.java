package model.menu;

import model.ItemsInMenu;

public class BeefWelington extends ItemsInMenu
{
	private static BeefWelington instance=null;
	
	private BeefWelington() 
	{
		super("Beef Welington",75, " Gordon Ramsay's Special!", 3);
	}
	
	public static BeefWelington getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new BeefWelington();
		}
		return instance;
	}


}
