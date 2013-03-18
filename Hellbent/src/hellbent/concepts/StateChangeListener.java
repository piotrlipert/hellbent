package hellbent.concepts;

import hellbent.entity.Entity;

public class StateChangeListener {
	
	Entity e;
	StateChangeListener(Entity en)
	{
		e = en;
	}
	
	public void onDamage(Damage d)
	{
		
	}
	
	public void onSpell(Spell s)
	{
		
	}
	
	public void onEffect(Effect e)
	{
		
	}
	
	public int modToHit(int to_hit)
	{
		return to_hit;
	
	}

}
