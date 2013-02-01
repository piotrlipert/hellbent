package hellbent.states;

import java.util.Random;
import java.util.Vector;

import hellbent.HellbentGame;
import hellbent.concepts.GameEngine;
import hellbent.concepts.Item;
import hellbent.content.actions.Move;
import hellbent.content.actions.Wait;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.util.Utilities;
import hellbent.world.Map;

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
	boolean activePrompt = false;
	boolean activeTargetting = false;
    long oldtime = 0;
    Image background;
    Random rnd = new Random();
    int centerX;
    int centerY;
    boolean stillcenter = true;
    public String message = " ";
    public static final int LEFTBORDER = 35;
    public static final int UPBORDER = 30;
    public static final int MIDDLEX = 13;
    public static final int MIDDLEY = 10;
    public static final int TILESIZE = 32;
    
    

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

public int[] translateCoord(int x, int y,int centerx, int centery)
{
	int coord[] = new int[2];
	
	coord[0] = (x+MIDDLEX-centerx)*TILESIZE + LEFTBORDER;
	coord[1] = (y+MIDDLEY-centery)*TILESIZE + UPBORDER;
		
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
		hg.fontDAY.drawString(30, 30, mess);
	
}

public void renderMAP(HellbentGame hg, Map m) throws SlickException
{	
	
	Player tmp = hg.ge.getPlayer();
	
	centerX = tmp.getX();
	centerY = tmp.getY();
	boolean r = false;
	int xx = 0;
	Vector<Image> i;
	Vector<int[]> vis = Utilities.getVisibleTiles(tmp);
	System.out.println(vis.size());
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
				i = (hg.bal.BackgroundTiles.get(m.background[x][y]));

			}
			else
			{
			
			 i = (hg.bal.BackgroundTiles.get(m.background[0][0]));

			}
			Image d = i.get(0);
			
			if (!r)
			{
				
				int[] h = new int[2];
				h[0] = x;
				h[1] = y;
				double distance = Utilities.Ddistance(tmp.getX(), tmp.getY(), x, y);
				float brightness = (float) (1 - 0.05 * (distance - tmp.get("SIGHT")) - Math.signum(distance - tmp.get("SIGHT"))* 0.04); 
				//float brightness = 0.5F;
				
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

	rendermessage(hg);
	
	if (activePrompt)
	{
		renderPrompt();
	}
	/* TEST
	 * renderlines(hg,arg2);
	 */
	
	
	
}



private void renderPrompt() {
	// TODO Auto-generated method stub
	
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

	if (diff > 100)
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
	
	
}

public void keyPressed(int key, char c)
{
	
	hg.keyctrl.keyPressed(key, c);
	

}

public void keyReleased(int key, char c)
{
	hg.keyctrl.keyReleased(key, c);


}

}
