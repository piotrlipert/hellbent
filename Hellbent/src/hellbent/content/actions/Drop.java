package hellbent.content.actions;

import hellbent.concepts.Action;
import hellbent.concepts.Item;
import hellbent.entity.Entity;
import hellbent.world.Map;

public class Drop extends Action
{

	Entity tmp;
	Item it;
	
	public Drop(Entity e, Item i) 
	{
		super(e);
		it = i;
		this.time = it.get("WEIGHT") * 3;
		name = "DROP";
		
	}

	
	
	
	public void process(Map m) 
	{

	
		
			it.onDrop(en);
			
			en.inventory.remove(it);
			it.set("X", en.getX());
			it.set("Y", en.getY());
			
			
			m.items.add(it);
			
			
			en.addMessage("You drop "+it.getName()+".");
			
		
		
	}
	
	
	
}

