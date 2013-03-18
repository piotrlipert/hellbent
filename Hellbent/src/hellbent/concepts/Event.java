package hellbent.concepts;

import org.newdawn.slick.SlickException;

import hellbent.entity.Entity;

public class Event extends Attributable
{
	
	public boolean playerOnly = false;
	public Event()
	{
		sSet("TYPE","GenericEvent");
	}
	
	public Event clone()
	{
		return new Event();
	}

	public void perform(Entity trigger)
	{
		
		
	}

	public String save() 
	{
		
		String ret = "<EVENT>";
		ret = ret + "<TYPE>" + sGet("TYPE") + "</TYPE>\n";
		ret = ret + saveAttributes();
		
		
		
		return ret + "</EVENT>";
	}

	public void load(String i)
	{
		loadAttributes(i);
	}

}
