package hellbent.states;

import java.util.Vector;

import hellbent.HellbentGame;
import hellbent.concepts.GameEngine;
import hellbent.entity.Player;
import hellbent.util.StateButton;

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
		background = new Image("resources/back1.jpg");
		StateButton charGen = new StateButton(500,60,200,50,1,hg);
		buttons.add(charGen);
		Player tmp = new Player();
		
		tmp.setMapID("GoblinTower");
		tmp.setX(10);
		tmp.setY(10);
		tmp.set("SIGHT",5);
		tmp.set("Speed",500);
		tmp.setSprite(new Image("resources/entities/goblin.png"));
		ge.setPlayer(tmp);
		System.out.println("Chargenready!");
		tmp.setMap(hg.mal.maps.get("GoblinTower"));
		hg.mal.maps.get("GoblinTower").entities.add(tmp);

		
		
		
	}
	

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		background.draw(0, 0);
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
				System.out.println(this.statechange);
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
		tmp.set("cos",i+1);
		}
	
		if (c == 'z')
		{
		Player tmp = ge.getPlayer();
		int i = tmp.get("cos");
		System.out.println(i);
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
