package hellbent.states;

import hellbent.loaders.BackgroundLoader;
import hellbent.loaders.ClassLoader;
import hellbent.loaders.ItemLoader;
import hellbent.loaders.MapLoader;
import hellbent.loaders.MonsterLoader;
import hellbent.loaders.RaceLoader;
import hellbent.util.StateButton;
import hellbent.HellbentGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;
import java.util.Vector;


public class GameMenuState extends HBGameState {
    Image background = null;
    Vector <StateButton> buttons = new Vector <StateButton>();
    
    UnicodeFont fontNITE;
    UnicodeFont fontDAY;
    HellbentGame s = null;
	private int stateID;

	public GameMenuState(int mainmenustate, HellbentGame s) {
		this.stateID = mainmenustate;
		this.s = null;
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

		HellbentGame hg = (HellbentGame) arg1;
			
		  hg.cll = new ClassLoader();
		  hg.itl = new ItemLoader();
		  hg.mal = new MapLoader();
		  hg.mol = new MonsterLoader();
		  hg.ral = new RaceLoader();
		  hg.bal= new BackgroundLoader();
		
		StateButton charGen = new StateButton(500,60,200,50,2,s);
		buttons.add(charGen);
		StateButton load = new StateButton(100,100,200,50,3,s);
		buttons.add(load);
		background = new Image("resources/back.jpg");
		
		
		
		  fontNITE = new UnicodeFont("resources/NITEMARE.ttf",24, false, false);
		  fontDAY = new UnicodeFont("resources/dc_s.ttf",24, false, false);

		
		 fontNITE.addAsciiGlyphs();   
		 fontNITE.addGlyphs(400, 600); 
		 fontNITE.getEffects().add(new ColorEffect(java.awt.Color.BLACK)); 
		 fontNITE.loadGlyphs(); 

		 fontDAY.addAsciiGlyphs();   
		 fontDAY.addGlyphs(400, 600); 
		 fontDAY.getEffects().add(new ColorEffect(java.awt.Color.BLACK)); 
		 fontDAY.loadGlyphs(); 
		// TODO Auto-generated method stub
		hg.fontNITE = fontNITE;
		hg.fontDAY = fontDAY;
	}
	

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)
			throws SlickException {
		background.draw(0, 0);
		HellbentGame hg = (HellbentGame) s;
		
		
		
	
		fontDAY.drawString(300, 300, "FONTY kurcze");
		fontNITE.drawString(500, 500, "LOL rotflmao");
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		this.statechange(arg1);
		Input input = gc.getInput();
		 
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
       /* for(StateButton b:buttons)
        	if (b.isInBox(mouseX, mouseY))
        		System.out.println("Myszka jest tu");
        	else
        		System.out.println("Myszka jest tam");
		*/
		// TODO Auto-generated method stub
		
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
		if (button == 0)
		{
			for (StateButton b : this.buttons)
			{
			if (b.isInBox(x, y))
			{
				this.statechange = b.stateID;
				b.Clicked();
			}
			}
		}
	}
	
	public void mouseReleased(int button, int x, int y)
	{
		
		
	}
	
	public void keyPressed(int key, char c)
	{
	    System.out.println(c);

	}
	
	public void keyReleased(int key, char c)
	{
		
	}
	
}
