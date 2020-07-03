package model.menu;

import model.ItemsInMenu;

public class Pizza extends ItemsInMenu {
	
		
		private static Pizza instance=null;
		
		private Pizza() 
		{
			super("Pizza",30, " pizza with mozzarella cheese", 1);
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

