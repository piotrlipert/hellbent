package hellbent.content.items.armor;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Armor;
import hellbent.concepts.Formulas;

public class LeatherVest extends Armor  {




	public LeatherVest() 
	{
		super();
		
		sSet("NAME","Leather boots");
		sSet("TYPE", "LEATHERVEST");
		sSet("ArmorType","LightArmor");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.TORSO);
		set("RARITY",1);
		
		
	}

	
	
	


	public LeatherVest clone()
	{
		return new LeatherVest();
	}



}


	