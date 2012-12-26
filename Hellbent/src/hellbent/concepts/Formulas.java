package hellbent.concepts;

import java.util.Random;
import java.util.Vector;

import hellbent.entity.Entity;
import hellbent.concepts.Profession;

public class Formulas 
{
public static final int MALE = 0;
public static Random r = new Random();


	static int calculateToHit(Entity e)
	{
		return e.get("TO_HIT");
		
	}
	static int calculateToEvade(Entity e)
	{
		return e.get("EVADE");
		
	}
	public static boolean hit(Entity hitting, Entity hit)
	{
		
		int toHit = calculateToHit(hitting);
		int toEvade = calculateToEvade(hit);
		
		int roll = dice(1,100) + toHit - toEvade;
		
		
		if (roll > 50)
			return true;
		else
			return false;
	}
	
	public static int damage(Entity hitting, Entity hit)
	{
		return 1;
	}
	

	void recalculate(Entity e)
	{
		recalculateSpeed(e);
		recalculateHP(e);
		recalculateMP(e);
		recalculateSightRange(e);
	}

	void recalculateSpeed(Entity e)
	{
		
	}


	public static void recalculateSightRange(Entity e)
	{
	e.set("SIGHT",5);
	if (e.getType() == "Player")
		e.getMap().discover(e);
		
	
	}
	
	public static void recalculateHP(Entity e)
	{
		int HPMax = 0;
		if (e.getType() == "Player" || e.getType() == "Hero")
		{
			int Lvld = diff(e,"LEVEL");
			int Vd = diff(e,"VIGOR");
			int Rd = diff(e,"RESOLVE");
			HPMax = e.get("HP_MAX");
			int HPperLVL=  (e.getProfession()).HPperLevel();
			int HPperV=  (e.getProfession()).HPperV();
			int HPperR=  (e.getProfession()).HPperR();
			int change = 0;
			
			change = change + dice(Vd, HPperV);
			change = change + dice(Rd,HPperR);
			change = change + dice(Lvld,HPperLVL);
			
			
			HPMax = HPMax + change;
			e.set("HPMax",HPMax);
			
		}
		else 
		{
			int LVLd = diff(e,"LEVEL");
			int HPperLVL = e.get("HPGROWTH");
			int change = dice(LVLd,HPperLVL);
			HPMax = e.get("HP_MAX");
			HPMax = HPMax + change;
			e.set("HP_MAX",HPMax);

		}
		
		

		
	}
	
	public static int[] dir(int x, int y, int num)
	{
		int[] ret = new int[2];
		
			switch(num)
			{
			case 1:
				x = x -1;
				y = y + 1;
				break;
			case 2:
				y = y + 1;
				break;	
			case 3:
				x = x + 1;
				y = y + 1;
				break;
			case 4:
				x = x - 1;
				break;
			case 5:
				
				break;
			case 6:
				x = x + 1;
				break;
			case 7:
				x = x -1;
				y = y - 1;
				break;
			case 8:
				y = y - 1;
				break;
			case 9:
				x = x + 1;
				y = y - 1;
				break;
			}
			ret[0] = x;
			ret[1] = y;
			
		return ret;
	}
	
	
	
	Vector<Entity> getCreaturesInSight(Entity e)
	{
		Vector<Entity> creatures = new Vector<Entity>();
		
		
		return creatures;
		
	}
	void recalculateMP(Entity e)
	{
		int MPMax;
		if (e.getType() == "Player" || e.getType() == "Hero")
		{
			int Lvld = diff(e,"LEVEL");
			int Md = diff(e,"Mana");
			int Rd = diff(e,"RESOLVE");
			 MPMax = e.get("MP_MAX");
			int MPperLVL=  (e.getProfession()).MPperLevel();
			int MPperM=  (e.getProfession()).MPperM();
			int MPperR=  (e.getProfession()).MPperR();
			int change = 0;
			
			change = change + dice(Md, MPperM);
			change = change + dice(Rd,MPperR);
			change = change + dice(Lvld,MPperLVL);
			
			
			MPMax = MPMax + change;
			e.set("MP_MAX", MPMax);
			
			
		}
		else 
		{
			int LVLd = diff(e,"LEVEL");
			int MPperLVL = e.get("MPGROWTH");
			int change = dice(LVLd,MPperLVL);
			 MPMax = e.get("MP_MAX");
			MPMax = MPMax + change;
			e.set("MP_MAX", MPMax);
		}
		
		
		
	}
	
	int recalculateEv(Entity e)
	{
		return 0;
		
	}
	
	int recalculateAr(Entity e)
	{
		return 0;
		
	}
	

	static int diff(Entity e, String attr)
	{
		return (e.get(attr)-e.get(attr+"_OLD"));
	}

	public static int dice(int many, int walls)
	{
		int sum = 0;
		for(int x=0;x<many;x++)
			sum = sum + r.nextInt(walls)+1;
		
		return sum;
		
	}
	public static String missReason(Entity victim) {
		return null;
	}
	public static int EXPValue(Entity victim) {
		return 0;
	}
	public static int distance(int xx, int yy, int x, int y) {
		double xd = (double) x;
		double yd = (double) y;
		double xxd = (double) xx;
		double yyd = (double) yy;

		return (int) Math.sqrt(Math.pow(xxd-xd,2) + Math.pow(yyd-yd, 2));
	}
	

	
}
