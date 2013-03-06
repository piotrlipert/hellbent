package hellbent.concepts;

public class Background {
	
	public static int ROCK = 0;
	public static int GRASS = 100;
	public static int GRASSA = 101;
	public static int GRASSB = 102;
	public static int GRASSC = 103;
	public static int CAVEFLOOR = 200;
	public static int CAVEWALL = 300;

	
	public static int WOODFLOOR = 5;
	public static boolean IsWalkable(int i) 
	{
		if (i/100 == CAVEFLOOR/100)
			return true;
		if (i/100 == CAVEWALL/100)
			return false;
		
		if (i/100 == ROCK/100)
			return false;
		if (i/100 == GRASS/100)
			return true;
		
		return false;
	}
	public static boolean IsSeeThrough(int i) {
	
		if (i/100 == ROCK/100)
			return false;
		if (i/100 == GRASS/100)
			return true;
		if (i/100 == CAVEFLOOR/100)
			return true;
		if (i/100 == CAVEWALL/100)
			return false;
		return true;
	}

	

	
}
