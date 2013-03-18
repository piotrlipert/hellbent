package hellbent.content.maps;

import hellbent.HellbentGame;
import hellbent.entity.Entity;
import hellbent.world.Map;

public class WorldMap extends Map {

	public WorldMap(HellbentGame hg)  {
		super(100, 100, 1000, 0, hg);
		setName("WorldMap");		
		
	}
	
	public void init()  
	{		
	
		
	}
	
	public WorldMap clone()
	{
		try {
			return new WorldMap(hg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void Enter(int x, int y, Entity entity) {
		super.Enter(x, y, entity);
		
		if (x == 10 && y == 10)
		{
			entity.setMap(hg.ge.w.getMap("SlaveMine"));
			hg.ge.w.getMap("SlaveMine").entities.add(entity);
			this.entities.remove(entity);
			
		}
		
		if (x == 10 && y == 15)
		{
			entity.setMap(hg.ge.w.getMap("GoblinTower"));
			hg.ge.w.getMap("GoblinTower").entities.add(entity);
			this.entities.remove(entity);
			
		}
		
	}

	
	
	
}
