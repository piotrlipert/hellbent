package hellbent.world;
import java.util.Vector;

import hellbent.concepts.Background;
import hellbent.concepts.Formulas;
import hellbent.entity.Entity;


public class Map {
	
	private int sizeX;
	private int sizeY;
	public int[][] background;
	private boolean in;
	public Vector<Entity> entities = new Vector<Entity>();
	public int[][] visited;
	
	
	public Map(int sizeX,int sizeY,boolean in,int terrain)
	{
	this.background = new int[sizeX][sizeY];
	this.visited = new int[sizeX][sizeY];
	setIn(in);
	setSizeX(sizeX);
	setSizeY(sizeY);
	
	for(int x=0;x<this.getSizeX();x++)
		for(int y=0;y<this.getSizeY();y++)
			this.visited[x][y] = 0;
	
	
	if (in == false)
	{
		this.fill(Background.GRASS);
	}
	else
	{
		this.fill(Background.ROCK);
	}
	
	}

	
	public void fill(int what)
	{
		for(int x=0;x<this.getSizeX();x++)
			for(int y=0;y<this.getSizeY();y++)
				this.background[x][y] = what;
		
	}
	
	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public boolean isIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}

	public Entity entityAtCoord(int x,int y)
	{
		for (Entity e : entities)
		{
			if(e.getX() == x && e.getY() == y)
				return e;
		}
		
		return null;
		
	}
	

	public void Exit(int x, int y, Entity entity) 
	{
		
	}


	public void discover(Entity e) 
	{
		int x = e.getX();
		int y = e.getY();
		int sight = e.get("SIGHT");
		
		for(int xx = 0; xx<getSizeX();xx++)
		{
			for(int yy = 0; yy<getSizeY();yy++)
			{
				if (Formulas.distance(xx,yy,x,y) < sight)
				{
					this.visited[xx][yy] = 1;
				}
			}
		}
		
	}


}
