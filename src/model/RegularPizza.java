package model;

public class RegularPizza extends ItemsInMenu {
	
		
		private static RegularPizza instance=null;
		
		private RegularPizza() 
		{
			super("Regular Pizza",30, " pizza with mozzarella cheese", 1);
		}
		
		public static RegularPizza getInstance()//use singleton design pattern
		{
			if(instance==null) 
			{
				instance=new RegularPizza();
			}
			return instance;
		}

	}

