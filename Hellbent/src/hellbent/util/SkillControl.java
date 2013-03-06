package hellbent.util;

import java.io.IOException;
import java.util.Vector;

import org.newdawn.slick.Input;

import hellbent.HellbentGame;
import hellbent.concepts.Item;
import hellbent.content.actions.Pickup;
import hellbent.entity.Player;
import hellbent.states.GameplayState;
import hellbent.states.SkillState;
import hellbent.world.Map;

public class SkillControl {

	private SkillState gs;
	HellbentGame hg;
	private int ESCAPE_KEY;
	

	public SkillControl(HellbentGame hg) {
		this.hg = hg;
		initConfig();
	}

	public void initConfig() {
		
		ESCAPE_KEY = Input.KEY_ESCAPE;

	}

	public void loadKeyConfig() {

	}

	public String saveKeyConfig() {
		return "";

	}

	public void KeyBindings() {

	}

	public void keyPressed(int key, char c) {

		

	

		
		if (key == ESCAPE_KEY) {
			gs.statechange = HellbentGame.GAMEPLAYSTATE;
		}

	}

	public void keyReleased(int key, char c) 
	{

		
	}

	public SkillState getGs() {
		return gs;
	}

	public void setGs(SkillState skillState) {
		this.gs = skillState;
	}

	public void mousePressed(int button, int x, int y) 
	{		
		if(button == Input.MOUSE_LEFT_BUTTON)
		{
			if(gs.sw.isClickInCategories(x,y))
			{
				gs.sw.focusedCategory = gs.sw.getActiveCategory(x,y);
			}
			
			if (gs.sw.isClickInSkills(x,y))
			{
				gs.sw.focusedSkill = gs.sw.getSkillAt(x, y);
			}
			
		}
	}

	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
