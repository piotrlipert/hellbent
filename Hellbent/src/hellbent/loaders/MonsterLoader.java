package hellbent.loaders;

import hellbent.content.monsters.GiantRat;
import hellbent.entity.Entity;
import hellbent.entity.Monster;

import java.util.HashMap;

import org.newdawn.slick.SlickException;

public class MonsterLoader {
	public HashMap<String,Monster> monsters = new HashMap<String,Monster>();

	
	public MonsterLoader() throws SlickException
	{
		monsters.put("GIANT_RAT",new GiantRat());
		
		
	}

public Entity getMonster(String type)
{
	System.out.println(type);
	return (monsters.get(type)).clone();
}

}
