package hellbent.states;

import hellbent.loaders.BackgroundLoader;
import hellbent.loaders.ClassLoader;
import hellbent.loaders.EventLoader;
import hellbent.loaders.FeatureLoader;
import hellbent.loaders.ItemLoader;
import hellbent.loaders.MapLoader;
import hellbent.loaders.MonsterLoader;
import hellbent.loaders.RaceLoader;
import hellbent.loaders.SaveLoader;
import hellbent.loaders.Saver;
import hellbent.loaders.TrapLoader;
import hellbent.util.GameplayControl;
import hellbent.util.InventoryControl;
import hellbent.util.SkillControl;
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

import java.awt.Font;
import java.awt.GraphicsEnvironment;
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

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

		HellbentGame hg = (HellbentGame) arg1;
			
		  hg.cll = new ClassLoader(hg);
		  hg.itl = new ItemLoader(hg);
		  hg.mol = new MonsterLoader(hg);
		  hg.ral = new RaceLoader(hg);
		  hg.bal = new BackgroundLoader(hg);

		  hg.mal = new MapLoader(hg);

		  hg.ftl = new FeatureLoader(hg);
		  hg.trl = new TrapLoader(hg);
		  hg.evl = new EventLoader(hg);
		  
		  hg.svg = new Saver(hg);
		  hg.load = new SaveLoader(hg);
		  hg.in = hg.getContainer().getInput();
		  hg.keyctrl = new GameplayControl(hg);
		  hg.invkeyctrl = new InventoryControl(hg);
		  hg.skillctrl = new SkillControl(hg);
		  
		Image menubutton = new Image("resources/graphics/menus/mainmenubutton.png");
		StateButton charGen = new StateButton(700,100,200,50,2,s,menubutton);
		charGen.setText("Generate new character");
		buttons.add(charGen);
		
		StateButton load = new StateButton(700,200,200,50,3,s,menubutton);
		load.setText("Load game");
		buttons.add(load);
		
		StateButton options = new StateButton(700,300,200,50,3,s,menubutton);
		options.setText("Options");
		buttons.add(options);
		
		StateButton exit = new StateButton(700,400,200,50,3,s,menubutton);
		exit.setText("exit");
		buttons.add(exit);
		
		
		background = new Image("resources/graphics/menus/mainmenu.png");
		
		
		
		  fontNITE = new UnicodeFont("resources/graphics/NITEMARE.ttf",18, false, false);
		  fontDAY = new UnicodeFont("resources/graphics/dc_s.ttf",18, false, false);

		  
		  GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		  String []fontFamilies = ge.getAvailableFontFamilyNames();
		  	for(String i : fontFamilies)
		  	{
		  		System.out.println(i);
		  	}
		  
		  Font a = new Font("Palatino Linotype", 20, 1);
		  hg.fontCommon = new UnicodeFont(a,20, false,false);
		  hg.fontCommon.addAsciiGlyphs();   
		  hg.fontCommon.addGlyphs(400, 600); 
		  hg.fontCommon.getEffects().add(new ColorEffect(java.awt.Color.WHITE)); 
		  hg.fontCommon.loadGlyphs(); 
		  
		 fontNITE.addAsciiGlyphs();   
		 fontNITE.addGlyphs(400, 600); 
		 fontNITE.getEffects().add(new ColorEffect(java.awt.Color.WHITE)); 
		 fontNITE.loadGlyphs(); 
		 
		 Font f = new Font("Arial", 12, 12);
		 
		 hg.fontTalk = new UnicodeFont(f);

		 fontDAY.addAsciiGlyphs();   
		 fontDAY.addGlyphs(400, 600); 
		 fontDAY.getEffects().add(new ColorEffect(java.awt.Color.WHITE)); 
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
		
		
		for (StateButton b : this.buttons)
		{
		b.getButtonImage().draw(b.x,b.y);
		}
	
		//fontDAY.drawString(300, 300, "FONTY kurcze");
		//fontNITE.drawString(500, 500, "LOL rotflmao");
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		this.statechange(arg1);
		Input input = gc.getInput();
		 
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
       
		
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
