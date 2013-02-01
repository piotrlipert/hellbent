package hellbent.content.items;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Damage;
import hellbent.concepts.Formulas;
import hellbent.concepts.Weapon;
import hellbent.entity.Entity;

public class Scimitar extends Weapon  {

	private Image sprite;



	public Scimitar() 
	{
		super();
		try {
			setSprite(new Image("resources/graphics/items/sword.bmp",Color.white));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sSet("NAME","G_SCIMITAR");

		set("WEIGHT",50);
		set("EQUIP_SLOT",Formulas.HAND);
		set("RARITY",1);
		set("DAMAGE_TYPE",Formulas.SLASH);
		set("D_WALLS",6);
		set("D_COUNT",1);
		set("D_MOD",0);

		
	}

	
	
	


	public Scimitar clone()
	{
		return new Scimitar();
	}






	
	
	public Image getSprite() {
		return sprite;
	}






	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
}
