package hellbent.content.npc;


import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;
import hellbent.concepts.TalkOption;
import hellbent.concepts.TalkState;
import hellbent.content.monsters.Affinity;
import hellbent.entity.Entity;
import hellbent.entity.Monster;

public class GoblinMiner extends Monster {
	
	public GoblinMiner(HellbentGame h)
	{
		super(h);
		this.setAwake(true);
		this.setName("giant rat");
		this.setType("GOBLIN_MINER");
		this.set("SEX",Formulas.MALE);
		this.set("Speed",0);
		this.set("AFFINITY",Affinity.GOBLINS);
		this.set("HPGROWTH",10);
		this.set("LEVEL",1);
		this.set("DAMAGE",5);
		this.set("SIGHTRANGE",5);
		Formulas.recalculateHP(this);
		this.set("CURR_HP", this.get("HP_MAX"));
		this.addTalkstate(new InitTalkState(), "START");
		this.addTalkstate(new QuestionsTalkState(), "QUESTIONS");
		

 
	}
	
	/*
	public Action AI(Map m)
	{
	if (this.getMap().entityAtCoord(this.getX()+1, this.getY())!= null)
		return new Move(this, 6);
	Random R = new Random();

	return new Move(this, R.nextInt(8)+1);
	}
*/
	public GoblinMiner clone()
	{
			return new GoblinMiner(hg);
		
	}
	
	
	
	
	class InitTalkState extends TalkState
	{
		public InitTalkState()
		{
		setStateId("START");
		setInitText("Good day!");
		addOption(new TalkOption("Hello", 
				"START", "Hello, who are you?", 
				"I am a goblin of course!",
				"QUESTIONS"));
		
		
		
		}
	}
	
	
	class QuestionsTalkState extends TalkState
	{
		public QuestionsTalkState()
		{
		setStateId("QUESTIONS");	
		setInitText("Do you have any questions?");
		addOption(new TalkOption("WHERE", 
				"QUESTIONS", "Where am I?", 
				"You're in the strange forest brother.",
				null));
		addOption(new TalkOption("WHO", 
				"QUESTIONS", "Who's in charge?", 
				"Domino's in charge here. But you'd better not talk to him straight." +
				"It's better to appeal to one of his goons first, else you can get your" +
				"head chopped off.",
				null));
		
		addOption(new TalkOption("END", 
				"QUESTIONS", "I'd better go.", 
				"Go in peace!",
				"END"));
		}
	}
	
	
	
	
	public boolean isTalkable() {
		return true;
		}
}
