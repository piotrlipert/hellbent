package hellbent.util;

import org.newdawn.slick.Input;

import hellbent.HellbentGame;
import hellbent.states.InventoryState;

public class InventoryControl {

	private InventoryState is;
	HellbentGame hg;
	
	public InventoryState getIs() {
		return is;
	}

	public void setIs(InventoryState is) {
		this.is = is;
	}

	static int EXIT_KEY;

	public InventoryControl(HellbentGame hg) {
		this.hg = hg;
		initConfig();
	}

	public void initConfig() {
		
		EXIT_KEY = Input.KEY_ESCAPE;

	}

	public void loadKeyConfig() {

	}

	public String saveKeyConfig() {
		return "";

	}

	public void KeyBindings() {

	}

	public void keyPressed(int key, char c) {

		if (key == EXIT_KEY) {
			is.statechange = HellbentGame.GAMEPLAYSTATE;
		}

		
	}

	public void keyReleased(int key, char c) {



		}
	}


