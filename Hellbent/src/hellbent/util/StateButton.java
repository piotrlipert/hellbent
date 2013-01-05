package hellbent.util;

import hellbent.HellbentGame;

public class StateButton extends Button{
	HellbentGame s = null;
	public int stateID;
	
	public StateButton(int x, int y, int width, int height, int stateID,HellbentGame s)
	{
	super(x,y,width,height);
	this.stateID = stateID;
	this.s = s;
	}
	
	
	
	
	
	
	
}
