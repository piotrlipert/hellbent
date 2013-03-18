package hellbent.content.features.mine;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Feature;


public class Stalagmit extends Feature 
{

	public Stalagmit()
	{

		Random r = new Random();

		setType("STALAGMIT");
		set("IMAGE_VARIETY",r.nextInt(2));

		
	}
	
	
	public Stalagmit clone()
	{
		return new Stalagmit();
	}
}
