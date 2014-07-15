package hellbent.states;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

import hellbent.HellbentGame;
import hellbent.concepts.Feature;
import hellbent.concepts.GameEngine;
import hellbent.concepts.Item;
import hellbent.content.actions.Move;
import hellbent.content.actions.Wait;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.util.Prompt;
import hellbent.util.Utilities;
import hellbent.world.Map;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends HBGameState {
	
	private int stateID;
	public int moveflag = 0;
	public int moving = 0;
    HellbentGame hg = null;
    GameEngine ge = null;
	public int inputACTION = 0;
	public boolean activeTargetting = false;
	long oldtime = 0;
    Image background;
    Random rnd = new Random();
    int centerX;
    int centerY;
    boolean stillcenter = true;
    public String message = " ";
    
    
    public static final int HPX = 135;
    public static final int HPY = 705;
    public static final int MPX = 840;
    public static final int MPY = 705;
    public static final int EFFX = 875;
    public static final int EFFY = 138;
    public static final int EFFXEND = 1010;
    public static final int EFFYEND = 392;


    
    
    

    public static final int LEFTBORDER = 0;
    public static final int UPBORDER = 0;
    public static final int MIDDLEX = 13;
    public static final int MIDDLEY = 10;
    public static final int TILESIZE = 32;
	
    
    private static final int HOW_MANY_TILES_X = 28;
	private static final int HOW_MANY_TILES_Y = 22;
    
	
	public Prompt activePrompt = null;
	public Vector<Entity> EntityTargets;
	public Vector<Feature> FeatureTargets;
	public Vector<int[]> TileTargets;
    

    public void stopMoving()
    {
    	moving = 0;
    	
    	
    }

    
    
 
    
    
 public GameplayState(int gameplaystate,HellbentGame s) {
	// TODO Auto-generated constructor stub
	  this.stateID = gameplaystate;
	  this.hg = s;
	  hg.ge = new GameEngine(this,hg);
	  
}

@Override
public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
	

	ge = hg.ge;

	background = new Image("resources/graphics/backgrounds/back.png");
	hg.keyctrl.setGs(this);
	hg.targetctrl.setGs(this);

	
}




public void drawOnScreen(int x, int y, Image z)
{
	z.draw(LEFTBORDER+TILESIZE*(x+MIDDLEX),UPBORDER + TILESIZE * (y+MIDDLEY));
}

public int[] translateCoord(int x, int y)
{
	int coord[] = new int[2];
	
	coord[0] = (x+MIDDLEX)*TILESIZE + LEFTBORDER;
	coord[1] = (y+MIDDLEY)*TILESIZE + UPBORDER;
		
			return coord;
	
}

public void rendermessegeBox()
{
	
}
public void rendermessage(HellbentGame hg)
{
	rendermessegeBox();

	Player tmp = hg.ge.pl;
	String mess = tmp.getMessage();
	if (mess != null)
	{
		hg.fontCommon.drawString(30, 30, mess,Color.red);
	}
}

public void renderMAP(HellbentGame hg, Map m) throws SlickException
{	
	
	Player tmp = hg.ge.getPlayer();
	
	centerX = tmp.getX();
	centerY = tmp.getY();
	boolean r = false;
	int xx = 0;
	ArrayList<Image> i;
	Image d = null;
	Vector<int[]> vis = Utilities.getVisibleTiles(tmp);
	int yy = 0;
	for(int x=centerX-((HOW_MANY_TILES_X/2)-1);x<centerX+(HOW_MANY_TILES_X/2);x++)
	{
		for(int y=centerY-((HOW_MANY_TILES_Y/2)-1);y<centerY+HOW_MANY_TILES_Y/2;y++)
		{
			r = false;
			if (x < 0 || x > m.getSizeX()-1)
				r = true;
			if (y < 0 || y > m.getSizeY()-1)
				r = true;
			if (!r)
			{
				i = hg.bal.BackgroundTiles.get((m.background[x][y]/100) * 100);
				d = i.get(m.background[x][y]%((m.background[x][y]/100) * 100));

			}
			else
			{
			
			 i = (hg.bal.BackgroundTiles.get(m.background[0][0]));
			 
			 	
				//d = i.get(m.background[0][0]%((m.background[0][0]/100) * 100));

			}
			
			
			
			if (!r)
			{
				
				int[] h = new int[2];
				h[0] = x;
				h[1] = y;
				double distance = Utilities.Ddistance(tmp.getX(), tmp.getY(), x, y);
				float brightness = (float) (1 - 0.05 * (distance - tmp.get("SIGHT")) - Math.signum(distance - tmp.get("SIGHT"))* 0.04); 
				//float brightness = 0.5F;
				if(tmp.sight[x][y] == 0)
					brightness = brightness * 0.8F;
			if (m.visited[x][y] == 1)
				{
				Image ic = d.copy();
				
				if (!Utilities.isIn2DVector(h, vis))
				{
					ic.setColor(0, brightness,brightness,brightness, brightness);
					ic.setColor(1, brightness,brightness,brightness, brightness);
					ic.setColor(2, brightness,brightness,brightness, brightness);
					ic.setColor(3, brightness,brightness,brightness, brightness);
				
					
				}
				ic.draw(LEFTBORDER + xx*TILESIZE,UPBORDER + yy*TILESIZE);
				}
			}
			else
			{
				//d.draw(LEFTBORDER + xx*TILESIZE,UPBORDER + yy*TILESIZE);

			}
				
			yy++;
		}
	xx++;
	yy = 0;
	}
		
	
	
}

public void renderPlayer(HellbentGame hg)
{
	Player tmp = hg.ge.getPlayer();
	if (true)
	{
	tmp.getSprite().draw(LEFTBORDER+TILESIZE*MIDDLEX,UPBORDER+TILESIZE*MIDDLEY);
	}
	
	
}

public void renderEntities(HellbentGame hg)
{
	Player tmp = hg.ge.getPlayer();

	centerX = tmp.getX();
	centerY = tmp.getY();
	
	
	
	for (Entity e : Utilities.getVisibleEntities(tmp))
	{
		Image fi = null;
		int variety = e.get("IMAGE_VARIETY");
		
		if (variety != 0)
			fi = hg.rel.getEntityImage(e.getType()+Integer.toString(variety));
		else
			fi = hg.rel.getEntityImage(e.getType());

		
		drawOnScreen(e.getX()-centerX,e.getY()-centerY,fi);
	}
	
}


public int[] getCoordAtMouseClick(int x, int y)
{
	int[] c = new int[2];
	int centerX = hg.ge.pl.getX();
	int centerY = hg.ge.pl.getY();
	
	
	if (x > HOW_MANY_TILES_X * TILESIZE || y > HOW_MANY_TILES_Y * TILESIZE)
	{
		c[0] = -1;
		c[1] = -1;
		return c;
	}
	
	
	c[0] = centerX +(x/TILESIZE) - MIDDLEX;
	c[1] = centerY + (y/TILESIZE) - MIDDLEY;
	
	
	
	return c;
}
public void renderItems(HellbentGame hg)
{
	Player tmp = hg.ge.getPlayer();

	centerX = tmp.getX();
	centerY = tmp.getY();
	
	
	
	for (Item e : Utilities.getVisibleItems(tmp))
	{
		drawOnScreen(e.getX()-centerX,e.getY()-centerY,hg.rel.getItemImage(e.getType()));
	}
	
}
public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
		throws SlickException {
	
	HellbentGame hg = (HellbentGame) arg1;
	background.draw(0,0);

	renderMAP(hg,hg.ge.w.getMap(hg.ge.pl.getMapID()));
	renderItems(hg);

	
	renderSpecialWalkable(hg);
	renderEntities(hg);

	renderPlayer(hg);
	
	renderSpecialUnwalkable(hg);

	rendermessage(hg);
	renderHPMP(hg);
	renderEffects(hg);
	
	renderPrompt();
	if(activeTargetting)
	{
		hg.targetctrl.renderTargetter();
	
	}
		/* TEST
	 * renderlines(hg,arg2);
	 */
	
	
	
}




	
	



private void renderEffects(HellbentGame hg2) {
	// TODO Auto-generated method stub
	
}






private void renderHPMP(HellbentGame hg2) 
{
int hp,hpMAX,mp,mpMAX;
Player tmp = hg.ge.pl;
hp = tmp.get("HP");
hpMAX = tmp.get("HP_MAX");
mp = tmp.get("MP");
mpMAX = tmp.get("MP_MAX");

String hptext = Integer.toString(hp) + "/"+Integer.toString(hpMAX);
String mptext = Integer.toString(mp) + "/"+Integer.toString(mpMAX);

hg2.fontCommon.drawString(HPX, HPY, hptext,Color.red);
hg2.fontCommon.drawString(MPX, MPY, mptext,Color.blue);


	
}






private void renderSpecialUnwalkable(HellbentGame hg2) {
	renderSpecial(hg2,0);
}






private void renderSpecialWalkable(HellbentGame hg2) {
	renderSpecial(hg2,1);
	
}






private void drawFeature(Feature f)
{
	int x = f.get("X");
	int y = f.get("Y");
	int xx = hg.ge.pl.getX();
	int yy = hg.ge.pl.getY();
	Image fi = null;
	float distance = Utilities.distance(xx, yy, x, y);
	int variety = f.get("IMAGE_VARIETY");
	if (variety!=0)
		fi = hg.rel.getFeatureImage(f.getType()+Integer.toString(variety));
	else
		fi = hg.rel.getFeatureImage(f.getType());
	int tra[] = translateCoord(x-xx, y-yy);
			
		int[] translated = Utilities.getDrawCoordForBigImages(fi, tra[0], tra[1]);
		if(tra[0]+fi.getWidth()/2<TILESIZE*MIDDLEX*2 && tra[1]+fi.getHeight()/2<TILESIZE*MIDDLEY*2)
		{
			float brightness = 1;

			if(distance >= hg.ge.pl.get("SIGHT"))
				{
			    brightness =  (brightness - ((float)(distance) - (float) (hg.ge.pl.get("SIGHT")))*0.08F);
				}
			if (f.get("OBSTRUCT") == 1)
				brightness = brightness/2;
			
			Image ic = fi.copy();
			ic.setColor(0, brightness,brightness,brightness, brightness);
				ic.setColor(1, brightness,brightness,brightness, brightness);
				ic.setColor(2, brightness,brightness,brightness, brightness);
				ic.setColor(3, brightness,brightness,brightness, brightness);
			ic.draw(translated[0],translated[1]);
				
			
		
		
		}
			
	}
	



private void renderSpecial(HellbentGame hg2,int walkable) 
{
Map m = hg.ge.w.getMap(hg.ge.pl.getMapID());
Vector<Feature> featureList = new Vector<Feature>();
int xx = hg.ge.pl.getX();
int yy = hg.ge.pl.getY();
for(int i=xx-15;i<xx+15;i++)
{
	for(int j=yy-15;j<yy+15;j++)
	{
		if (!(i < 0 | i >= m.getSizeX() || j < 0 || j >= m.getSizeY()))
				{
				Feature f = m.featuremap[i][j];
				if (f == null || f.get("WALKABLE") != walkable)
					continue;
				int x = f.get("X");
				int y = f.get("Y");
				float distance = Utilities.distance(xx, yy, x, y);
				boolean isObstruct = Utilities.isObstructed(x, y, xx, yy, hg.ge.pl.getMap());
				if(distance <= 30)
				{
				if((!isObstruct && (int) distance <= hg.ge.pl.get("SIGHT")) || f.get("DISCOVERED") == 1 )
					featureList.add(f);
					{
						if(isObstruct)
						{
							f.set("OBSTRUCT",1);
						}
						else
						{
							f.set("OBSTRUCT",0);
				
						}

			 }
				
				}
		
	}
	}
}

Collections.sort(featureList, new FeatureComparator());
for(Feature fe : featureList)
{
	drawFeature(fe);
}


}


class FeatureComparator implements Comparator<Feature>
{
    public int compare(Feature a, Feature b)
    {
    int ay = a.get("Y");
	int by = b.get("Y");
	int ax = a.get("X");
	int bx = b.get("X");
	
	if (ay < by)
		return -1;
	if (ay == by)
		if (ax < bx)
			return -1;
		else
			return 1;
	if (ay > by)
		return 1;
	
	return 0;
}
    
}

private void renderPrompt() {

	if (activePrompt != null)
	{
		activePrompt.renderPrompt();
	}
}

@Override
public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
		throws SlickException {
	this.statechange(arg1);
	Player tmp = ge.getPlayer();
	Map m = tmp.getMap();
	this.message = tmp.getMessage();
	
	if(activeTargetting)
	{
		hg.targetctrl.updateArea(m);
	}
	
	if (moving != 0)
	{
	long now = System.currentTimeMillis();
	long diff = now - oldtime;

	if (diff > 50)
	{
		if (this.moveflag != 0 && this.moveflag != 5)
		{
			tmp.setAction(new Move(tmp,moveflag));

			this.inputACTION = 1;
		}
		if (this.moveflag == 5)
		{
			tmp.setAction(new Wait(1000,tmp));
			this.inputACTION = 1;
		}
		oldtime = now;
	
		}
		
	}
	if (this.inputACTION == 1)
			{
		
		this.inputACTION = 0;
		ge.TURN();

			}
	
}

@Override
public int getID() {
	// TODO Auto-generated method stub
	return stateID;
}

public void mouseWheelMoved(int change) 
{

}

public void mouseClicked(int button, int x,int y, int count)
{

}
public void mouseReleased(int button, int x, int y)
{
	if(!activeTargetting)
		hg.keyctrl.mouseReleased( button,  x,  y);
	else
		hg.targetctrl.mouseReleased(button,x,y);
		
	
}

public void mousePressed(int button, int x, int y)
{
	if(!activeTargetting)
		hg.keyctrl.mousePressed( button,  x,  y);
	else
		hg.targetctrl.mousePressed( button,  x,  y);

}

public void keyPressed(int key, char c)
{
	if(!activeTargetting)
		hg.keyctrl.keyPressed(key, c);
	else
		hg.targetctrl.keyPressed(key, c);

}

public void keyReleased(int key, char c)
{
	if(!activeTargetting)
		hg.keyctrl.keyReleased(key, c);
	else
		hg.targetctrl.keyReleased(key, c);


}

public void setPrompt(Prompt p) {

	moving = 0;
	activePrompt = p;
	if(p!=null)
		p.hg = hg;
}

}
