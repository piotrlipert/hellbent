package hellbent.content.features.mine;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Feature;


public class WoodenDoor extends Feature 
{

	public WoodenDoor()
	{

	setType("WOODEN_DOOR");
	
	set("CLOSED",1);
	
	
	}

		
	
	
	
	public WoodenDoor clone()
	{
		return new WoodenDoor();
	}
}
