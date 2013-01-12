package hellbent.util;

import java.io.IOException;

import org.newdawn.slick.Input;

import hellbent.HellbentGame;
import hellbent.states.GameplayState;

public class GameplayControl {

	private GameplayState gs;
	HellbentGame hg;
	static int SAVE_KEY;
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

	}

	public void loadKeyConfig() {

	}

	public String saveKeyConfig() {
		return "";

	}

	public void KeyBindings() {

	}

	public void keyPressed(int key, char c) {

		if (key == INVENTORY_KEY) {
			System.out.println("HEJHP");
			gs.statechange = HellbentGame.INVENTORYSTATE;
		}

		if (key == SAVE_KEY) {
			if (hg.in.isKeyDown(Input.KEY_LSHIFT)) {
				System.out.println("SAVING");
				try {
					hg.svg.saveGame("saves/" + hg.ge.pl.getName() + ".svg");
					hg.ge.pl.addMessage("Game saved.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
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

	public void keyReleased(int key, char c) {

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

}
