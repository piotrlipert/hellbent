package hellbent.entity;

import hellbent.HellbentGame;

public class Monster extends Entity {


	
	
	protected Monster(HellbentGame h) {
		super(h);
		this.setType("Monster");

	}

	public Monster clone()
	{
		return new Monster(hg);
	}

	public void addMessage()
	{
		
	}
}
