package hellbent.concepts;

import hellbent.entity.Entity;

public class Effect 
{
	private String name;
	private int duration;
	private int frequency;
	private boolean toDelete;


	public int getFreqHELP() {
		return freqHELP;
	}

	public void setFreqHELP(int freqHELP) {
		this.freqHELP = freqHELP;
	}

	private int freqHELP;
	
	
	public void apply(Entity e)
	{
		e.effects.add(this);
		
	}
	
	public void on(Entity e)
	{
		
	}
	public void process(Entity e)
	{
		
	}
	
	public void off(Entity e)
	{
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setToDelete(boolean b) {
		toDelete = b;
	}
	public boolean getToDelete()
	{
		return toDelete;
	}
	
	
}
