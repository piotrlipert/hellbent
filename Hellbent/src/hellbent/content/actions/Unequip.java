package hellbent.content.actions;

import hellbent.concepts.Action;
import hellbent.concepts.Item;
import hellbent.entity.Entity;
import hellbent.world.Map;

public class Unequip extends Action
{
	Item equipped;
	int slotid;
	public Unequip(Entity e, Item i) 
	{
		super(e);
		equipped = i;
		time = 50;
		this.setInstant(true);
		
	}
	public void process(Map m) 
	{
	
	
		for (int k : en.slots.keySet())
		{
			if (en.slots.get(k) == equipped)
			{
				if (equipped.onRemove(en))
				{
					equipped.set("EQUIPPED", 0);
					equipped.set("EQUIPPED_SLOT", 0);

					en.slots.remove(k);
					System.out.println("REMOVED");
					break;
					
				}
				
			}
		
		}
	
	
	
	}

}
