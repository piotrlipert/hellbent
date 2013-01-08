package hellbent.states;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Vector;

import hellbent.HellbentGame;
import hellbent.concepts.Background;
import hellbent.concepts.GameEngine;
import hellbent.content.actions.Move;
import hellbent.content.actions.Wait;
import hellbent.content.maps.GoblinTowerMap;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.util.Utilities;
import hellbent.world.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends HBGameState {
	
	private int stateID;
	public int moveflag = 0;
	int moving = 0;
    HellbentGame hg = null;
    GameEngine ge = null;
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
	  
}

@Override
public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
	hg = (HellbentGame) arg1;
	ge = hg.ge;
	background = new Image("resources/graphics/backgrounds/back.png");
	
	
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

public void renderMAP(HellbentGame hg, Map m)
{	
	
	Player tmp = hg.ge.getPlayer();
	
	centerX = tmp.getX();
	centerY = tmp.getY();
	boolean r = false;
	int xx = 0;
	Vector<Image> i;
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
			System.out.println(m.background[0][0]);
			Image d = i.get(0);
			
			
			if (!r)
			{
				if (m.visited[x][y] == 1)
					d.draw(LEFTBORDER + xx*TILESIZE,UPBORDER + yy*TILESIZE);
		
			}
			else
			{
				d.draw(LEFTBORDER + xx*TILESIZE,UPBORDER + yy*TILESIZE);

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
public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
		throws SlickException {
	
	HellbentGame hg = (HellbentGame) arg1;
	background.draw(0,0);

	renderMAP(hg,hg.ge.w.getMap(hg.ge.pl.getMapID()));
	renderPlayer(hg);
	renderEntities(hg);
	rendermessage(hg);
	/* TEST
	 * renderlines(hg,arg2);
	 */
	
	
	
}



@Override
public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
		throws SlickException {
	
	int inputACTION = 0;
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
			inputACTION = 1;
		}
		if (this.moveflag == 5)
		{
			tmp.setAction(new Wait(1000,tmp));
			inputACTION = 1;
		}
		oldtime = now;
	
		}
		

	if (inputACTION == 1)
			{
		ge.TURN();

			}
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
	
	if (key == Input.KEY_S)
	{
		if (hg.in.isKeyDown(Input.KEY_LSHIFT))
		{
			System.out.println("SAVING");
			try {
				hg.svg.saveGame("saves/"+hg.ge.pl.getName()+".svg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
		}
		
		
	}
	
	if (key == Input.KEY_NUMPAD1)
	{
	moveflag = 1;
	moving++;
	}
	if (key == Input.KEY_NUMPAD2)
	{
	moveflag = 2;
	moving++;

	}
	if (key == Input.KEY_NUMPAD3)
	{
	moveflag = 3;
	moving++;

	}
	if (key == Input.KEY_NUMPAD4)
	{
	moveflag = 4;
	moving++;

	}
	if (key == Input.KEY_NUMPAD5)
	{
	moveflag = 5;
	moving++;

	}
	if (key == Input.KEY_NUMPAD6)
	{
	moveflag = 6;
	moving++;

	}
	if (key == Input.KEY_NUMPAD7)
	{
	moveflag = 7;
	moving++;

	}
	if (key == Input.KEY_NUMPAD8)
	{
	moveflag = 8;
	moving++;

	}
	if (key == Input.KEY_NUMPAD9)
	{
	moveflag = 9;
	moving++;

	}
	
{
	
}
}

public void keyReleased(int key, char c)
{
	
	if (key == Input.KEY_NUMPAD1)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD2)
	{
	moving--;
	}
	if (key == Input.KEY_NUMPAD3)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD4)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD5)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD6)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD7)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD8)
	{
	moving--;

	}
	if (key == Input.KEY_NUMPAD9)
	{
	moving--;

	}
}

}
