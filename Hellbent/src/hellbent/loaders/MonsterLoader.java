package hellbent.loaders;

import hellbent.content.monsters.GiantRat;
import hellbent.entity.Monster;
import hellbent.world.Map;

import java.util.HashMap;

import org.newdawn.slick.SlickException;

public class MonsterLoader {
	public HashMap<String,Monster> monsters = new HashMap<String,Monster>();

	
	public MonsterLoader() throws SlickException
	{
		monsters.put("GiantRat",new GiantRat());
		
		
	}
}
