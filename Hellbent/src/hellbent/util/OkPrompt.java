package hellbent.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.states.GameplayState;

public class OkPrompt extends Prompt {

	
	private String text;
	private String oktext;
	OkButton ok;
	public OkPrompt(int size, HellbentGame hg) throws SlickException 
	{
		super(size, hg);
		 ok = new OkButton(x+(sx/2)-75, y+sy-60, 150, 50, new Image("resources/graphics/prompts/promptbutton.png"),this);
		
	
	}
	
	
	public String getOktext() {
		return oktext;
	}
	public void setOktext(String oktext) {
		this.oktext = oktext;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void renderPrompt()
	{
		super.renderPrompt();
		
		ok.getButtonImage().draw(ok.x,ok.y);
		
	}

	public void mousePressed(int button, int x, int y)
	{
		
		if(Utilities.isInRect(x, y, ok.width, ok.height, ok.x, ok.y))
		{
			
			GameplayState gs = (GameplayState) hg.getState(HellbentGame.GAMEPLAYSTATE);
			
			gs.setPrompt(null);
			
		}
		
	}
	
}
