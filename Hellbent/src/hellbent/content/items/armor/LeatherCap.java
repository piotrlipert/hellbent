package hellbent.content.items.armor;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Armor;
import hellbent.concepts.Formulas;

public class LeatherCap extends Armor  {




	public LeatherCap() 
	{
		super();
		
		sSet("NAME","Leather boots");
		sSet("TYPE", "LEATHERCAP");
		sSet("ArmorType","LightArmor");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.HEAD);
		set("RARITY",1);
		
		
	}

	
	
	


	public LeatherCap clone()
	{
		return new LeatherCap();
	}



}


	