package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.entity.Player;
import hellbent.util.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	
	
	void loadGame(String path) throws FileNotFoundException
	{
		String savestr = getFileAsString(path);
		
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
		String[] maps = mapsStr.split("<ENDMAP>");
		for (String i : maps)
		{
			
		}
		
	}


	private void loadPlayer(String savestr) 
	{
		String player = Utilities.substring("PLAYER",savestr);
		String typeName[] = EntityloadTypeAndName(player);
		Player p = new Player();
		p.setType(typeName[0]);
		p.setName(typeName[1]);
		p.load(savestr);
		
	}


	private String[] EntityloadTypeAndName(String savestr) 
	{
	String[] ret = new String[2];
	String[] lines = savestr.split("\n");
	ret[0] = (lines[0].substring(lines[0].indexOf("TYPE:")+5));
	ret[1] = (lines[1].substring(lines[1].indexOf("NAME:")+5));
	return ret;
	}

}
