package hellbent.util;
import hellbent.concepts.Action;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import hellbent.world.*;
public class GameEngine {
	
	private static final int ENERGYQUANT = 50;

	Vector<Action> ActionQ = new Vector<Action>(); 

	public int turncount = 0;
	private World w;
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
		System.out.println("Pozycja gracza to :");
		System.out.println(Integer.toString(pl.getX())+","+Integer.toString(pl.getY()));
		
		Vector<Action> ActionQHelp = new Vector<Action>();
		pl.resetMessage();
		turncount++;
		if (turncount % 100 == 0)
		{
			
		}
		Player tmp = getPlayer();
		Map current = tmp.getMap();
		
	
		
		ActionQ.add(pl.getAction());
		
	while (pl.getAction() != null)
	{

			for (Entity i : current.entities)
			{
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

			a.process(current);
			a.setProcessed(1);
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

		ActionQ =  (Vector<Action>) ActionQHelp.clone();
		ActionQHelp.clear();

		

	}
		
		
		// Do player action
		
		// Purge processed actions
		
		
	}
	
}
