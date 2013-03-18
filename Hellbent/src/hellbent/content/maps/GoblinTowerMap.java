package hellbent.content.maps;

import java.util.Random;

import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Background;
import hellbent.content.events.TestEvent;
import hellbent.content.features.forest.LeaveTree;
import hellbent.content.items.armor.LeatherBoots;
import hellbent.content.monsters.animals.GiantRat;
import hellbent.content.npc.GoblinMiner;
import hellbent.world.Map;

public class GoblinTowerMap extends Map {

	public GoblinTowerMap(HellbentGame hg)  {
		super(100, 100, Background.GRASS, 0, hg);
		setName("GoblinTower");
		events.add(new TestEvent());
		for(int x=0;x<30;x++)
		{
			GiantRat test = new GiantRat(hg);
			test.setPos(30+x, 20);
			test.setMap(this);
			entities.add(test);
		}
		
		init();
		
		
	}
	
	public void init() 
	{
		
		
		
		
		GoblinMiner test = new GoblinMiner(hg);
		test.setPos(40, 40);
		test.setMap(this);
		entities.add(test);
		
		Random r = new Random();
		
		
		LeatherBoots b = new LeatherBoots();
		b.set("X",21);
		b.set("Y",21);
		items.add(b);
		for(int i=0;i<100;i++)
		{
		LeaveTree o = new LeaveTree();
		o.set("X",r.nextInt(90));
		o.set("Y",r.nextInt(90));
		o.set("WALKABLE",0);
		
		addFeature(o);
		}
		
	}
	
	public GoblinTowerMap clone()
	{
		try {
			return new GoblinTowerMap(hg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
