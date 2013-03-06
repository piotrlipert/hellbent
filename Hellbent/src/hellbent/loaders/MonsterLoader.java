package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.content.monsters.GiantRat;
import hellbent.content.npc.GoblinMiner;
import hellbent.entity.Entity;
import hellbent.entity.Monster;

import java.util.HashMap;

import org.newdawn.slick.SlickException;

public class MonsterLoader {
	public HashMap<String,Monster> monsters = new HashMap<String,Monster>();

	
	public MonsterLoader(HellbentGame hg) throws SlickException
	{
		monsters.put("GIANT_RAT",new GiantRat(hg));
		monsters.put("GOBLIN_MINER",new GoblinMiner(hg));

		
	}

public Entity getMonster(String type)
{
	return (monsters.get(type)).clone();
}

}
