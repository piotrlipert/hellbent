package hellbent.concepts;

public class Background {
	
	public static int ROCK = 0;
	public static int GRASS = 1;
	public static int WOODFLOOR = 2;
	public static boolean IsWalkable(int i) 
	{
		if (i == ROCK)
			return false;
		if (i == GRASS)
			return true;
		if (i == WOODFLOOR)
			return true;
		
		return false;
	}

	

	
}
