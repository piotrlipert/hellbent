package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.content.maps.GoblinTowerMap;
import hellbent.content.maps.SlaveMine;
import hellbent.content.maps.WorldMap;
import hellbent.world.Map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.SlickException;

public class MapLoader {
	
	public HashMap<String,Map> maps = new HashMap<String,Map>();
	
	public MapLoader(HellbentGame hg)
	{
			
		
		
			maps.put("GoblinTower", new GoblinTowerMap(hg));
			maps.put("SlaveMine", new SlaveMine(hg));
			maps.put("WorldMap", new WorldMap(hg));

	}
	
	
	public Map getMap(String name)
	{
	 return maps.get(name).clone();		
	}


	public Vector<Map> getMaps() {
		
		Vector<Map> mps = new Vector<Map>();
		for(String i : maps.keySet())
		{
			mps.add(maps.get(i));
			
		}
		return mps;
	}	
	
	

}
