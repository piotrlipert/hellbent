package hellbent.concepts;

import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.util.Utilities;

import java.util.HashMap;

import org.newdawn.slick.Image;


public class Item extends Attributable

	{
	
	
	
	public boolean CANUSE;
	public boolean CANEQUIP;
	
	
	public Item clone()
	{
		return new Item();
	}

	public String getName() {
		return sGet("NAME");
	}
	

	

	public int getX() {
		return get("X");
	}

	public int getY() {
		 return get("Y");
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public String save()
	{
	String ret = "<ITEM>\n";
	ret = ret + "<TYPE>"+this.sGet("TYPE")+"</TYPE>";
	ret = ret + saveAttributes();
	return ret +"</ITEM>\n";	
	}
	
	

	public void load(String istring)
	{
		String atr = Utilities.substring("ATR", istring);
		String satr = Utilities.substring("sATR", istring);

		String[] aS = atr.split("[\r\n]+");
		String[] SaS = satr.split("[\r\n]+");

		for (String i : aS)
		{
			if (i.length() > 3)
			 this.set(i.split("::")[0],Integer.parseInt(i.split("::")[1]));
		}
			
		for (String i : SaS)
		{
			if (i.length() > 3)
			 this.sSet(i.split("::")[0],i.split("::")[1]);
		}

	}
	
	public boolean onEquip(Entity e)
	{
		
		return true;
	}
	
	public boolean onRemove(Entity e)
	{
		return true;

		
	}
	
	public void onPickup(Entity e)
	{
		
		
	}
	
	public void onDrop(Entity e)
	{
		
		
	}
	public void onUse(Entity e)
	{
		
		
	}

	
}


