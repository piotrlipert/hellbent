package hellbent.content.actions;

import hellbent.concepts.Action;
import hellbent.entity.Entity;
import hellbent.world.Map;

public class Wait extends Action {

	public Wait(int time, Entity e) 
	{
		super(e);
		this.time = time;
	}

	
	public void process(Map m)
	{
	return;	
	}


}
