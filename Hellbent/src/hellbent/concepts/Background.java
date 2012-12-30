package hellbent.concepts;

public class Background {
	
	public static int ROCK = 0;
	public static int GRASS = 1;
	public static int GRASSA = 2;
	public static int GRASSB = 3;
	public static int GRASSC = 4;

	public static int WOODFLOOR = 5;
	public static boolean IsWalkable(int i) 
	{
		if (i == ROCK)
			return false;
		if (i == GRASS)
			return true;
		if (i == GRASSC)
			return true;
		if (i == GRASSB)
			return true;
		if (i == GRASSA)
			return true;
		if (i == WOODFLOOR)
			return true;
		
		return false;
	}
	public static boolean IsSeeThrough(int i) {
	
		if (i == ROCK)
			return false;
		if (i == GRASS)
			return true;
		if (i == WOODFLOOR)
			return true;
		if (i == GRASSA)
			return true;
		if (i == GRASSB)
			return true;
		if (i == GRASSC)
			return true;
		
		return true;
	}

	

	
}
