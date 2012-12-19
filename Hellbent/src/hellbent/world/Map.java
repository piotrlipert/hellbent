package hellbent.world;
import java.util.Vector;

import hellbent.concepts.Background;
import hellbent.entity.Entity;


public class Map {
	
	private int sizeX;
	private int sizeY;
	public int[][] background;
	private boolean in;
	public Vector<Entity> entities = new Vector<Entity>();
	
	public Map(int sizeX,int sizeY,boolean in,int terrain)
	{
	this.background = new int[sizeX][sizeY];
	setIn(in);
	setSizeX(sizeX);
	setSizeY(sizeY);
	
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


}
