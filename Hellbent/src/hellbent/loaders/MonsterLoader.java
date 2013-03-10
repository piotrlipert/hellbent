package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.content.monsters.animals.GiantRat;
import hellbent.content.monsters.dwarves.DwarfGuard;
import hellbent.content.monsters.humans.HumanArcherGuard;
import hellbent.content.monsters.humans.HumanGuard;
import hellbent.content.monsters.humans.HumanGuardLeader;
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
		
		monsters.put("HUMAN_ARCHER_GUARD",new HumanArcherGuard(hg));
		monsters.put("HUMAN_GUARD",new HumanGuard(hg));
		monsters.put("DWARVEN_GUARD",new DwarfGuard(hg));
		monsters.put("HUMAN_KNIGHT",new HumanGuardLeader(hg));

		
	}

public Entity getMonster(String type)
{
	return (monsters.get(type)).clone();
}

}
