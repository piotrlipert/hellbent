package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Event;
import hellbent.concepts.Item;
import hellbent.content.events.TestEvent;
import java.util.HashMap;

public class EventLoader 
{
	public HashMap<String,Event> events = new HashMap<String,Event>();

	public EventLoader(HellbentGame hg)
	{
		
		events.put("TestEvent",new TestEvent());

		
		
	}

	public Event getEvent(String name)
	{
		return (events.get(name)).clone();
	}

}
