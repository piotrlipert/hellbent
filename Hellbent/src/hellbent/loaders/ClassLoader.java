package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Profession;
import hellbent.content.classes.BanditClass;

import java.util.Vector;

public class ClassLoader {
	
	Vector<Profession> classes = new Vector<Profession>();
	
	
	public ClassLoader(HellbentGame hg)
	{
		classes.add(new BanditClass());
	}
	
	
	}


