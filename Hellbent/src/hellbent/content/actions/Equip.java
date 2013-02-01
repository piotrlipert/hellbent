package hellbent.content.actions;

import hellbent.concepts.Action;
import hellbent.concepts.Item;
import hellbent.entity.Entity;
import hellbent.world.Map;

public class Equip extends Action
{
	Item equipped;
	int slotid;
	public Equip(Entity e, Item i, int sid) 
	{
		super(e);
		equipped = i;
		time = 50;
		slotid = sid;
		this.setInstant(true);
		
	}
	public void process(Map m) 
	{
		if (slotid != 0)
		{
			if (en.getItemAtSlot(slotid) == null)
			{
				if (equipped.onEquip(en))
					
					en.setItemAtSlot(equipped, slotid);
					equipped.set("EQUIPPED", 1);
					equipped.set("EQUIPPED_SLOT", slotid);


					
			}
			
		}
	
	
	}

}
