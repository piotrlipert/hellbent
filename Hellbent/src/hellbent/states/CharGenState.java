package hellbent.states;

import java.util.Vector;

import hellbent.HellbentGame;
import hellbent.concepts.GameEngine;
import hellbent.entity.Player;
import hellbent.util.StateButton;
import hellbent.world.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CharGenState extends HBGameState {
    Image background = null;
    HellbentGame hg = null;
    GameEngine ge = null;
	private int stateID;
	private int substateID;
    Vector <StateButton> buttons = new Vector <StateButton>();


	public CharGenState(int chargenstate, HellbentGame s) {
		this.stateID = chargenstate;
		this.hg = s;
		ge = this.hg.ge;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame s)
			throws SlickException {
		background = new Image("resources/graphics/menus/chargen.jpg");
		Image button = new Image("resources/graphics/menus/mainmenubutton.png");
		StateButton charGen = new StateButton(500,60,200,50,1,hg,button);
		buttons.add(charGen);
		Player tmp = new Player();
		
		tmp.setMapID("GoblinTower");
		tmp.setX(10);
		tmp.setY(10);
		tmp.set("SIGHT",5);
		tmp.set("Speed",500);
		tmp.set("MAX_CAPACITY",1000);
		tmp.setSprite(new Image("resources/graphics/entities/goblin.png"));
		tmp.sSet("SPRITEPATH","resources/graphics/entities/goblin.png");
		ge.setPlayer(tmp);
		
		Map i = hg.mal.getMap("GoblinTower");
		tmp.setMap(i);
		hg.ge.w.addMap(i);
		
		hg.ge.w.getMap("GoblinTower").entities.add(tmp);

		
		
		
	}
	

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		background.draw(0, 0);
		buttons.get(0).getButtonImage().draw(500,60);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		this.statechange(arg1);

		Input input = gc.getInput();
		 
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        
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
			}
			}
		}
	}
	public void mouseReleased(int button, int x, int y)
	{
		
		
	}
	
	public void keyPressed(int key, char c)
	{
		if (c == 'x')
		{
		Player tmp = ge.getPlayer();
		int i = tmp.get("cos");
		}
	
		if (c == 'z')
		{
		Player tmp = ge.getPlayer();
		int i = tmp.get("cos");
		}
	
	
	}
	
	public void keyReleased(int key, char c)
	{
		
	}

	public int getSubstateID() {
		return substateID;
	}

	public void setSubstateID(int substateID) {
		this.substateID = substateID;
	}
}
