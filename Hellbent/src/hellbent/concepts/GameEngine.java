package hellbent.concepts;
import hellbent.content.actions.Wait;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import hellbent.world.*;
public class GameEngine {
	
	private static final int ENERGYQUANT = 50;

	Vector<Action> ActionQ = new Vector<Action>(); 

	public int turncount = 0;
	public World w = new World();
	public Player pl;


	public World getWorld() {
		return w;
	}

	public void setWorld(World w) {
		this.w = w;
	}

	public Player getPlayer() {
		return pl;
	}

	public void setPlayer(Player pl) {
		this.pl = pl;
	}
	
	public void moveEntity(Entity k, int dir)
	{
		
	}
	

	@SuppressWarnings("unchecked")
	public void TURN()
	{
		
		Vector<Action> ActionQHelp = new Vector<Action>();
		pl.resetMessage();
		turncount++;
		if (turncount % 100 == 0)
		{
			
		}
		Player tmp = getPlayer();
		Map current = tmp.getMap();
		
	
		
		ActionQ.add(pl.getAction());
		if (pl.getAction().isInstant())
		{
			int actiontime = pl.getAction().time;
			pl.getAction().process(current);
			pl.setAction(new Wait(actiontime, pl));
		}
		
	while (pl.getAction() != null)
	{

			for (Entity i : current.entities)
			{
				for (Effect ef : i.effects)
				{
					
					int dur = ef.getDuration();
					int freq = ef.getFrequency();
					int freqH = ef.getFreqHELP();

					freqH = freqH - ENERGYQUANT;
					dur = dur - ENERGYQUANT;

					if (dur > 0)
					{
						if (freqH <= 0)
					{
						freqH = freq;
						ef.process(i);
						
					}
					
					}
					else
					{
						ef.setToDelete(true);
					}
					
				}
			
				
				Iterator<Effect> it = i.effects.iterator();
				
				while(it.hasNext())
				{
					Effect ef = it.next();
					
					if (ef.getToDelete() == true)
							{
							it.remove();
							}
				}
				
				if (i.isAwake() && i.getAction() == null && i != pl)
				{
					Action n = i.AI(current);
					i.setAction(n);
					ActionQ.add(n);
				}
			
			
			}
			
		for (Action a : ActionQ)
		{
			
			if (a.time < 0)
			{	
			
			a.setProcessed(1);
			a.process(current);
			a.en.setAction(null);
			
				if (a.en == this.pl)
				{
				break;
				}
			}
			else
			{
			a.time = a.time - ENERGYQUANT;
			}
		}
		for (Action b : ActionQ)
		{
			if (b.getProcessed() == 0)
			{
				ActionQHelp.add(b);
				
			}
			
		}

		ActionQ = (Vector<Action>) ActionQHelp.clone();
		ActionQHelp.clear();

		

	}
		
		
		// Do player action
		
		// Purge processed actions
		
		
	}
	
}
