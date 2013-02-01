package hellbent.concepts;

import java.util.HashMap;
import java.util.Vector;

public class Damage {
	public HashMap<Integer,Integer> dam = new HashMap<Integer,Integer>();
	public Vector<Effect> eff = new  Vector<Effect>();

	
	public int getDamage(int type)
	{
		if(dam.keySet().contains(type))
			return dam.get(type);
		return 0;
	}
	public void setDamage(int type, int amount)
	{
		dam.put(type,amount);
	}
	
	
	public void addEffect(Effect e)
	{
		eff.add(e);
	}
	public Vector<Effect> getEffects()
	{
		return eff;
	}
	
	
	
}
