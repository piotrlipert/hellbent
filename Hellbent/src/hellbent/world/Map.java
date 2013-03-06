package hellbent.world;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import org.newdawn.slick.Image;

import hellbent.HellbentGame;
import hellbent.concepts.Attributable;
import hellbent.concepts.Background;
import hellbent.concepts.Event;
import hellbent.concepts.Feature;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.concepts.Trap;
import hellbent.entity.Entity;
import hellbent.loaders.MonsterLoader;
import hellbent.util.Utilities;


public class Map extends Attributable {
	
	private int sizeX;
	private int sizeY;
	public int[][] background;
	private boolean in;
	public Vector<Entity> entities = new Vector<Entity>();
	public Vector<Item> items = new Vector<Item>();
	public Vector<Feature> features = new Vector<Feature>();
	public Vector<Event> events = new Vector<Event>();
	public Vector<Trap> traps = new Vector<Trap>();
	public HellbentGame hg;
	
	
	// TODO MAP FEATURES TO ARRAY!
	public Feature[][] featuremap;

	public int[][] visited;
	public Random r = new Random();
	private String name;
	private int terrain;
	
	public void onEntry(Entity e)
	{
		
	}

	public Map(String file)
	{
		
	}
	
	public void initMap()
	{
		for(int x=0;x<this.getSizeX();x++)
			for(int y=0;y<this.getSizeY();y++)
				this.visited[x][y] = 0;
			
		
		
	}
	
	
	
	public void addFeature(Feature f)
	{
		features.add(f);
		
			featuremap[f.get("X")][f.get("Y")] = f;
		
		
	}
	public Map(int sizeX,int sizeY,int fill,int terrain, HellbentGame h)
	{
	this.hg = h;
	this.background = new int[sizeX][sizeY];
	this.visited = new int[sizeX][sizeY];
	this.terrain = terrain;
	featuremap = new Feature[sizeX][sizeY];

	setIn(in);
	setSizeX(sizeX);
	setSizeY(sizeY);
	
	for(int x=0;x<this.getSizeX();x++)
		for(int y=0;y<this.getSizeY();y++)
			this.visited[x][y] = 0;
	
	
	
		this.fill(fill,true);
	
	}

	
	public void fill(int what, boolean randomize)
	{
		
		

		for(int x=0;x<this.getSizeX();x++)
		{
			for(int y=0;y<this.getSizeY();y++)
			{
				ArrayList<Image> v = hg.bal.BackgroundTiles.get(what);
				int z = 0;
				if (randomize)
					z = r.nextInt(v.size());
				
				background[x][y] = what + z;
				
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
		
		for(int xx = 0; xx<getSizeX();xx++)
			for(int yy = 0; yy<getSizeY();yy++)
				e.sight[xx][yy] = 0;
		
		
		for(int xx = 0; xx<getSizeX();xx++)
		{
			for(int yy = 0; yy<getSizeY();yy++)
			{
				if (Utilities.distance(xx,yy,x,y) <= sight)
				{
					if (!Utilities.isObstructed(xx,yy,x,y,this))
					{
						this.visited[xx][yy] = 1;
						e.sight[xx][yy] = 1;
					}	
				}
			}
		}
		
		for(Feature f : features)
		{
			
			if (f.get("DISCOVERED") == 0)
			{
				if (Utilities.distance(f.get("X"), f.get("Y"), x, y) <= e.get("SIGHT"))
					if(!Utilities.isObstructed(f.get("X"), f.get("Y"), x, y, this))
							f.set("DISCOVERED", 1);
				
			}
		}
		
	}


	public String saveString()
	{
		String savefile = "<MAPDATA>";
		savefile += saveName();
		savefile += saveBackground();
		savefile += saveDiscovered();
		savefile += saveEntities();
		savefile += saveAttributes();
		savefile += saveItems();
		savefile += saveSpecial();
		savefile += saveEvents();
		savefile += saveTraps();
		
		return savefile + "</MAPDATA>";
	
	}

	private String saveTraps() {
		// TODO Auto-generated method stub
		return "<MAPTRAPS></MAPTRAPS>";
	}

	private String saveEvents() {
		String savestr = "<MAPEVENTS>";
		
		for(Event i : events)
		{
			
				savestr = savestr + i.save();
			
		}
		
		return savestr + "</MAPEVENTS>";
	}

	private String saveDiscovered() {
			String savestr = "<DISCOVERED>";
			for(int y=0;y<this.getSizeY();y++)
			{
				for(int x=0;x<this.getSizeX();x++)
				{
					savestr = savestr + Integer.toString(this.visited[x][y]);
				}
			savestr = savestr + "|";
			}		
		return savestr + "</DISCOVERED>";
	}

	private String saveName() {
		return "<MAPNAME>"+this.getName()+"</MAPNAME>";
	}

	private String saveItems() {
		String ret = "<MAPITEMS>\n";
			for(Item i : items)
			{
				ret = ret + i.save();
			}
		
		return ret +"</MAPITEMS>\n";
	}

	private String saveSpecial() {
		// TODO Auto-generated method stub
		return "<MAPFEATURES></MAPFEATURES>";
	}

	private String saveBackground() 
	{
		String ret = "<BGDATA>";
		for(int x=0;x<this.getSizeX();x++)
		{
			for(int y=0;y<this.getSizeY();y++)
				ret = ret + Integer.toString(background[y][x])+"x";
		ret = ret + "|\n";
		}
		ret = ret + "</BGDATA>\n";
		return ret;
				
	}

	private String saveEntities() {
		String savestr = "<ENTITIES>";
		
		for(Entity i : entities)
		{
			if (i.getType()!="Player")
			{
				savestr = savestr + i.save();
			}
			
		}
		
		return savestr + "</ENTITIES>";
	}

	public String saveAttributes() {
		String ret = "<MAP_ATR>\n";
		for(String i : this.data.keySet())
			{
			ret = ret + i + "::" + Integer.toString(this.get(i)) + "\n";
			}
			ret = ret + "</MAP_ATR>\n";

			ret = ret + "<MAP_sATR>\n";
			
			for(String i : this.sdata.keySet())
			{
			ret = ret + i + "::" + this.sGet(i) + "\n";
			}
			
			
			return ret+"</MAP_sATR>\n";
	}
	
	
	public void load(String savestring,HellbentGame hg)
	{
		loadBackground(savestring);
		loadDiscovered(savestring);
		loadEntities(savestring,hg);
		loadAttributes(savestring);
		loadItems(savestring,hg);
		loadSpecial(savestring, hg);
		loadEvents(savestring, hg);
		loadTraps(savestring, hg);
		
	}

	private void loadTraps(String savestring, HellbentGame hg) {
		// TODO Auto-generated method stub
		
	}

	private void loadEvents(String savestring, HellbentGame hg) 
	{
	

	}

	private void loadDiscovered(String savestring) 
	{
		String disdata = Utilities.substring("DISCOVERED", savestring);
		int y = 0;
		int x = 0;
		for(int z=0;z<disdata.length()-1;z++)
		{
			if (disdata.charAt(z) == '|')
			{
				x=0;
				y++;
			}
			else
			{
			this.visited[x][y] = Integer.parseInt(String.valueOf(disdata.charAt(z)));
			x++;
			}
		}
		
	}

	protected void loadBackground(String savestring) 
	{
	String bgdata = Utilities.substring("BGDATA", savestring);
	int y = 0;
	int x = 0;
	
	String[] lines = bgdata.split("|\n");
	
	for(String i : lines)
	{
	if(i.length() > 1)
	{
		String[] chars = i.split("x");
			for(String j : chars)
			{
				
				this.background[y][x] = Integer.parseInt(j);
				x++;
			}
	x = 0;
	y++;
	}
	}
		
	
	}

	private void loadEntities(String savestring, HellbentGame hg) 
	{
		savestring = Utilities.substring("ENTITIES", savestring);
		String[] entities = savestring.split("</ENTITY>");
		
		for(String i : entities)
		{
			if (i.indexOf("<TYPE>")!= -1)
			{
			String type = Utilities.substring("TYPE", i);
			Entity e = hg.mol.getMonster(type);
			e.load(i,hg);
			e.setMap(this);
			this.entities.add(e);
			}
		}
	}

	public void loadAttributes(String savestring) 
	{
		String atr = Utilities.substring("MAP_ATR", savestring);
		String satr = Utilities.substring("MAP_sATR", savestring);

		String[] aS = atr.split("[\r\n]+");
		String[] SaS = satr.split("[\r\n]+");

		for (String i : aS)
		{
			if (i.length() > 3)
			 this.set(i.split("::")[0],Integer.parseInt(i.split("::")[1]));
		}
			
		for (String i : SaS)
		{
			if (i.length() > 3)
			 this.sSet(i.split("::")[0],i.split("::")[1]);
		}

	}
	

	private void loadSpecial(String savestring, HellbentGame hg) 
	{
		String f = Utilities.substring("MAPFEATURES", savestring);
		String[] feat = f.split("</FEATURE>");
		
		for (String s : feat)
		{
			if (s.length() > 10)
			{

		String type = Utilities.substring("TYPE", s);
		Feature i = hg.ftl.getFeature(type);
		i.load(s);
		features.add(i);
			}
			}

	}

	

	private void loadItems(String savestr, HellbentGame hg) 
	{
		{
			String it = Utilities.substring("MAPITEMS", savestr);
			String[] item = it.split("</ITEM>");
			
			for (String s : item)
			{
				if (s.length() > 10)
				{

			String type = Utilities.substring("TYPE", s);
			Item i = hg.itl.getItem(type);
			i.load(s);
			items.add(i);
				}
				}

			}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Map clone()
	{
		return new Map(sizeX, sizeY,100,terrain,hg);
		
	}

	public Feature featureUnwalkableAtCoord(int x, int y) {
	
		if (featuremap[x][y] != null)
			if (featuremap[x][y].get("WALKABLE") == 0)
				return featuremap[x][y];
	
		return null;
	}

	public Feature getFeatureAt(int x, int y) {
		
		
				return featuremap[x][y];
	
		
	}


}
