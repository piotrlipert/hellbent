package hellbent.content.maps;

import hellbent.content.items.Axe;
import hellbent.content.items.Scimitar;
import hellbent.content.items.Spear;
import hellbent.content.monsters.GiantRat;
import hellbent.world.Map;

public class GoblinTowerMap extends Map {

	public GoblinTowerMap() throws Exception {
		super(100, 100, false, 0);
		setName("GoblinTower");
		for(int x=0;x<60;x++)
		{
			GiantRat test = new GiantRat();
			test.setPos(30+x, 20);
			test.setMap(this);
			entities.add(test);
		}
		
		init();
		
		
	}
	
	public void init()
	{
		
		for(int x = 0;x<10;x++)
		{
		Scimitar a = new Scimitar();
		
		a.set("X",20);
		a.set("Y",20);
		
		items.add(a);
		}
		for(int x = 0;x<10;x++)
		{
		Axe a = new Axe();
		
		a.set("X",20);
		a.set("Y",20);
		
		items.add(a);
		}
		for(int x = 0;x<10;x++)
		{
		Spear a = new Spear();
		
		a.set("X",20);
		a.set("Y",20);
		
		items.add(a);
		}
	}
	
	public GoblinTowerMap clone()
	{
		try {
			return new GoblinTowerMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
