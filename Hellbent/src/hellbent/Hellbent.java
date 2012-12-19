package hellbent;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import hellbent.states.GameMenuState;
import hellbent.states.GameplayState;




public class Hellbent {

	public static void main(String args[]) throws SlickException
	{
	    AppGameContainer app = new AppGameContainer(new HellbentGame());
        app.setDisplayMode(1024, 768, true);
        app.setTargetFrameRate(120);
        app.start();
	}
}
