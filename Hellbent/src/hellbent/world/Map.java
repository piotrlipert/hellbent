package hellbent.world;
import java.util.Random;
import java.util.Vector;

import hellbent.concepts.Background;
import hellbent.concepts.Formulas;
import hellbent.entity.Entity;
import hellbent.util.Utilities;


public class Map {
	
	private int sizeX;
	private int sizeY;
	public int[][] background;
	private boolean in;
	public Vector<Entity> entities = new Vector<Entity>();
	public int[][] visited;
	public Random r = new Random();
	private String name;
	private int terrain;
	public Map(String file)
	{
		
	}
	
	public Map(int sizeX,int sizeY,boolean in,int terrain)
	{
	this.background = new int[sizeX][sizeY];
	this.visited = new int[sizeX][sizeY];
	this.terrain = terrain;
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
		{
			for(int y=0;y<this.getSizeY();y++)
			{
				int z = r.nextInt(4);
				if (z == 0)
					this.background[x][y] = Background.GRASS;
				if (z == 1)
					this.background[x][y] = Background.GRASSA;
				if (z== 2)
					this.background[x][y] = Background.GRASSB;
				if (z == 3)
					this.background[x][y] = Background.GRASSC;
				
				
				}
		}
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
		
		/* TEST
		for(int xx = 0; xx<getSizeX();xx++)
			for(int yy = 0; yy<getSizeY();yy++)
				this.visited[xx][yy] = 0;
		*/
		for(int xx = 0; xx<getSizeX();xx++)
		{
			for(int yy = 0; yy<getSizeY();yy++)
			{
				if (Utilities.distance(xx,yy,x,y) < sight)
				{
					if (!Utilities.isObstructed(xx,yy,x,y,this))
						this.visited[xx][yy] = 1;
				}
			}
		}
		
	}


	public String saveString(String file)
	{
		String savefile = "";
		savefile += saveName();
		savefile += saveBackground();
		savefile += saveEntities();
		savefile += saveAttributes();
		savefile += saveItems();
		savefile += saveSpecial();
		
		return savefile;
	
	}

	private String saveName() {
		return this.getName();
	}

	private String saveItems() {
		// TODO Auto-generated method stub
		return null;
	}

	private String saveSpecial() {
		// TODO Auto-generated method stub
		return null;
	}

	private String saveBackground() 
	{
		String ret = "<BGDATA>";
		for(int x=0;x<this.getSizeX();x++)
		{
			for(int y=0;y<this.getSizeY();y++)
				ret = ret + Character.toString(Character.toChars(background[y][x]+100)[0]);
		ret = ret + '|';
		}
		ret = ret + "</BGDATA>";
		return ret;
				
	}

	private String saveEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	private String saveAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void load(String savestring)
	{
		loadBackground(savestring);
		loadEntities(savestring);
		loadAttributes(savestring);
		loadItems(savestring);
		loadSpecial(savestring);
		
	}

	protected void loadBackground(String savestring) 
	{
	String bgdata = Utilities.substring("BGDATA", savestring);
	int y = 0;
	int x = 0;
	for(int z=0;z<bgdata.length()-1;z++)
	{
		if (bgdata.charAt(z) == '|')
		{
			x=0;
			y++;
		}
		else
		{
			System.out.println(bgdata.charAt(z));
		this.background[x][y] = bgdata.charAt(z)-100;
		x++;
		}
	}
	
	}

	private void loadEntities(String savestring) 
	{
		
	}

	private void loadAttributes(String savestring) 
	{
		
	}

	private void loadSpecial(String savestring) {
		// TODO Auto-generated method stub
		
	}

	private void loadItems(String savestring) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Map clone()
	{
		return new Map(sizeX, sizeY, in, terrain);
		
	}
}
