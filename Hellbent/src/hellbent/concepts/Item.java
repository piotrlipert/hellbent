package hellbent.concepts;

import java.util.HashMap;

import org.newdawn.slick.Image;


public class Item

	{
	public HashMap<String, Integer> data = new HashMap<String, Integer>();
	public HashMap<String, String> sdata = new HashMap<String, String>();
	
	public static int WEAPON = 1;
	
	
	
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
		// TODO Auto-generated method stub
		return get("X");
	}

	public int getY() {
		// TODO Auto-generated method stub
		 return get("X");
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public String save()
	{
	String ret = "<ITEM>";
	ret = ret + saveAttributes();
	return ret +"</ITEM>";	
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
		
	}
	
	}


