package hellbent.content.monsters.humans;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;
import hellbent.content.monsters.GenericMonster;

public class HumanArcherGuard extends GenericMonster {
	
	public HumanArcherGuard(HellbentGame h) throws SlickException
	{
		super(h);
		this.setAwake(true);
		this.setName("giant rat");
		this.setType("HUMAN_ARCHER_GUARD");
		this.set("SEX",Formulas.MALE);
		this.set("Speed",0);
		this.set("HPGROWTH",10);
		this.set("LEVEL",1);
		this.set("DAMAGE",5);
		this.set("SIGHTRANGE",5);
		Formulas.recalculateHP(this);
		this.set("CURR_HP", this.get("HP_MAX"));
		

 
	}
	
	/*
	public Action AI(Map m)
	{
	if (this.getMap().entityAtCoord(this.getX()+1, this.getY())!= null)
		return new Move(this, 6);
	Random R = new Random();

	return new Move(this, R.nextInt(8)+1);
	}
*/
	public HumanArcherGuard clone()
	{
		try {
			return new HumanArcherGuard(hg);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
