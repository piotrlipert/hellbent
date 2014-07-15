package hellbent.util;

import java.io.IOException;
import java.util.Vector;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.content.actions.Pickup;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.states.GameplayState;
import hellbent.world.Map;

public class GameplayControl {

	private GameplayState gs;
	HellbentGame hg;
	static int TALK_KEY;
	static int SAVE_KEY;
	static int SKILL_KEY;
	static int SHOOT_KEY;

	
	static int N_1;
	static int N_2;
	static int N_3;
	static int N_4;
	static int N_5;
	static int N_6;
	static int N_7;
	static int N_8;
	static int N_9;
	static int N_0;
	static int INVENTORY_KEY;
	static int PICKUP_KEY;
	static int ENTER_KEY;

	public GameplayControl(HellbentGame hg) {
		this.hg = hg;
		initConfig();
	}

	public void initConfig() {
		SAVE_KEY = Input.KEY_S;
		N_1 = Input.KEY_NUMPAD1;
		N_2 = Input.KEY_NUMPAD2;
		N_3 = Input.KEY_NUMPAD3;
		N_4 = Input.KEY_NUMPAD4;
		N_5 = Input.KEY_NUMPAD5;
		N_6 = Input.KEY_NUMPAD6;
		N_7 = Input.KEY_NUMPAD7;
		N_8 = Input.KEY_NUMPAD8;
		N_9 = Input.KEY_NUMPAD9;
		N_0 = Input.KEY_NUMPAD0;
		INVENTORY_KEY = Input.KEY_I;
		PICKUP_KEY = Input.KEY_COMMA;
		SKILL_KEY = Input.KEY_S;
		TALK_KEY = Input.KEY_C;
		SHOOT_KEY = Input.KEY_T;
		ENTER_KEY = Input.KEY_TAB;
	}

	public void loadKeyConfig() {

	}

	public String saveKeyConfig() {
		return "";

	}

	public void KeyBindings() {

	}

	public void keyPressed(int key, char c) {

		if (gs.activePrompt != null)
		{
			gs.activePrompt.keyPressed(key, c);
			return;
		}
		
		if (key == ENTER_KEY)
		{
			
			Player tmp = hg.ge.pl;
			Map m = tmp.getMap();
			int x = tmp.getX();
			int y = tmp.getY();
			
			m.Enter(x, y, tmp);
			
			

			
		}
		
		if (key == SHOOT_KEY)
		{
			hg.targetctrl.initTargetting(new LineTargetter(hg));
			
			
		}
		if (key == SKILL_KEY && !hg.in.isKeyDown(Input.KEY_LSHIFT) ) 
		{
			gs.statechange = HellbentGame.SKILLSTATE;
			gs.moving = 0;

		}

		if (key == TALK_KEY)
		{
			initTalk();
		}
		
		if (key == PICKUP_KEY) 
		{
			

			Player tmp = hg.ge.pl;
			Map m = tmp.getMap();
			Vector<Item> items = Utilities.getItemsAtCoord(m, tmp.getX(), tmp.getY());
			if(items.size()> 0)
			{
				tmp.setAction(new Pickup(tmp, items.get(0)));
				((GameplayState) (gs)).inputACTION = 1;

				
			}
			else
			{
				tmp.addMessage("There is nothing here to pick up!");
			}
			
		}

		
		if (key == INVENTORY_KEY) {
			gs.statechange = HellbentGame.INVENTORYSTATE;
			gs.moving = 0;

		}

		if (key == SAVE_KEY) {
			if (hg.in.isKeyDown(Input.KEY_LSHIFT)) {
				try {
					gs.moving = 0;

					hg.svg.saveGame("saves/" + hg.ge.pl.getName() + ".svg");
					hg.ge.pl.addMessage("Game saved.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("DUPA");
				}
			}

		}

		if (key == N_1) {
			gs.moveflag = 1;
			gs.moving++;
		}
		if (key == N_2) {
			gs.moveflag = 2;
			gs.moving++;

		}
		if (key == N_3) {
			gs.moveflag = 3;
			gs.moving++;

		}
		if (key == N_4) {
			gs.moveflag = 4;
			gs.moving++;

		}
		if (key == N_5) {
			gs.moveflag = 5;
			gs.moving++;

		}
		if (key == N_6) {
			gs.moveflag = 6;
			gs.moving++;

		}
		if (key == N_7) {
			gs.moveflag = 7;
			gs.moving++;

		}
		if (key == N_8) {
			gs.moveflag = 8;
			gs.moving++;

		}
		if (key == N_9) {
			gs.moveflag = 9;
			gs.moving++;

		}

		{

		}
	}

	private void initTalk() 
	{
	// TODO dodaæ celowanie!
	Player tmp = hg.ge.pl;
	
	for(Entity e : hg.ge.pl.getMap().entities)
	{
		if (e.getType().equals( "Player"))
			continue;
		if(Utilities.distance(e.getX(), e.getY(), tmp.getX(), tmp.getY()) < 2)
		{
			if(e.isTalkable())
			{
			Talk(e);			
			break;
		
			
		
			}
		}
	}
	
	
	}

	private void Talk(Entity e) 
	{

	TalkPrompt t = null;
	try {
		t = new TalkPrompt(Formulas.MIDPROMPT,e.getTalkstate(),hg,e);
	} catch (SlickException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	gs.setPrompt(t);
	
	
	}

	public void keyReleased(int key, char c) {

		if (gs.activePrompt != null)
		{
			gs.activePrompt.keyReleased(key, c);
			return;
		}
		
		if (key == N_1) {
			gs.moving--;

		}
		if (key == N_2) {
			gs.moving--;
		}
		if (key == N_3) {
			gs.moving--;

		}
		if (key == N_4) {
			gs.moving--;

		}
		if (key == N_5) {
			gs.moving--;

		}
		if (key == N_6) {
			gs.moving--;

		}
		if (key == N_7) {
			gs.moving--;

		}
		if (key == N_8) {
			gs.moving--;

		}
		if (key == N_9) {
			gs.moving--;

		}
	}

	public GameplayState getGs() {
		return gs;
	}

	public void setGs(GameplayState gs) {
		this.gs = gs;
	}

	public void mouseReleased(int button, int x, int y) 
	{
		if (gs.activePrompt != null)
		{
			gs.activePrompt.mouseReleased(button, x, y);
			return;
		}
		
	}

	public void mousePressed(int button, int x, int y) {
		if (gs.activePrompt != null)
		{
			gs.activePrompt.mousePressed(button, x, y);
			return;
		}
		
	}

}
