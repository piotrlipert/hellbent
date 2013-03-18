package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Item;
import hellbent.concepts.Trap;
import java.util.HashMap;

public class TrapLoader 
{
	public HashMap<String,Trap> traps = new HashMap<String,Trap>();

	public TrapLoader(HellbentGame hg)
	{
		
		
		
		
	}

	public Trap getTrap(String name)
	{
		return (traps.get(name)).clone();
	}

}
