package hellbent.concepts;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import org.newdawn.slick.Color;

import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.world.Map;
import hellbent.concepts.Profession;
import hellbent.content.skills.BluntWeapons;
import hellbent.content.skills.PolearmsWeapons;
import hellbent.content.skills.SlashWeapons;

public class Formulas 
{
public static final int MALE = 1000;
public static final int FEMALE = 1001;

public static final int ALL = 0;
public static final int WEAPONS = 1;
public static final int ARMOR = 2;
public static final int TRINKET = 3;
public static final int AMULETS = 4;
public static final int POTIONS = 5;
public static final int SCROLLS = 6;
public static final int OTHER = 7;
public static final int TOOLS = 8;
public static final int MISSILE = 9;
public static final int MISSILE_WEAPONS = 10;
public static final int UNIDENTIFIED = 11;


public static final int RIGHT_HAND = 10101;
public static final int LEFT_HAND = 10102;
public static final int TORSO = 10103;
public static final int BOOTS = 10104;
public static final int LEGS = 10105;
public static final int HEAD = 10106;
public static final int NECK = 10107;
public static final int TRINKET_1 = 10108;
public static final int TRINKET_2 = 10109;
public static final int TOOL = 10110;
public static final int MISSILES = 10111;
public static final int MISSILE_WEAPON = 10112;
public static final int CLOAK = 10113;
public static final int TAIL = 10114;
public static final int HANDS = 10115;
public static final int HAND = 10116;
// Damage
public static final int PHYSICAL = 10;
public static final int SLASH = 11;
public static final int SMASH = 12;
public static final int PIERCE = 13;
public static final int FIRE = 14;
public static final int COLD = 15;
public static final int SUFFOCATION = 15;
public static final int POISON = 15;



public static final int MAGICAL = 20;
public static final int HELLFIRE = 21;
public static final int FROST = 22;
public static final int THUNDER = 23;
public static final int ARCANE = 24;
public static final int SPIRIT = 25;
public static final int PAIN = 26;
public static final int VENOM = 27;






public static final int WORLDTURNCOUNT = 100;
public static final int CHECKTURNCOUNT = 1;
public static final int LARGEPROMPT = 1;
public static final int MIDPROMPT = 2;
public static final int SMALLPROMPT = 3;
public static final int RESX = 1024;
public static final int RESY = 768;
public static final int MAPRESX = 864;
public static final int MAPRESY = 672;
public static final int COMBAT = 0;


public static Random r = new Random();


public static boolean IsDamagePhysical(int dam)
{
	if (dam - 20 < 0)
	{
		return true;
	}
	return false;
}

	static int calculateToHit(Entity e, Weapon w)
	{	
		int ret = e.get("TO_HIT");
		if (e.getType() == "Player" ||e.getType() == "Hero")
		{
			if (w != null)
			{
				Skill s = getWeaponSkill(w,e);
				if (s != null)
					ret = ret + s.toHitMod(e);
				ret = ret + w.get("TO_HIT_MOD");
			}
			else
			{
				// TODO unarmed
			}
		}	
		return ret;
		
	}
	static int calculateToEvade(Entity e)
	{
		return e.get("EVADE");
		
	}
	public static boolean hit(Entity hitting, Entity hit, Weapon w)
	{
		
		int toHit = calculateToHit(hitting, w);
		int toEvade = calculateToEvade(hit);
		
		for(StateChangeListener i : hit.statelisten)
		{
			toHit = i.modToHit(toHit);
		}
		
		int roll = dice(1,100) + toHit - toEvade;
		
		
		if (roll > 1)
			return true;
		else
			return false;
	}
	
	public static int damage(Entity hitting, Entity hit, Weapon w)
	{
		int ret = 0;
		Damage d = hitting.getDamage(w);

		Skill s = getWeaponSkill(w,hitting);
			if (s != null)
				d = s.modDam(hitting,d);
		
			for (StateChangeListener scl : hit.statelisten)
		{
			scl.onDamage(d);
			
		}
		for (int i : d.dam.keySet())
		{
			if(IsDamagePhysical(i))
			{
				double resistance = hit.get("RESISTANCE"+Integer.toString(i));
				double damage = d.getDamage(i);
				resistance = (100 - resistance)/100;
				damage = damage * resistance;
				damage = damage - hit.get("ARMOR");
				ret = ret + (int) damage;
			}
			else
			{
				double resistance = hit.get("RESISTANCE"+Integer.toString(i));
				double damage = d.getDamage(i);
				resistance = (100 - resistance)/100;
				damage = damage * resistance;
				damage = damage - hit.get("AURA");

				ret = ret + (int) damage;
			}
			
		}
		
		for(Effect e : d.getEffects())
		{
			e.apply(hit);
			for (StateChangeListener scl : hit.statelisten)
			{
				scl.onEffect(e);
				
			}
		}
		
		
		return ret;
	}
	

	void recalculate(Entity e)
	{
		recalculateSpeed(e);
		recalculateHP(e);
		recalculateMP(e);
		recalculateSightRange(e);
		recalculateCapacity(e);
	}

	private void recalculateCapacity(Entity e) {

		e.set("MAX_CAPACITY",1000);
		int weight = 0;
		if(e.getType() == "Player")
		{
			for (Item i : e.inventory)
			{
				weight += i.get("WEIGHT");
			}
		}
		e.set("CAPACITY", weight);
		
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
			int Md = diff(e,"ATR_WILLPOWER");
			int Rd = diff(e,"ATR_ATTUNAMENT");
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
	public static boolean slotCheck(int equipslotid, int slotid) {
		if (equipslotid == slotid)
			return true;
		if (equipslotid == Formulas.HAND && (slotid == Formulas.RIGHT_HAND || slotid== Formulas.LEFT_HAND))
			return true;
		
		if (equipslotid == Formulas.HANDS && (slotid == Formulas.RIGHT_HAND || slotid== Formulas.LEFT_HAND))
			return true;
		
		
		return false;
	}

	public static HashMap<String, Skill> getSkills(Entity entity) 
	{
		HashMap<String, Skill> skills = new HashMap<String, Skill>();
		// TODO Auto-generated method stub
		if(entity.get("BluntWeapons_SKILL") != 0)
		{
			BluntWeapons b = new BluntWeapons();
			b.loadSkill(entity);
			skills.put("BluntWeapons", b);
		}
		
		if(entity.get("PolearmsWeapons_SKILL") != 0)
		{
			PolearmsWeapons b = new PolearmsWeapons();
			b.loadSkill(entity);
			skills.put("PolearmsWeapons", b);
		}
		
		
		if(entity.get("SlashWeapons_SKILL") != 0)
		{
			SlashWeapons b = new SlashWeapons();
			b.loadSkill(entity);
			skills.put("SlashWeapons", b);
		}
		
		
		
		
		
		return skills;
	
	}
	
	
	static Skill getWeaponSkill(Weapon w, Entity e)
	{
		Skill s = null;
		if (w != null)
		{
			String type = w.sGet("WeaponType");
			if (type!=null)
				s = e.getSkill(type);
		}
		
		return s;
		
		
				
				
	}
	
	
}
