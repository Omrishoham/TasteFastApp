package model;

public class ChocolateMousse extends ItemsInMenu {
	private static ChocolateMousse instance=null;
	
	private ChocolateMousse() 
	{
		super("Chocolate Mousse",15, " Chocolate Mousse", 5);
	}
	
	public static ChocolateMousse getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new ChocolateMousse();
		}
		return instance;
	}

}
