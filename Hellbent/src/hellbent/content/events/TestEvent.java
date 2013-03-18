package hellbent.content.events;

import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Event;
import hellbent.concepts.Formulas;
import hellbent.entity.Entity;
import hellbent.states.GameplayState;
import hellbent.util.OkPrompt;

public class TestEvent extends Event 
{
	private HellbentGame hg = null;
	public TestEvent()
	{
	playerOnly = true;
	set("COUNT",1);
	sSet("TYPE","TestEvent");
	set("X",20);
	set("Y",20);
	}
	
	
	public void perform(Entity trigger) 
	{
		hg = trigger.hg;
		trigger.addMessage("EVENT ODPALONY!");
		if (trigger.getType().equals( "Player"))
		{
				OkPrompt test = null;
				try {
					test = new OkPrompt(Formulas.MIDPROMPT,hg);
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GameplayState gs = ((GameplayState) hg.getState(HellbentGame.GAMEPLAYSTATE));

				
				gs.setPrompt(test);

			
		}
		
	}
	
	public TestEvent clone()
	{
		return new TestEvent();
	}


	public HellbentGame getHg() {
		return hg;
	}


	public void setHg(HellbentGame hg) {
		this.hg = hg;
	}
	
}
