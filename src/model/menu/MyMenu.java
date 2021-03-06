package model.menu;

import java.util.ArrayList;

import model.ItemInMenu;
import model.menu.BeefWelington;
import model.menu.Risoto;
import model.menu.CheeseCake;
import model.menu.Salad;
import model.menu.Steak;
import model.menu.Pizza;


public class MyMenu {
	private static ArrayList<ItemInMenu> instance = null;

	private MyMenu() {}

	//single menu list
	public static ArrayList<ItemInMenu> getInstance()
	{
		if (instance == null) {
			createMenuList();
		}
		return instance;
	}
	
	private static void createMenuList() {
		instance = new ArrayList<ItemInMenu>();
		instance.add(Salad.getInstance());
		instance.add(Pizza.getInstance());
		instance.add(Risoto.getInstance());
		instance.add(Steak.getInstance());
		instance.add(BeefWelington.getInstance());
		instance.add(CheeseCake.getInstance());
	}
}
