package hellbent.content.actions;

import hellbent.concepts.Action;
import hellbent.concepts.Background;
import hellbent.concepts.Formulas;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.world.Map;

public class Move extends Action 
{
	public int dir;
	public int x,y;
	public boolean attack = false;
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
		if (attacked!= null && attacked != this.en)
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
	
		
		 if (attack)
		 {
			 System.out.println("ATTACK");
			 Attack a = new Attack(this.en, attacked);
			 a.process(this.en.getMap());
		 }
			
		 else
		 {
			if (x < 0 || x > m.getSizeX() -1  || y < 0 || y > m.getSizeX() -1 )
			{
				System.out.println("Exit");
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
				en.setPos(x, y);
			}
			else
			{
				
					en.addMessage("You stumble.");

			}
			
		
			en.addMessage("You arrived on "+Integer.toString(en.getX()) + " " + Integer.toString(en.getY()));
			
		
	}
	}

}
