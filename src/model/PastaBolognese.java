package model;

public class PastaBolognese extends ItemsInMenu
{
	private static PastaBolognese instance=null;
	
	private PastaBolognese() 
	{
		super("Pasta Bolognese",45, " pasta with bolognese sauce", 3);
	}
	
	public static PastaBolognese getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new PastaBolognese();
		}
		return instance;
	}


}
