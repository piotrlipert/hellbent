package hellbent.content.features.mine;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.concepts.Feature;


public class Barrel extends Feature 
{

	public Barrel()
	{

	
	try {
		setImage(new Image("resources/graphics/features/mine/barrel.png",Color.white));
	} catch (SlickException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}
	
	
	public Barrel clone()
	{
		return new Barrel();
	}
}
