package hellbent.content.actions;

import hellbent.concepts.Formulas;
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
		boolean hit = false;
		if (Formulas.hit(en,victim))
			hit = true;
		
		
		
			String attacked = victim.sGet("NAME");
			if(hit)
				en.addMessage("You hit "+ attacked + ".");
			else
				en.addMessage("You miss "+ attacked + ".");

			
		
		
			if(hit)
				victim.addMessage(en.sGet("NAME") + " hits you!");
			else
				victim.addMessage(en.sGet("NAME") + " misses you.");

		
	
	
	}
	
}
