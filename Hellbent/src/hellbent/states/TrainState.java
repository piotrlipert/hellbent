package hellbent.states;

import hellbent.HellbentGame;
import hellbent.util.InventoryWidget;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TrainState extends HBGameState {

	private HellbentGame hg;
	private Image background;
	public InventoryWidget iw;
	
	public TrainState(int inventorystate, HellbentGame hellbentGame) {
		this.setStateID(inventorystate);
		this.hg = hellbentGame;
		iw = new InventoryWidget(hg);
	}
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		background = new Image("resources/graphics/menus/inventory.jpg");
	
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		this.statechange(game);
	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		hg.invkeyctrl.mousePressed(button,x,y);
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		hg.invkeyctrl.mouseReleased(button,x,y);
	}

	@Override
	public void keyPressed(int key, char c) {
		hg.invkeyctrl.keyPressed(key,c);
	}

	@Override
	public void keyReleased(int key, char c) {
		hg.invkeyctrl.keyReleased(key,c);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		background.draw(0,0);
		iw.renderItems(hg);
		
	
	}

	


}
