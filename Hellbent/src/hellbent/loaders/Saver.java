package hellbent.loaders;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import hellbent.HellbentGame;
import hellbent.entity.Player;
import hellbent.world.Map;

public class Saver 
{
HellbentGame h;
	public Saver(HellbentGame hg)
	{
		h = hg;
	}
	
	
	public void saveGame(String path) throws IOException
	{
		String savestr = "";
		
		savestr += savePlayer();
		savestr += saveMaps();
		savestr += saveGlobal();
		
		
		BufferedWriter out;
		
		out = new BufferedWriter(new FileWriter(path));
		out.write(savestr);
		out.close();
	
	}

	private String saveGlobal( ) {
		return "<GLOBAL></GLOBAL>";
		
	}

	private String saveMaps( ) 
	{
		String savestr = "<MAPS>";
		for(String i : h.ge.getWorld().maps.keySet())
		{
			Map m = h.ge.getWorld().getMap(i);
			
			savestr+= m.saveString();
		}
		return savestr+"</MAPS>";
		
	}

	private String savePlayer() 
	{
	String savestr = "";
		Player tmp = h.ge.pl;
	savestr += tmp.save();
	return savestr;
	
	}
	
}
