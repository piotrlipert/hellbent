package hellbent.content.monsters;

import hellbent.HellbentGame;
import hellbent.concepts.Action;
import hellbent.concepts.Formulas;
import hellbent.content.actions.Move;
import hellbent.entity.Entity;
import hellbent.entity.Monster;
import hellbent.util.Utilities;
import hellbent.world.Map;

import java.util.Random;
import java.util.Vector;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GenericMonster extends Monster
{
	
	GenericMonster(HellbentGame h) {
		super(h);
		set("AFFINITY",Affinity.HOSTILE);
		set("SIGHT",10);

 
	}
	
	public Action AI(Map m)
	{
		int x = this.getX();
		int y = this.getY();
		Vector<Entity> Seen = new Vector<Entity>();
		Seen = Utilities.getVisibleEntities(this);
		
		for(Entity e : Seen)
		{

			if (e.getType() == "Player")
			{

				double distance = Utilities.Ddistance(e.getX(), e.getY(), x, y);

				for(int i=y-1;i<y+2;i++)
				{
					for(int j=x-1;j<x+2;j++)
					{

						if(Utilities.Ddistance(e.getX(), e.getY(), j, i) < distance && m.entityAtCoord(j, i) == null)
						{
							int dir = Utilities.newlocToDir(this.getX(), this.getY(), j, i);
							Move mo = new Move(this,dir);
							mo.moveonly = true;
							return  mo;
							
						}
					}
				}

			}
			
			
		}

		
		
		Move randomMove = new Move(this, Formulas.r.nextInt(8)+1);
		randomMove.moveonly = true;
		return randomMove;
		
		
	}

	
		
	

}
