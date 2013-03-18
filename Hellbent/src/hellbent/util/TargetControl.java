package hellbent.util;

import java.util.Vector;

import org.newdawn.slick.Input;
import hellbent.HellbentGame;
import hellbent.concepts.Feature;
import hellbent.entity.Entity;
import hellbent.states.GameplayState;
import hellbent.world.Map;

public class TargetControl {

	private GameplayState gs;
	HellbentGame hg;
	private Targetter tar = null;
	static int CANCEL_KEY;

	public TargetControl(HellbentGame hg) {
		this.hg = hg;
		initConfig();
	}

	public void initTargetting(Targetter t)
	{
		tar = t;
		gs.activeTargetting = true;
		gs.EntityTargets = new Vector<Entity>();
		gs.FeatureTargets = new Vector<Feature>();
		gs.TileTargets = new Vector<int[] >();
		hg.getContainer().setMouseGrabbed(true);

 	}
	
	
	public void endTargetting()
	{
		gs.activeTargetting = false;
		hg.getContainer().setMouseGrabbed(false);

	}
	
	public void initConfig() {
		CANCEL_KEY = Input.KEY_ESCAPE;


	}

	public void loadKeyConfig() {

	}

	public String saveKeyConfig() {
		return "";

	}

	public void KeyBindings() {

	}

	public void keyPressed(int key, char c) 
	{
		if (key == CANCEL_KEY)
			endTargetting();
	}


	
	
	

	public void keyReleased(int key, char c) {

	
	}

	public GameplayState getGs() {
		return gs;
	}

	public void setGs(GameplayState gs) {
		this.gs = gs;
	}

	public void mouseReleased(int button, int x, int y) 
	{
	
		
	}

	public void mousePressed(int button, int x, int y) 
	{
		
		gs.getCoordAtMouseClick(x, y);
	}

	public void renderTargetter() 
	{		
		
		tar.render(gs);
	    
	
	    
	    
	}

	public void updateArea(Map m)
	{
		
		int x = hg.in.getMouseX();
	    int y = hg.in.getMouseY();
		int p[] = gs.getCoordAtMouseClick(x, y);
		
		tar.getArea(p[0], p[1], m);
		
	}
}
