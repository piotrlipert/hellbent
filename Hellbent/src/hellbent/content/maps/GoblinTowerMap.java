package hellbent.content.maps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.newdawn.slick.SlickException;

import hellbent.concepts.Background;
import hellbent.content.monsters.GiantRat;
import hellbent.world.Map;

public class GoblinTowerMap extends Map {

	public GoblinTowerMap() throws Exception {
		super(100, 100, false, 0);
		
		for(int x=0;x<60;x++)
		{
			GiantRat test = new GiantRat();
			test.setPos(30+x, 20);
			test.setMap(this);
			entities.add(test);
		}
		
		File a = new File("C:\\test.txt");
		Scanner b = new Scanner(a);
	    String text = b.useDelimiter("\\A").next();
	    b.close();
	    
	    loadBackground(text);
		

	    String zz = this.saveString("");
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\test.txt"));
		out.write(zz);
		out.close();
		
	}

}
