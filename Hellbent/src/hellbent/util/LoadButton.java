package hellbent.util;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.newdawn.slick.Image;

import hellbent.HellbentGame;

public class LoadButton extends Button 
{

	HellbentGame hg;
	String NameAndDescription = "";
	Path p;
	
	
	public LoadButton(int x, int y, int width, int height, HellbentGame s, Path s2, Image b) 
	{
		super(x, y, width, height, b);
		hg = s;
		p = s2;
		
		
	}
	
	public void Clicked()
	{
		try {
			hg.load.loadGame(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
