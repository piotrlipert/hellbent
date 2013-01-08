package hellbent.world;

import java.util.HashMap;


public class World {
	
	public HashMap<String,Map> maps = new HashMap<String,Map>();

	public HashMap<String,Map> getMaps() {
		return maps;
	}

	public void setMaps(HashMap<String,Map> maps) {
		this.maps = maps;
	}
	

	public void addMap(Map i)
	{
		maps.put(i.getName(), i);
	}
	
	public Map getMap(String i)
	{
		return maps.get(i); 
	}
	
}
