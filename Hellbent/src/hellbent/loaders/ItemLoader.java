package hellbent.loaders;

import hellbent.concepts.Item;
import hellbent.content.items.Axe;
import hellbent.content.items.Scimitar;
import hellbent.content.items.Spear;
import hellbent.entity.Entity;
import hellbent.entity.Monster;

import java.util.HashMap;

public class ItemLoader {
	public HashMap<String,Item> items = new HashMap<String,Item>();

	public ItemLoader()
	{
		
		items.put("G_SCIMITAR", new Scimitar());
		items.put("G_AXE", new Axe());
		items.put("G_SPEAR", new Spear());

		
		
	}

	public Item getItem(String name)
	{
		return (items.get(name)).clone();
	}






}
