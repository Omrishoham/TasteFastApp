package model.menu;

import model.ItemInMenu;

public class BeefWelington extends ItemInMenu
{
	private static BeefWelington instance=null;
	
	private BeefWelington() 
	{
		super("Beef Welington",75);
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
