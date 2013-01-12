package hellbent.concepts;

import java.util.Random;
import java.util.Vector;

import org.newdawn.slick.Color;

import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.world.Map;
import hellbent.concepts.Profession;

public class Formulas 
{
public static final int MALE = 1000;
public static final int FEMALE = 1001;

public static final int RIGHT_HAND = 10101;
public static final int LEFT_HAND = 10102;
public static final int TORSO = 10103;
public static final int BOOTS = 10104;
public static final int LEGS = 10105;
public static final int HEAD = 10106;
public static final int NECK = 10107;
public static final int RING_1 = 10108;
public static final int RING_2 = 10109;
public static final int TOOL = 10110;
public static final int MISSILE = 10111;
public static final int MISSILE_WEAPON = 10112;
public static final int CLOAK = 10113;
public static final int TAIL = 10114;
public static final int HANDS = 10115;
public static final int HAND = 10116;
// Damage
public static final int PHYSICAL = 1;


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
	public static boolean canSee(Entity tmp, Entity e) {
		return true;
	}
	public static boolean canSee(Entity tmp, Item e) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
}
