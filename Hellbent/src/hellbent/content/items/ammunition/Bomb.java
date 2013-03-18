package hellbent.content.items.ammunition;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Armor;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;

public class Bomb extends Item  {




	public Bomb() 
	{
		super();
		
		sSet("NAME","Bomb");
		sSet("TYPE", "BOMB");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.HEAD);
		set("RARITY",1);
		
		
	}

	
	
	


	public Bomb clone()
	{
		return new Bomb();
	}



}


	