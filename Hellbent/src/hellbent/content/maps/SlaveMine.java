package hellbent.content.maps;

import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Item;
import hellbent.content.items.armor.LeatherBoots;
import hellbent.content.monsters.animals.GiantRat;
import hellbent.content.monsters.dwarves.DwarfGuard;
import hellbent.content.monsters.humans.HumanArcherGuard;
import hellbent.content.monsters.humans.HumanGuard;
import hellbent.entity.Entity;
import hellbent.util.Generation;
import hellbent.world.Map;

public class SlaveMine extends Map {

	@Override
	public void Enter(int x, int y, Entity entity) {
		super.Enter(x, y, entity);
		
		if(x == 10 && y == 10)
		{
		entity.setMap(hg.ge.w.getMap("WorldMap"));
		hg.ge.w.getMap("WorldMap").entities.add(entity);
		this.entities.remove(entity);
		}
	}

	public SlaveMine(HellbentGame hg)  {
		super(100, 100, 200, 0, hg);
		setName("SlaveMine");

		for(int x=0;x<5;x++)
		{
			HumanArcherGuard test = null;
			try {
				test = new HumanArcherGuard(hg);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.setPos(9+x, 5+x);
			test.setMap(this);
			entities.add(test);
		}
		
		for(int x=0;x<5;x++)
		{
			DwarfGuard test = null;
			try {
				test = new DwarfGuard(hg);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.setPos(10+x, 5+x);
			test.setMap(this);
			entities.add(test);
		}
		
		for(int x=0;x<5;x++)
		{
			HumanGuard test = null;
			try {
				test = new HumanGuard(hg);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.setPos(11+x, 5+x);
			test.setMap(this);
			entities.add(test);
		}
		
		
		

		
		init();
		
		
	}
	
	public void init()  
	{
		
		Generation.GenerateCaves(this, 0);
		
		for (String i : hg.itl.items.keySet())
		{
			Item k = hg.itl.items.get(i);
			k.set("X", 10);
			k.set("Y", 10);
			
			this.items.add(k);
			
		}
		
	}
	
	public SlaveMine clone()
	{
		try {
			return new SlaveMine(hg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
