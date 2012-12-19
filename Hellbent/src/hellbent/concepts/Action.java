package hellbent.concepts;

import hellbent.entity.Entity;
import hellbent.world.Map;

public abstract class Action {
	
	public int time;
	public Entity en;
	private int processed = 0;

	public Action(Entity e)
	{
    this.en = e;		
	}
	
	int getTime()
	{
		return time;
	}

	public abstract void process(Map m);

	public int getProcessed() {
		return processed;
	}

	public void setProcessed(int processed) {
		this.processed = processed;
	}
	

}
