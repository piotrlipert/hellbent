package hellbent.loaders;

import hellbent.content.maps.GoblinTowerMap;
import hellbent.world.Map;

import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.SlickException;

public class MapLoader {
	
	public HashMap<String,Map> maps = new HashMap<String,Map>();
	
	public MapLoader()
	{
			try {
				maps.put("GoblinTower", new GoblinTowerMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
	public Map getMap(String name)
	{
	 return maps.get(name).clone();		
	}	
	
	

}
