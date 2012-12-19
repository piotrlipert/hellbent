package hellbent.loaders;

import hellbent.content.maps.GoblinTowerMap;
import hellbent.world.Map;

import java.util.HashMap;

import org.newdawn.slick.SlickException;

public class MapLoader {
	
	public HashMap<String,Map> maps = new HashMap<String,Map>();
	
	public MapLoader() throws SlickException
	{
		maps.put("GoblinTower", new GoblinTowerMap());
		
	}
	

}
