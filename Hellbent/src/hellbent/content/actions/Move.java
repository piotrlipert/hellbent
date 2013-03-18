package hellbent.content.actions;

import java.util.Vector;

import org.newdawn.slick.SlickException;

import hellbent.concepts.Action;
import hellbent.concepts.Background;
import hellbent.concepts.Event;
import hellbent.concepts.Feature;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.concepts.Trap;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.util.Utilities;
import hellbent.world.Map;

public class Move extends Action 
{
	public int dir;
	public int x,y;
	public boolean attack = false;
	public boolean moveonly = false;
	public Entity attacked = null;
	public Map current; 
	public Move(Entity e, int dir) {
		super(e);
		int timetobecalculated = 0;
		this.dir = dir;

		 x = en.getX();
		 y = en.getY();
	
		int[] ncoord = Formulas.dir(x, y, dir);
		x = ncoord[0];
		y = ncoord[1];
	
		Map m = en.getMap();
		attacked = m.entityAtCoord(x, y);
		if (attacked != null && attacked != this.en)
				attack = true;
		else
			attack = false;
		
		if (attack)
		{
		timetobecalculated = 2000 - e.get("Speed");		
		}
		else
		{
			
		timetobecalculated = 1000 - e.get("Speed");		

		}
		this.time = timetobecalculated;

		}
	
	public void process(Map m)
	{
	
		

		 if (attack && !moveonly)
		 {
			 Attack a = new Attack(this.en, attacked);
			 a.process(this.en.getMap());
		 }
			
		 else
		 {
			
			
			if (x < 0 || x > m.getSizeX() -1  || y < 0 || y > m.getSizeX() -1 )
			{
				m.Exit(x,y,en);
				return;
			}
			if (Background.IsWalkable(m.background[x][y]))	
			{
			attacked = m.entityAtCoord(x, y);
			if (attacked!= null && attacked != this.en)
			{
					en.addMessage("You bump into someone");	
			}
			else
			{
				Feature f = m.getFeatureAt(x,y);
				if (f == null || f.get("WALKABLE") == 1)
				{
					en.setPos(x, y);
					if (f!=null)
						f.perform(en);
				}
				

				if (en.getType().equals("Player"))
				{
					for(Event i : m.events)
					{
						if (i.get("X") == x && i.get("Y") == y)
							i.perform(en);
					}
					
					for(Trap i : m.traps)
					{
						if (i.get("X") == x && i.get("Y") == y)
							i.perform(en);
					}
					
					
					
					
					if(en.getType().equals("Player"))
						m.discover(en);

					
					Vector<Item> items = Utilities.getItemsAtCoord(m, x, y);
					
					if (items.size() > 1)
					{
						en.addMessage("There are some items lying here.");

					}
					
					if (items.size() == 1)
					{
						en.addMessage("There is a "+items.get(0).sGet("NAME")+ "lying here.");
					}
					
				}
				
			}
			
			}
			else
			{
				
					en.addMessage("You stumble.");

			}
			
		
			en.addMessage("You arrived on "+Integer.toString(en.getX()) + " " + Integer.toString(en.getY()));
			
		
	}
	}

	
	
}
