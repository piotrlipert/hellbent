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
	boolean activeTargetting = false;
    long oldtime = 0;
    Image background;
    Random rnd = new Random();
    int centerX;
    int centerY;
    boolean stillcenter = true;
    public String message = " ";
    public static final int LEFTBORDER = 0;
    public static final int UPBORDER = 0;
    public static final int MIDDLEX = 13;
    public static final int MIDDLEY = 10;
    public static final int TILESIZE = 32;
    public Prompt activePrompt = null;
    

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
	
}




public void drawOnScreen(int x, int y, Image z)
{
	z.draw(LEFTBORDER+TILESIZE*(x+MIDDLEX),UPBORDER + TILESIZE * (y+MIDDLEY));
}

public int[] translateCoord(int x, int y)
{
	Player tmp = ge.pl;
	
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
	for(int x=centerX-13;x<centerX+14;x++)
	{
		for(int y=centerY-10;y<centerY+11;y++)
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
		drawOnScreen(e.getX()-centerX,e.getY()-centerY,e.getSprite());
	}
	
}

public void renderItems(HellbentGame hg)
{
	Player tmp = hg.ge.getPlayer();

	centerX = tmp.getX();
	centerY = tmp.getY();
	
	
	
	for (Item e : Utilities.getVisibleItems(tmp))
	{
		drawOnScreen(e.getX()-centerX,e.getY()-centerY,e.getSprite());
	}
	
}
public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
		throws SlickException {
	
	HellbentGame hg = (HellbentGame) arg1;
	background.draw(0,0);

	renderMAP(hg,hg.ge.w.getMap(hg.ge.pl.getMapID()));
	renderItems(hg);
	renderEntities(hg);

	renderPlayer(hg);
	renderSpecial(hg);

	rendermessage(hg);
	
	
	renderPrompt();
		/* TEST
	 * renderlines(hg,arg2);
	 */
	
	
	
}


private void drawFeature(Feature f)
{
	int x = f.get("X");
	int y = f.get("Y");
	int xx = hg.ge.pl.getX();
	int yy = hg.ge.pl.getY();
	float distance = Utilities.distance(xx, yy, x, y);
	
		int tra[] = translateCoord(x-xx, y-yy);
			
		int[] translated = Utilities.getDrawCoordForBigImages(f.getImage(), tra[0], tra[1]);
		if(tra[0]+f.getImage().getWidth()/2<TILESIZE*MIDDLEX*2 && tra[1]+f.getImage().getHeight()/2<TILESIZE*MIDDLEY*2)
		{
			float brightness = 1;

			if(distance >= hg.ge.pl.get("SIGHT"))
				{
			    brightness =  (brightness - ((float)(distance) - (float) (hg.ge.pl.get("SIGHT")))*0.08F);
				}
			if (f.get("OBSTRUCT") == 1)
				brightness = brightness/2;
			
			Image ic = f.getImage().copy();
			ic.setColor(0, brightness,brightness,brightness, brightness);
				ic.setColor(1, brightness,brightness,brightness, brightness);
				ic.setColor(2, brightness,brightness,brightness, brightness);
				ic.setColor(3, brightness,brightness,brightness, brightness);
			ic.draw(translated[0],translated[1]);
				
			
		
		
		}
			
	}
	



private void renderSpecial(HellbentGame hg2) 
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
				if (f == null)
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
	this.message = tmp.getMessage();
	
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
	hg.keyctrl.mouseReleased( button,  x,  y);

	
}

public void mousePressed(int button, int x, int y)
{
	hg.keyctrl.mousePressed( button,  x,  y);

	
}

public void keyPressed(int key, char c)
{
	
	hg.keyctrl.keyPressed(key, c);
	

}

public void keyReleased(int key, char c)
{
	hg.keyctrl.keyReleased(key, c);


}

public void setPrompt(Prompt p) {

	moving = 0;
	activePrompt = p;
	if(p!=null)
		p.hg = hg;
}

}
