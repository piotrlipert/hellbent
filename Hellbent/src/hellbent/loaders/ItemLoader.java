package hellbent.loaders;

import hellbent.concepts.Item;
import hellbent.entity.Monster;

import java.util.HashMap;

public class ItemLoader {
	public HashMap<String,Item> items = new HashMap<String,Item>();

	public ItemLoader()
	{
		
		
		
	}

	public Item getItem(String name)
	{
		return (items.get(name)).clone();
	}
}
