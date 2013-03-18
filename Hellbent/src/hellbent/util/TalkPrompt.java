package hellbent.util;

import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.TalkOption;
import hellbent.concepts.TalkState;
import hellbent.entity.Entity;
import hellbent.states.GameplayState;

public class TalkPrompt extends Prompt {

	TalkState activeState = null;
	HashMap<String, TalkState> talkstates = new HashMap<String,TalkState>();
	HashMap<String,TalkOption> talkOptions = new HashMap<String,TalkOption>();
	Entity chatter = null;
	boolean isEscapable = true;
	private Vector<TalkOption> visibleOptions = new Vector<TalkOption>();

	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		super.keyPressed(key, c);
		if (key == Input.KEY_ESCAPE)
		{
			if (isEscapable)
				Exit();
		}
	}

	public void Exit()
	{
		GameplayState gs = (GameplayState) hg.getState(HellbentGame.GAMEPLAYSTATE);
		gs.setPrompt(null);
	}
	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		super.keyReleased(key, c);
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		super.mouseReleased(button, x, y);
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		super.mousePressed(button, x, y);
		
		if (button == Input.MOUSE_LEFT_BUTTON)
		{

			if(Utilities.isInRect(x, y, sx, sy, this.x, this.y))
			{

			TalkOption t = getVisibleTalkOption(x,y);
			if (t != null)
			{
			t.onTalk(hg.ge.pl);
			activeState.setResponse(t.getResponseText());
			if (t.getStateGoTo() != null)
				activeState = talkstates.get(t.getStateGoTo());
			
			if (t.getStateGoTo() == "END")
			{
				
			Exit();
			}
			}
			
			}
		}
		
	}

	private TalkOption getVisibleTalkOption(int xx, int yy) {
		int how_many = visibleOptions.size();
		
		yy =  yy - y;
		if (yy < 100)
			return null;
		int index = ((yy - 100) / 50);
		System.out.println(index);

		if (index+1 > how_many)
			return null;
		else
		{
			System.out.println("ASD");
			return visibleOptions.get(index);
			
		}
	}

	@Override
	public void renderPrompt() {
		// TODO Auto-generated method stub
		super.renderPrompt();
		renderChatterImage();
		renderTalkOptions();
		renderResponse();
		
	}

	private void renderChatterImage() {
		// TODO Auto-generated method stub
		
	}

	private void renderTalkOptions() 
	{
		int x = 0;
		visibleOptions = new Vector<TalkOption>();
		for (TalkOption t : activeState.options)
		{
			if (t.available(hg.ge.pl, chatter))
			{
				visibleOptions.add(t);
				String opt = t.getQueryText();
				hg.fontNITE.drawString(this.x + 30, (this.y+100) + (50 * x), opt,Color.blue);
				x++;
			}
		}
	}

	private void renderResponse() 
	{
		String opt = activeState.getResponse();
		hg.fontNITE.drawString(this.x + 30,  y+10, opt,Color.blue);

	}

	public TalkPrompt(int size, HashMap<String,TalkState> talkstate,
			HellbentGame hg, Entity e) throws SlickException 
	{
	super(size,hg);
	chatter = e;
	talkstates = talkstate;
	activeState = talkstate.get("START");
	
	}

}
