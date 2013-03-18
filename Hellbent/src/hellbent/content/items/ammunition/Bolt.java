package hellbent.content.items.ammunition;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Armor;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;

public class Bolt extends Item  {




	public Bolt() 
	{
		super();
		
		sSet("NAME","Arrows");
		sSet("TYPE", "ARROW");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.HEAD);
		set("RARITY",1);
		
		
	}

	
	
	


	public Bolt clone()
	{
		return new Bolt();
	}



}


	