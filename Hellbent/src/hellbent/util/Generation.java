package hellbent.util;

import java.util.Random;
import java.util.Vector;

import hellbent.concepts.Background;
import hellbent.concepts.Formulas;
import hellbent.content.features.mine.Rock;
import hellbent.world.Map;

public class Generation
{
	
	
	public static void GenerateCaves(Map m, int dangerLVL)
	{
		m.fill(Background.CAVEWALL,false);
		Vector<int[]> roomc = pickRoomCoordinates(m);
		//Vector<int[]> roomc = new Vector<int[]>();
		int[] z = new int[2];
		z[0] = 10;
		z[1] = 10;
		roomc.add(z);

		for(int[] i : roomc)
		{
			GenerateRoom(m,200,i[0],i[1],dangerLVL);
			
		}
		
		for(int[] j : roomc)
		{
			for(int[] k : roomc)
			{
				
				GenerateCorridor(j,k,m,200,dangerLVL);
			}
			
			
		}
		
		smoothCaves(m,Background.CAVEWALL);
		
		
	}
	
	private static void smoothCaves(Map m, int CAVEWALL) 
	{
		// TODO Auto-generated method stub
		for(int x=0;x<m.getSizeX();x++)
		{
			for(int y=0;y<m.getSizeX();y++)
			{
				if (m.background[x][y] == CAVEWALL)
				{
					
					Vector<int[]> v = Utilities.neighborhoodTiles(x, y, m);
					
					m.background[x][y] = m.background[x][y] + Utilities.transformEdges(v,m,Background.CAVEFLOOR);
					
					
					
					
					
					
				}
				
				
				
			}
				
		}
		
		
		
	}

	private static void GenerateCorridor(int[] j, int[] k, Map m, int corridorTile,int danger) {
		// TODO Auto-generated method stub
		Vector<int[]> corr = null;
		
		Vector<int[]> line = Utilities.linePath(j[0],j[1],k[0],k[1]);
		
		for(int[] p : line)
		{
			m.background[p[0]][p[1]] = corridorTile;
		}
		
		GenerateCorridorFeatures(corr,danger);
	}

	private static void GenerateCorridorFeatures(Vector<int[]> corr, int danger) {
		// TODO Auto-generated method stub
		
	}

	private static Vector<int[]> pickRoomCoordinates(Map m) {
		int w = m.getSizeX();
		int h = m.getSizeY();
		
		Random r = new Random();
		Vector<int[]> roomc = new Vector<int[]>();
		
		int numRooms = Formulas.dice(1, 4) + 2;
		int x = 0;
		int y = 0;
		
		for(int i=0;i<numRooms;i++)
		{
			 x = r.nextInt(w);
			 y = r.nextInt(h);
			while(!isGoodDistance(30,x,y,roomc))
			{
				 x = r.nextInt(w);
				 y = r.nextInt(h);
			}
			
			int[] ret = new int[2];
			ret[0] = x;
			ret[1] = y;
			roomc.add(ret);
		}
		
		return roomc;
	}

	private static boolean isGoodDistance(int distance, int x, int y,
			Vector<int[]> roomc) {

		for(int[] i : roomc)
		{
			if(Utilities.distance(x, y, i[0], i[1]) < distance)
				return false;
				
		}
		
		
		return true;
	}

	public static void GenerateRoom(Map m, int freeTileId, int x, int y, int danger)
	{
		int w = m.getSizeX();
		int h = m.getSizeY();
		Random r = new Random();
		m.background[x][y] = freeTileId;

		int size = 5 * Formulas.dice(2, 4);

		Vector<int[]> slime = Utilities.getSlime(m,x,y,size);

		
		
		for (int[] k : slime)
		{	
			
			
			if(k[0] < 100 && k[1] < 100)
			{
				if(k[0] > 0 && k[1] > 0)
				{
					if (CaveGenerationCheck(m,k,x,y,size,freeTileId))
					{
						m.background[k[0]][k[1]] = freeTileId;
					
						if(r.nextInt(10) < 2)
						{
						Rock f = new Rock();
						f.set("X",k[0]);
						f.set("Y",k[1]);
						
						m.addFeature(f);
						
						}
					}
				}
			}
		}
		 
		GenerateRoomFeatures(m,x,y,danger);
		
		
	}

	private static boolean CaveGenerationCheck(Map m, int[] k, int x, int y,
			int size,int tile) {

		int distance = Utilities.distance(k[0], k[1], x, y);
		double probability = ((double)size/2)/(3*(double)distance);
		int numtiles = Utilities.hasNeighborhoodTiles(k[0],k[1],m,tile);
		if (numtiles == 1)
			probability = probability / 4;
		Random r = new Random();
		
		
		if (numtiles > 0)
		{
			if (r.nextDouble() <= probability)
				return true;
			else
				return false;
		}
		else
			return false;
		

	}

	private static void GenerateRoomFeatures(Map m, int x, int y, int danger) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
