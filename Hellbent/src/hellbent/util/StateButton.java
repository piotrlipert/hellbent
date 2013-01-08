package hellbent.util;

import org.newdawn.slick.Image;

import hellbent.HellbentGame;

public class StateButton extends Button{
	HellbentGame s = null;
	public int stateID;
	
	public StateButton(int x, int y, int width, int height, int stateID,HellbentGame s,Image b)
	{
	super(x,y,width,height,b);
	this.stateID = stateID;
	this.s = s;
	}
	
	
	
	
	
	
	
}
