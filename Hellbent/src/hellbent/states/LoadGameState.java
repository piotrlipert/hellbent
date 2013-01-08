package hellbent.states;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import hellbent.HellbentGame;
import hellbent.util.LoadButton;
import hellbent.util.Utilities;

public class LoadGameState extends HBGameState
{
    Image background = null;

	private int stateID;
	private HellbentGame hg;
	private Vector<LoadButton> loadbuttons = new Vector<LoadButton>();
	private Vector<Path> paths = new Vector<Path>();
	public LoadGameState(int loadgamestate, HellbentGame hg) throws SlickException 
	{
		

		this.stateID = loadgamestate;
		this.hg = hg;
		this.loadPaths();
		int i = 0;
		Image b = new Image("/resources/graphics/menus/loadmenubutton.jpg");
		for (Path s : paths)
		{
			LoadButton n = new LoadButton(100*i,100*i,100,100,hg, s,b);
			System.out.println(s.toString());
			n.setText(s.subpath(1,2).toString());
			
			loadbuttons.add(n);
			i++;
		}
		
		
	}

	
	private void loadPaths() 
	{
	paths = Utilities.listDir(Paths.get("saves"));
	
	}
	
	


	public int getID() {
		// TODO Auto-generated method stub
		return this.stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.init(container, game);
		
		background = new Image("resources/graphics/menus/loadmenu.jpg");

	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		this.statechange(game);

	}

	public void mouseWheelMoved(int change) {
	}

	public void mouseClicked(int button, int x, int y, int count) {
	
		if (button == 0)
		{
			for (LoadButton b : this.loadbuttons)
			{
			if (b.isInBox(x, y))
			{
				this.statechange = HellbentGame.GAMEPLAYSTATE;
				b.Clicked();
			}
			}
		}
	
	}

	public void mouseReleased(int button, int x, int y) {
	}

	public void keyPressed(int key, char c) {
	}

	public void keyReleased(int key, char c) {
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
	
		background.draw(0,0);
		
		
		for (LoadButton b : this.loadbuttons)
		{
		
			b.getButtonImage().draw(b.x,b.y);
			hg.fontDAY.drawString(b.x, b.y, b.getText());
	
		}
	}
	
	
	


}
