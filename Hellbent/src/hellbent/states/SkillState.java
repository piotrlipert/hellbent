package hellbent.states;

import hellbent.HellbentGame;
import hellbent.util.InventoryWidget;
import hellbent.util.SkillWidget;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SkillState extends HBGameState {

	public HellbentGame hg;
	private Image background;
	public SkillWidget sw;
	
	public SkillState(int inventorystate, HellbentGame hellbentGame) {
		this.setStateID(inventorystate);
		this.hg = hellbentGame;
		try {
			sw = new SkillWidget(hg);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		background = new Image(1024,768);
		hg.skillctrl.setGs(this);
	
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
		hg.skillctrl.mousePressed(button,x,y);
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		hg.skillctrl.mouseReleased(button,x,y);
	}

	@Override
	public void keyPressed(int key, char c) {
		hg.skillctrl.keyPressed(key,c);
	}

	@Override
	public void keyReleased(int key, char c) {
		hg.skillctrl.keyReleased(key,c);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		background.draw(0,0);
		
		
		sw.renderCategories(hg);
		sw.renderSkills(hg);
		sw.renderDescription(hg);
		sw.renderSkillPoints(hg);
		sw.renderAbilities(hg);
		sw.renderScroller(hg);
		
		
	
	}

	


}
