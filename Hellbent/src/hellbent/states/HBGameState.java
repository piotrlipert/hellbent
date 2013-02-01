package hellbent.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HBGameState extends BasicGameState {

	
	boolean SHIFT = false;
	boolean ALT = false;
	boolean CTRL = false;
	public int statechange = -1;
	private int stateID;
    
	
	@Override
	
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public void statechange(StateBasedGame s)
	{
		if (this.statechange != -1)
		{

			s.enterState(this.statechange);
			this.statechange = -1;
		}	
	}
	

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
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
		
	}
	
	public void keyReleased(int key, char c)
	{
		
	}

	

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

	public void mousePressed(int button, int x, int y, int count) {
		
	}
}
