package hellbent.content.features.mine;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Feature;


public class Rock extends Feature 
{

	public Rock()
	{
		Random r = new Random();
		set("WALKABLE",1);
		set("TRANSPARENT",1);

		set("IMAGE_VARIETY",r.nextInt(5));
		setType("ROCK");
		
	}
	
	
	
	public Rock clone()
	{
		return new Rock();
	}
}
