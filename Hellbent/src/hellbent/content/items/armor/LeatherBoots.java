package hellbent.content.items.armor;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Armor;
import hellbent.concepts.Formulas;

public class LeatherBoots extends Armor  {




	public LeatherBoots() 
	{
		super();
		
		sSet("NAME","Leather boots");
		sSet("TYPE", "LEATHERBOOTS");
		sSet("ArmorType","LightArmor");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.BOOTS);
		set("RARITY",1);
		
		
	}

	
	
	


	public LeatherBoots clone()
	{
		return new LeatherBoots();
	}



}


	