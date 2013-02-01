package hellbent.concepts;

import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.util.Utilities;

import java.util.HashMap;

import org.newdawn.slick.Image;


public class Item

	{
	public HashMap<String, Integer> data = new HashMap<String, Integer>();
	public HashMap<String, String> sdata = new HashMap<String, String>();
	
	
	public boolean CANUSE;
	public boolean CANEQUIP;
	
	
	public Item clone()
	{
		return new Item();
	}

	public String getName() {
		return sGet("NAME");
	}
	

	public void sSet(String name, String value) 
	{
	sdata.put(name,value);
	}
	public String sGet(String name)
	{

		if (sdata.get(name) == null)
				return "";
		else
			return sdata.get(name);
	
	}
	
	public void set(String name, int value) 
	{
	if (name.indexOf("_OLD") == -1)
	data.put(name+"_OLD",this.get(name));
	data.put(name,value);
	}
	public int get(String name)
	{
		if (data.get(name) == null)
				return 0;
		else
			return data.get(name);
	
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
	ret = ret + "<TYPE>"+this.sGet("NAME")+"</TYPE>";
	ret = ret + saveAttributes();
	return ret +"</ITEM>\n";	
	}
	
	private String saveAttributes() {
		String ret = "<ATR>\n";
		for(String i : this.data.keySet())
			{
			ret = ret + i + "::" + Integer.toString(this.get(i)) + "\n";
			}
			ret = ret + "</ATR>\n";

			ret = ret + "<sATR>\n";
			
			for(String i : this.sdata.keySet())
			{
			ret = ret + i + "::" + this.sGet(i) + "\n";
			}
			
			
			return ret+"</sATR>\n";
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


