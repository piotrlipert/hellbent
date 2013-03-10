package hellbent;


import hellbent.concepts.Formulas;
import hellbent.concepts.GameEngine;
import hellbent.loaders.BackgroundLoader;
import hellbent.loaders.EventLoader;
import hellbent.loaders.FeatureLoader;
import hellbent.loaders.ItemLoader;
import hellbent.loaders.MapLoader;
import hellbent.loaders.MonsterLoader;
import hellbent.loaders.RaceLoader;
import hellbent.loaders.SaveLoader;
import hellbent.loaders.Saver;
import hellbent.loaders.TrapLoader;
import hellbent.states.CharGenState;
import hellbent.states.GameMenuState;
import hellbent.states.GameplayState;
import hellbent.states.InventoryState;
import hellbent.states.LoadGameState;
import hellbent.states.SkillState;
import hellbent.util.GameplayControl;
import hellbent.util.InventoryControl;
import hellbent.util.SkillControl;
import hellbent.util.TargetControl;
import hellbent.loaders.ClassLoader;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
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
    
    public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;
	public static final int CHARGENSTATE = 2;
	public static final int LOADGAMESTATE = 3;
	public static final int INVENTORYSTATE = 4;
	public static final int SKILLSTATE = 5;

	public int TILESIZE;
	public int XWINDOW;
	public int YWINDOW;
	
	public UnicodeFont fontNITE;
    public UnicodeFont fontDAY;
    public UnicodeFont fontTalk;
    public UnicodeFont fontCommon;

    public UnicodeFont fontSpecial;

    UnicodeFont fontNORM;
	public SaveLoader load;
	public Saver svg;
	public Input in;
	public GameplayControl keyctrl;
	public InventoryControl invkeyctrl;
	public SkillControl skillctrl;
	public TrapLoader trl;
	public EventLoader evl;
	public FeatureLoader ftl;
	public TargetControl targetctrl;
    

	public HellbentGame() throws SlickException {
		super("Hellbent");
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		
		this.addState(new GameMenuState(MAINMENUSTATE,this));
		this.addState(new GameplayState(GAMEPLAYSTATE,this));
        this.addState(new CharGenState(CHARGENSTATE,this));
        this.addState(new LoadGameState(LOADGAMESTATE,this));
        this.addState(new InventoryState(INVENTORYSTATE,this));
        this.addState(new SkillState(SKILLSTATE,this));

        
        
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
	
	public void mousePressed(int button, int x,int y)
	{
		GameState gs = this.getCurrentState();
		gs.mousePressed(button, x, y);
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

