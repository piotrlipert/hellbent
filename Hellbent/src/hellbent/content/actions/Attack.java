package hellbent.content.actions;

import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.world.Map;


public class Attack extends hellbent.concepts.Action {
	
	Entity victim;
	public Attack(Entity attacker, Entity vict) {
		super(attacker);
		this.victim = vict;
	}

	public void process(Map m)
	{
		if (en.getType() == "Player")
		{
			Player tmp = (Player) en;
			String attacked = victim.sGet("NAME");
			tmp.addMessage("You attack "+ attacked + ".");
			
		}
		if (victim.getType() == "Player")
		{
			Player tmp = (Player) victim;
			tmp.addMessage("You are attacked "+ en.sGet("NAME"));
			
		}
	}
	
}
