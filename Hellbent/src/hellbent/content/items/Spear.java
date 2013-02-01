package hellbent.content.items;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Formulas;
import hellbent.concepts.Weapon;

public class Spear extends Weapon  {

	private Image sprite;



	public Spear() 
	{
		super();
		try {
			setSprite(new Image("resources/graphics/items/spear.bmp",Color.white));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sSet("NAME","G_SPEAR");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.HANDS);
		set("RARITY",1);
		set("DAMAGE_TYPE",Formulas.PIERCE);
		set("D_WALLS",6);
		set("D_COUNT",100);
		set("D_MOD",0);
		
		
	}

	
	
	


	public Spear clone()
	{
		return new Spear();
	}






	public Image getSprite() {
		return sprite;
	}






	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
}
