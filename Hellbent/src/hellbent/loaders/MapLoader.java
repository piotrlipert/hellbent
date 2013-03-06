package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.content.maps.GoblinTowerMap;
import hellbent.content.maps.SlaveMine;
import hellbent.world.Map;

import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.SlickException;

public class MapLoader {
	
	public HashMap<String,Map> maps = new HashMap<String,Map>();
	
	public MapLoader(HellbentGame hg)
	{
			try {
				maps.put("GoblinTower", new GoblinTowerMap(hg));

			} catch (Exception e) {
				e.printStackTrace();
			}
		
			maps.put("SlaveMine", new SlaveMine(hg));

	}
	
	
	public Map getMap(String name)
	{
	 return maps.get(name).clone();		
	}	
	
	

}
