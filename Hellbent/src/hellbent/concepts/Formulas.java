package hellbent.concepts;

import java.util.Random;

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
	
	int damage(Entity hitting, Entity hit)
	{
		return 1;
	}
	

	void recalculate(Entity e)
	{
		recalculateSpeed(e);
		recalculateHP(e);
		recalculateMP(e);
	}

	void recalculateSpeed(Entity e)
	{
		
	}

	public static void recalculateHP(Entity e)
	{
		if (e.getType() == "Player" || e.getType() == "Hero")
		{
			int Lvld = diff(e,"LEVEL");
			int Vd = diff(e,"VIGOR");
			int Rd = diff(e,"RESOLVE");
			int HPMax = e.get("HP_MAX");
			int HPperLVL=  (e.getProfession()).HPperLevel();
			int HPperV=  (e.getProfession()).HPperV();
			int HPperR=  (e.getProfession()).HPperR();
			int change = 0;
			
			change = change + dice(Vd, HPperV);
			change = change + dice(Rd,HPperR);
			change = change + dice(Lvld,HPperLVL);
			
			
			HPMax = HPMax + change;
			e.set("HP_MAX", HPMax);
			
			
		}
		else 
		{
			int LVLd = diff(e,"LEVEL");
			int HPperLVL = e.get("HPGROWTH");
			int change = dice(LVLd,HPperLVL);
			int HPMax = e.get("HP_MAX");
			HPMax = HPMax + change;
			e.set("HP_MAX", HPMax);
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
	
	void recalculateMP(Entity e)
	{
		if (e.getType() == "Player" || e.getType() == "Hero")
		{
			int Lvld = diff(e,"LEVEL");
			int Md = diff(e,"Mana");
			int Rd = diff(e,"RESOLVE");
			int MPMax = e.get("MP_MAX");
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
			int MPMax = e.get("MP_MAX");
			MPMax = MPMax + change;
			e.set("MP_MAX", MPMax);
		}
		
		
		
		
	}
	
	void recalculateEv(Entity e)
	{
		
	}
	
	void recalculateAr(Entity e)
	{
		
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
	

	
}
