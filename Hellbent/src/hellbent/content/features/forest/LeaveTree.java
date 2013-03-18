package hellbent.content.features.forest;

import java.util.Random;

import hellbent.concepts.Feature;


public class LeaveTree extends Feature 
{

	public LeaveTree()
	{
		Random r = new Random();
		setType("LEAVE_TREE");
		set("IMAGE_VARIETY",r.nextInt(5));
		
	}
	
	
	public LeaveTree clone()
	{
		return new LeaveTree();
	}
}
