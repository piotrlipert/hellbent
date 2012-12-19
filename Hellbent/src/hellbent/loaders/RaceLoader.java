package hellbent.loaders;

import hellbent.concepts.Race;
import hellbent.content.races.GoblinRace;

import java.util.Vector;

public class RaceLoader {
	
	private Vector<Race> races = new Vector<Race>();
	
	public RaceLoader()
	{
		races.add(new GoblinRace());
	}

}
