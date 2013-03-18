package hellbent.content.features.forest;

import hellbent.concepts.Feature;


public class Trunk extends Feature 
{

	public Trunk()
	{
		setType("TRUNK");
		
		
	}
	
	
	public Trunk clone()
	{
		return new Trunk();
	}
}
