package hellbent.concepts;

import hellbent.entity.Entity;
import hellbent.world.Map;

public abstract class Action {
	
	public int time;
	public Entity en;
	private int processed = 0;
	private boolean instant = false;
	private boolean animated = false;
	public String name = "ACTION";

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

	public boolean isInstant() {
		return instant;
	}

	public void setInstant(boolean instant) {
		this.instant = instant;
	}

	public boolean isAnimated() {
		return animated;
	}

	public void setAnimated(boolean animated) {
		this.animated = animated;
	}
	

}
