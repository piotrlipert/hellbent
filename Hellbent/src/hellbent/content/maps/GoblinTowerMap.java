package hellbent.content.maps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

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
