package model;

public class PastaAlfredo extends ItemsInMenu
{
	private static PastaAlfredo instance=null;
	
	private PastaAlfredo() 
	{
		super("PastaAlfredo",40, " pasta with alfredo sauce", 4);
	}
	
	public static PastaAlfredo getInstance()//use singleton design pattern
	{
		if(instance==null) 
		{
			instance=new PastaAlfredo();
		}
		return instance;
	}


}
