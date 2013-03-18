package hellbent.concepts;

import hellbent.util.Utilities;

import java.util.HashMap;

public class Attributable {
	
	public HashMap<String, Integer> data = new HashMap<String, Integer>();
	public HashMap<String, String> sdata = new HashMap<String, String>();


	
	public String getType() {
		return sGet("TYPE");
	}
	public void setType(String type) {
		sSet("TYPE",type);
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
	

	
	protected String saveAttributes() 
	{
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
	
	



public void add(String name, int value)
{
	this.set(name, this.get(name)+value);
}

public void sub(String name, int value)
{
	this.set(name, this.get(name)-value);

}
	
	protected void loadAttributes(String savestr) 
	{
	String atr = Utilities.substring("ATR", savestr);
	String satr = Utilities.substring("sATR", savestr);

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

}
