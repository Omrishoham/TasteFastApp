package model.menu;

import model.ItemInMenu;

public class Pizza extends ItemInMenu {
	
		
		private static Pizza instance=null;
		
		private Pizza() 
		{
			super("Pizza",30);
		}
		
		public static Pizza getInstance()//use singleton design pattern
		{
			if(instance==null) 
			{
				instance=new Pizza();
			}
			return instance;
		}

	}

