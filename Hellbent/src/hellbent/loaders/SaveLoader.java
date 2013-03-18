package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.entity.Player;
import hellbent.util.Utilities;
import hellbent.world.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SaveLoader {
	HellbentGame h;
	public SaveLoader(HellbentGame hg)
	{
		h = hg;
	}
	String getFileAsString(String path) throws FileNotFoundException
	{
		File a = new File(path);
		Scanner b = new Scanner(a);
	    String text = b.useDelimiter("\\A").next();
	    b.close();
	    return text;
	}
	
	
	public void loadGame(Path p) throws FileNotFoundException
	{
		
		String savestr = getFileAsString(p.toString());
		
		loadPlayer(savestr);
		loadMaps(savestr);
		loadGlobal(savestr);
	    
	}
	
	private void loadGlobal(String savestr) 
	{
	
		String global = Utilities.substring("GLOBAL",savestr);

	}


	private void loadMaps(String savestr) 
	{

		String mapsStr = Utilities.substring("MAPS",savestr);
		String[] maps = mapsStr.split("</MAPDATA>");
		for (String i : maps)
		{
			String name = Utilities.substring("MAPNAME", i);
			Map newmap = h.mal.getMap(name);
			newmap.load(i,h);
			h.ge.w.addMap(newmap);
			
		}
		h.ge.w.getMap(h.ge.pl.getMapID()).entities.add(h.ge.pl);
		h.ge.pl.setMap(h.ge.w.getMap(h.ge.pl.getMapID()));
	
	}


	private void loadPlayer(String savestr) 
	{
		String player = Utilities.substring("PLAYER",savestr);
		
		String typeName[] = EntityloadTypeAndName(player);
		Player p = new Player(h);
		p.setName(typeName[0]);
		System.out.println("TYPE");
		
		System.out.println(typeName[1]);
		
		p.setType(typeName[1]);
		p.setMapID(typeName[2]);
		p.load(savestr,h);
		
		try {
			p.setSprite(new Image(p.sGet("SPRITEPATH")));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		h.ge.pl = p;
		System.out.println(h.ge.pl.getType());
	}


	private String[] EntityloadTypeAndName(String savestr) 
	{
	String[] ret = new String[3];
	ret[0] = Utilities.substring("NAME", savestr);
	ret[1] = Utilities.substring("TYPE", savestr);
	ret[2] = Utilities.substring("MNAME", savestr);
	

	return ret;
	}

}
