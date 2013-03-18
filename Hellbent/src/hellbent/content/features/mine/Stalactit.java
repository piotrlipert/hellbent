package hellbent.content.features.mine;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Feature;


public class Stalactit extends Feature 
{

	public Stalactit()
	{

		Random r = new Random();
		setType("STALACTIT");
		set("IMAGE_VARIETY",r.nextInt(2));
		
		
	}
	
	
	public Stalactit clone()
	{
		return new Stalactit();
	}
}
