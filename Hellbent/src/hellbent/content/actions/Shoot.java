package hellbent.content.actions;

import hellbent.concepts.Formulas;
import hellbent.concepts.Weapon;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.world.Map;


public class Shoot extends hellbent.concepts.Action {
	
	Entity victim;
	public Shoot(Entity attacker, Entity vict) {
		super(attacker);
		this.victim = vict;
	
		this.setInstant(true);
	}

	public void process(Map m)
	{
		String Reason = "";
		boolean hit = false;
		Weapon w = en.getMissileWeapon();
		if (Formulas.hit(en,victim,w))
			hit = true;
		else
			Reason = Formulas.missReason(victim);
			
		
			String attacked = victim.sGet("NAME");
			if(hit)
			{
				victim.addMessage(en.sGet("NAME") + " hits you!");
				int damage = Formulas.damage(en,victim,w);
				en.addMessage("You hit "+ attacked + " for "+Integer.toString(damage)+".");

				victim.sub("CURR_HP", damage);

				if (victim.get("CURR_HP") <= 0)
				{
					victim.die(en);
					en.addMessage("You killed "+ attacked + ".");

				}
			}
			else
			{
				en.addMessage("You miss "+ attacked + ".");
				victim.addMessage(en.sGet("NAME") + " misses you.");
				
			
			
			}
			
	
	}
	
}
