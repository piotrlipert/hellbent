package hellbent.states;

import hellbent.HellbentGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class InventoryState extends HBGameState {

	private HellbentGame hg;
	private Image background;

	public InventoryState(int inventorystate, HellbentGame hellbentGame) {
		this.setStateID(inventorystate);
		this.hg = hellbentGame;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		background = new Image("resources/graphics/menus/inventory.jpg");
		hg.invkeyctrl.setIs(this);
	
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
	public void mouseClicked(int button, int x, int y, int count) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
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
	}

}
