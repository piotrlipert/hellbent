package hellbent.content.actions;

import hellbent.concepts.Action;
import hellbent.concepts.Item;
import hellbent.entity.Entity;
import hellbent.world.Map;

public class Pickup extends Action
{

	Entity tmp;
	Item it;
	
	public Pickup(Entity e, Item i) 
	{
		super(e);
		it = i;
		this.time = it.get("WEIGHT") * 20;
		name = "PICKUP";
		
	}

	public void process(Map m) 
	{

		if (en.get("CAPACITY") + it.get("WEIGHT") < en.get("MAX_CAPACITY"))
		{
			it.onPickup(en);
			
			en.inventory.add(it);
			m.items.remove(it);
			
			en.addMessage("You grab "+it.getName()+".");
			
			
		}
		else
		{
			en.addMessage("You try to pickup "+it.getName()+" but it is too heavy.");
		}
		
	}
	
	
	
}
