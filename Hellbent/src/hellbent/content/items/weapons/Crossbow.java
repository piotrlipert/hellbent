package hellbent.content.items.weapons;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Formulas;
import hellbent.concepts.Weapon;

public class Crossbow extends Weapon  {




	public Crossbow() 
	{
		super();
		
		sSet("NAME","hand axe");
		sSet("TYPE", "CROSSBOW");
		sSet("WeaponType","SlashWeapon");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.HAND);
		set("RARITY",1);
		set("DAMAGE_TYPE",Formulas.SLASH);
		set("D_WALLS",6);
		set("D_COUNT",1);
		set("D_MOD",0);
		
		
	}

	
	
	


	public Crossbow clone()
	{
		return new Crossbow();
	}






}
