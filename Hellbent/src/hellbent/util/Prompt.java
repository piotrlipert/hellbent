package hellbent.util;

import java.util.Vector;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;

public class Prompt 
{
	
	public HellbentGame hg; 
	int sx;
	int sy;
	int x;
	int y;
	Image back;
	
	Vector<Button> buttons;
	public Prompt(int size,HellbentGame h) throws SlickException
	{

		switch(size)
		{
		case Formulas.LARGEPROMPT:
		sx = 950;
		sy = 600;
		back = new Image("resources/graphics/menus/popup_large.png");
		break;
		
		case Formulas.MIDPROMPT:
		sx = 520;
		sy = 325;
		back = new Image("resources/graphics/menus/popup_med.png");

		break;
			
		case Formulas.SMALLPROMPT:
		sx = 273;
		sy = 173;
		back = new Image("resources/graphics/menus/popup_small.png");

		break;
		}
		
		buttons = new Vector<Button>();
		x = (Formulas.MAPRESX - sx)/2;
		y = (Formulas.MAPRESY - sy)/2;
		hg = h;
	}
	
	public Prompt(HellbentGame hg) {
		// TODO Auto-generated constructor stub
	}

	public void keyPressed(int key, char c) {
		
	}

	public void keyReleased(int key, char c) {

	
		}
	

	public void mouseReleased(int button, int x, int y) 
	{
		

	}
	
	public void mousePressed(int button, int x, int y) 
	{
		
		
	}


	public void renderPrompt()
	{
		back.draw(x,y);
		
	}
	
}
