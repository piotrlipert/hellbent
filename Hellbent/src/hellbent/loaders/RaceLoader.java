package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Race;
import hellbent.content.races.GoblinRace;

import java.util.Vector;

public class RaceLoader {
	
	private Vector<Race> races = new Vector<Race>();
	
	public RaceLoader(HellbentGame hg)
	{
		races.add(new GoblinRace());
	}

}
