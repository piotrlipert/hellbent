package hellbent;


import hellbent.concepts.Formulas;
import hellbent.loaders.BackgroundLoader;
import hellbent.loaders.ItemLoader;
import hellbent.loaders.MapLoader;
import hellbent.loaders.MonsterLoader;
import hellbent.loaders.RaceLoader;
import hellbent.states.CharGenState;
import hellbent.states.GameMenuState;
import hellbent.states.GameplayState;
import hellbent.loaders.ClassLoader;
import hellbent.util.GameEngine;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;


public class HellbentGame extends StateBasedGame
{
	
	public GameEngine ge;
    public ClassLoader cll;
    public ItemLoader itl;
    public MapLoader mal;
    public MonsterLoader mol;
    public RaceLoader ral;
    public BackgroundLoader bal;
    public Formulas f = new Formulas();
    
	private static final int MAINMENUSTATE = 0;
	private static final int GAMEPLAYSTATE = 1;
	private static final int CHARGENSTATE = 2;
	
	public int TILESIZE;
	public int XWINDOW;
	public int YWINDOW;
	
	public UnicodeFont fontNITE;
    public UnicodeFont fontDAY;
    UnicodeFont fontNORM;
    
	public UnicodeFont font;

	public HellbentGame() throws SlickException {
		super("Hellbent");


	ge = new GameEngine();
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		
		this.addState(new GameMenuState(MAINMENUSTATE,this));
		this.addState(new GameplayState(GAMEPLAYSTATE,this));
        this.addState(new CharGenState(CHARGENSTATE,this));

        
        
	}
	

	public void mouseWheelMoved(int change) 
	{
    GameState gs = this.getCurrentState();
    gs.mouseWheelMoved(change);
    
	}
	
	public void mouseClicked(int button, int x,int y, int count)
	{
		GameState gs = this.getCurrentState();
		gs.mouseClicked(button, x, y, count);
	}
	public void mouseReleased(int button, int x, int y)
	{
		GameState gs = this.getCurrentState();
		gs.mouseReleased(button, x, y);	
	}
	
	public void keyPressed(int key, char c)
	{
		GameState gs = this.getCurrentState();
		gs.keyPressed(key, c);
	}
	
	public void keyReleased(int key, char c)
	{
		GameState gs = this.getCurrentState();
	    gs.keyReleased(key, c);
	}


}

