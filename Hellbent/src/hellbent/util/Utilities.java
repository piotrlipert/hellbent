package hellbent.util;

import hellbent.concepts.Background;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.world.Map;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

import org.newdawn.slick.Image;

public class Utilities {
	
	

	public static int[] getDrawCoordForBigImages(Image i, int x, int y)
	{
		int coord[] = new int[2];
		coord[0] = 0;
		coord[1] = 0;
		int imx = i.getWidth();
		int imy = i.getHeight();
		
		imx = (imx/2) - 16;
		
		if (imx < 0 || imy - 32 < 0)
			return coord;
		
		coord[0] = x - imx;
		coord[1] = y - (imy - 32);
		
		
		
		
		return coord;
	}
	
	
	public static Vector<int[]> linePath(int xx, int yy, int x, int y)
	{
		Vector<int[]> path = new Vector<int[]>();
		double[] dist = new double[9];
		int h[] = new int[2];
		double lowest_dist;
		int lowest_pos = 0;
		while(!(xx == x && yy == y))
		{
			lowest_dist = 1000;
			for(int d=1;d<10;d++)
			{
				h = Formulas.dir(xx,yy,d);
				dist[d-1] = Utilities.Ddistance(h[0], h[1], x, y);
				
			}
			for(int i=1;i<10;i++)
				
			{
				if (dist[i-1] < lowest_dist)
				{
					lowest_dist = dist[i-1];
					lowest_pos = i;
				}
				
			}
			h = Formulas.dir(xx,yy,lowest_pos);
			path.add(h);
			xx = h[0];
			yy = h[1];
			
		}
		
		
		return path;
		
		
		
	}
	
	public static boolean isObstructed(int xx, int yy, int x, int y, Map m) 
	{
		
		Vector<int[]> p = Utilities.linePath(xx,yy,x,y);
		
		for(int[] point : p)
		{
			
			if (!Background.IsSeeThrough(m.background[point[0]][point[1]]))
					return true;
			if (m.featuremap[point[0]][point[1]] != null)
				if (m.featuremap[point[0]][point[1]].get("TRANSPARENT") == 0)
					return true;
					
			
				
		}
		return false;
	}
	
	
	public static int distance(int xx, int yy, int x, int y) {
		double xd = (double) x;
		double yd = (double) y;
		double xxd = (double) xx;
		double yyd = (double) yy;

		return (int) Math.sqrt(Math.pow(xxd-xd,2) + Math.pow(yyd-yd, 2));
	}
	
	public static double Ddistance(int xx, int yy, int x, int y) {
		double xd = (double) x;
		double yd = (double) y;
		double xxd = (double) xx;
		double yyd = (double) yy;

		return  Math.sqrt(Math.pow(xxd-xd,2) + Math.pow(yyd-yd, 2));
	}
	
	public static boolean isInBounds(int x,int y,int sizeX, int sizeY)
	{
		if (x >= 0 && x<sizeX)
			if (y>=0 && y<sizeY)
				return true;
		return false;
	}
	
	public static boolean isInRect(int clickx,int clicky,int sizeX, int sizeY, int rectX, int rectY)

	{
		if (clickx >= rectX && clickx<rectX+sizeX)
			if (clicky>=rectY && clicky<rectY+sizeY)
				return true;
		return false;
	}
	
	
	public static void saveStringToFile(String savestr,String path) throws IOException
	{
		BufferedWriter out;
		
		out = new BufferedWriter(new FileWriter(path));
		out.write(savestr);
		out.close();
		
	}
	
	public static boolean isIn2DVector(int[] c, Vector<int[]> v)
	{
		for (int[] k : v)
		{
			if (k[0] == c[0] && k[1] == c[1])
				return true;
		}
	return false;	
	}
	
	
	public static Vector<int[]> getVisibleTiles(Entity tmp)
	{
		Vector<int[]> tiles = new Vector<int[]>();
		Map m = tmp.getMap();
		int x = tmp.getX();
		int y = tmp.getY();
		int r = tmp.get("SIGHT");
		
		for(int i=x-r;i<x+r;i++)
		{
			for(int j=y-r;j<y+r;j++)
			{
				if (!(i<0 || i>m.getSizeX()-1 || j<0 || j>m.getSizeY()-1))
				{
					if (!Utilities.isObstructed(i, j, x, y, m) && Utilities.distance(i, j, tmp.getX(), tmp.getY()) < tmp.get("SIGHT"))
					{
						int[] h = new int[2];
						h[0] = i;
						h[1] = j;
						tiles.add(h);
					}
				}
			}
		}
		return tiles;
		
		
	}
	
	public static Vector<int[]> getObstacles(Entity tmp)
	{
		
		Map m = tmp.getMap();
		int x = tmp.getX();
		int y = tmp.getY();
		int r = tmp.get("SIGHT");
		
		Vector<int[]> obstacles = new Vector<int[]>();
		for(int i=x-r;i<x+r;i++)
		{
			for(int j=y-r;j<y+r;j++)
			{
				if (!(i<0 || i>m.getSizeX()-1 || j<0 || j>m.getSizeY()-1))
				{
					if (!Background.IsSeeThrough(m.background[i][j]))
					{
						int[] h = new int[2];
						h[0] = i;
						h[1] = j;
						obstacles.add(h);
					}
				}
			}
		}
		return obstacles;
	}

	
	public static Vector<Item> getItemsAtCoord(Map m,int x, int y)
	{
		Vector<Item> ret = new Vector<Item>();
		for(Item i : m.items)
		{
			if (i.getX() == x && i.getY() == y)
				ret.add(i);
		}
		return ret;
	}
	public static Vector<Entity> getVisibleEntities(Entity tmp) 
	{
		Vector<Entity> ent = new Vector<Entity>();
		
		for(Entity e : tmp.getMap().entities)
		{
			if(Utilities.distance(e.getX(), e.getY(), tmp.getX(), tmp.getY()) < tmp.get("SIGHT"))
			{
				if (Formulas.canSee(tmp,e))
					if (!(Utilities.isObstructed(e.getX(), e.getY(), tmp.getX(), tmp.getY(), tmp.getMap())))
						ent.add(e);
			}
		}
		
	ent.remove(tmp);
	return ent;	
		
	}
	
	public static Vector<Item> getVisibleItems(Entity tmp) 
	{
		Vector<Item> ent = new Vector<Item>();
		
		for(Item e : tmp.getMap().items)
		{
			if(Utilities.distance(e.getX(), e.getY(), tmp.getX(), tmp.getY()) < tmp.get("SIGHT"))
			{
				if (Formulas.canSee(tmp,e))
					if (!(Utilities.isObstructed(e.getX(), e.getY(), tmp.getX(), tmp.getY(), tmp.getMap())))
						ent.add(e);
			}
		}
		
	return ent;	
		
	}
	
	// From x,y to xx,yy
	public static int[] shortestGreedyPathTo(int x, int y, int xx, int yy, Map m)
	{
		int[] ret = new int[2];
		
		
		
		
		return ret;
	}
	
	public static int newlocToDir(int x, int y, int xx, int yy)
	{
		/* x-1 y+1 1 
		 * x  y+1 2
		 * x+1 y+1 3
		 */
		
		int dirx = xx - x + 2;
		int diry = (yy - y) + 2;
		
		
		
		return (3-diry)*3 + dirx;
		
		
		
	}
	
	public static Vector<Path> listDir(Path a)
	{
		Vector<Path> ret = new Vector<Path>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(a)) {
		    for (Path file: stream) {
		    	ret.add(file);
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
		
        return ret;
	}
	
	
	public static String substring(String begString, String str)  
	{

		String ret = "";
		ret = str.substring(str.indexOf("<"+begString+">")+begString.length()+2,str.indexOf("</"+begString+">"));	
		return ret;	
	
	}


	public static Vector<int[]> getSlime(Map m, int x, int y, int size) 
	{
		
		int i = x;
		int j = y;
		Vector<int[]> slime = new Vector<int[]>();
		int move = 0;
		int d = 1;
		int ii,jj = 0;
		
		
		while(distance(x,y,i,j) < size)
		{
		
		ii = i;
		jj = j;
			if(move%4 == 0)				
				i = i + d;
			if(move%4 == 1)			
				j = j - d;

			if(move%4 == 2)			
				i = i - d;

			if(move%4 == 3)			
				j = j + d;

					
		
		move++;

		if (move%2 == 0)
			d++;
		int[] k = new int[2];

		k[0] = i;
		k[1] = j;
		if(k[0]<m.getSizeX() && k[0] > 0)
		{
			if(k[1]<m.getSizeY() && k[1] > 0)
			{
				
				for(int[] p : Utilities.linePath(i, j, ii, jj))
					slime.add(p);
				slime.add(k);
			}
		}
		}
		
	
		return slime;
	}

	
	static Vector<int[]> neighborhoodTiles(int x, int y, Map m)
	{
		
		Vector<int[]> v = new Vector<int[]>();
		
		for(int i=y-1;i<y+2;i++)
		{
			for(int j=x-1;j<x+2;j++)
			{
				if (i > 0 && j > 0 && i<m.getSizeX() && j<m.getSizeY())
				{
					int[] k = new int[2];
					
					
					k[0] = j;
					k[1] = i;
					
					
					v.add(k);
					
				}
				else
				{
					int[] k = new int[2];

					k[0] = -1;
					k[1] = -1;
					v.add(k);
				}
			}
		}
		return v;
		
	}

	public static int hasNeighborhoodTiles(int x, int y, Map m, int tile)
	{
		
		int sum = 0;
		Vector<int[]> v = neighborhoodTiles(x,y,m);
		for(int[] k : v)
		{
			if (k[0] != -1 && k[1] != -1)
			{	
			if (m.background[k[0]][k[1]] == tile)
				sum++;
		
			}
		}
		return sum;
	}


	public static int transformEdges(Vector<int[]> v, Map m, int tile) 
	{
	int[] ne = new int[9];
	int x = 0;
	int sum = 0;
	for(int[] p : v)
	{
		if(p[0] != -1 && p[1] != -1)
		{
		if (m.background[p[0]][p[1]] == tile)
			{
			ne[x] = 1;
			sum++;
			}
		}
		x++;
		
	}
		
	if (sum == 1)
	{
		if (ne[8] == 1)
			return 1;
		if (ne[6] == 1)
			return 3;
		if (ne[2] == 1)
			return 6;
		if (ne[0] == 1)
			return 8;
		if (ne[1] == 1)
			return 7;
		if (ne[3] == 1)
			return 5;
		if (ne[5] == 1)
			return 4;
		if (ne[7] == 1)
			return 2;
		
	}
	if (sum == 2)
	{
	if ((ne[8] == 1 || ne[6] == 1) && ne[7] == 1)	
		return 2;
	if ((ne[0] == 1 || ne[2] == 1) && ne[1] == 1)	
		return 7;
	if ((ne[0] == 1 || ne[6] == 1) && ne[3] == 1)	
		return 5;
	if ((ne[2] == 1 || ne[8] == 1) && ne[5] == 1)	
		return 4;
	
	if(ne[0] == 1 && ne[2] == 1)
		return 16;
	if(ne[0] == 1 && ne[6] == 1)
		return 15;
	if(ne[2] == 1 && ne[8] == 1)
		return 17;
	if(ne[6] == 1 && ne[8] == 1)
		return 18;
	
	if (ne[1] == 1 && ne[5] == 1)
		return 10;
	if (ne[1]==1 && ne[3] == 1)
		return 9;
	if (ne[3]==1 && ne[7] == 1)
		return 11;
	if (ne[5]==1 && ne[7] == 1)
		return 12;
	
	if (ne[7] == 1)	
		return 2;
	if (ne[1] == 1)	
		return 7;
	if (ne[3] == 1)	
		return 5;
	if (ne[5] == 1)	
		return 4;
	
	
	}
	if(sum == 3)
	{	
		if ((ne[8] == 1 && ne[6] == 1) && ne[7] == 1)	
			return 2;
		if ((ne[0] == 1 && ne[2] == 1) && ne[1] == 1)	
			return 7;
		if ((ne[0] == 1 && ne[6] == 1) && ne[3] == 1)	
			return 5;
		if ((ne[2] == 1 && ne[8] == 1) && ne[5] == 1)	
			return 4;
	
		
		if (ne[1] == 1 && ne[5] == 1)
			return 10;
		if (ne[1]==1 && ne[3] == 1)
			return 9;
		if (ne[3]==1 && ne[7] == 1)
			return 11;
		if (ne[5]==1 && ne[7] == 1)
			return 12;
		
		if ((ne[8] == 1 || ne[6] == 1) && ne[7] == 1)	
			return 2;
		if ((ne[0] == 1 || ne[2] == 1) && ne[1] == 1)	
			return 7;
		if ((ne[0] == 1 || ne[6] == 1) && ne[3] == 1)	
			return 5;
		if ((ne[2] == 1 || ne[8] == 1) && ne[5] == 1)	
			return 4;
	
	}
	
	
	
	if( sum == 4)
	{
	if(ne[3] == 1 && ne[1] == 1 && ne[5] == 1)
		return 21;
	
	if(ne[0] == 1 && ne[1] == 1 && ne[3] == 1)
		return 9;
	
	if(ne[1] == 1 && ne[2] == 1 && ne[5] == 1)
		return 10;
	if(ne[5] == 1 && ne[7] == 1 && ne[8] == 1)
		return 12;
	if(ne[7] == 1 && ne[6] == 1 && ne[3] == 1)
		return 11;
	
	
	if (ne[1] == 1 && ne[5] == 1)
		return 10;
	if (ne[1]==1 && ne[3] == 1)
		return 9;
	if (ne[3]==1 && ne[7] == 1)
		return 11;
	if (ne[5]==1 && ne[7] == 1)
		return 12;
	
	if ((ne[8] == 1 || ne[6] == 1) && ne[7] == 1)	
		return 2;
	if ((ne[0] == 1 || ne[2] == 1) && ne[1] == 1)	
		return 7;
	if ((ne[0] == 1 || ne[6] == 1) && ne[3] == 1)	
		return 5;
	if ((ne[2] == 1 || ne[8] == 1) && ne[5] == 1)	
		return 4;
	
	
	}
	
	if (sum == 5)
	{
		
		if (ne[0] == 0 && ne[1] == 0 && ne[2] == 0)
			return 20;
		if (ne[8] == 0 && ne[7] == 0 && ne[6] == 0)
			return 21;
		if (ne[0] == 0 && ne[3] == 0 && ne[6] == 0)
			return 22;
		if (ne[2] == 0 && ne[5] == 0 && ne[8] == 0)
			return 23;
		
		
		if (ne[1] == 1 && ne[5] == 1)
			return 10;
		if (ne[1]==1 && ne[3] == 1)
			return 9;
		if (ne[3]==1 && ne[7] == 1)
			return 11;
		if (ne[5]==1 && ne[7] == 1)
			return 12;
		
		
		if (ne[1] == 0)
			return 20;
		if (ne[7] == 0)
			return 21;
		if (ne[3] == 0)
			return 22;
		if (ne[5] == 0)
			return 23;
		
		
		
	}
	
	if (sum > 5)
	{
		if (ne[1] == 0)
			return 20;
		if (ne[3] == 0)
			return 22;
		if (ne[5] == 0)
			return 23;
		if (ne[7] == 0)
			return 21;

		
		
		return 19;
	}
	return 0;
	}
}
