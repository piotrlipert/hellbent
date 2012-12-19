package hellbent.concepts;

import hellbent.entity.Player;

import java.util.List;

public interface Race {
	
	
	List<Item> StartingItems(String birthsign);
	void ModAttributes(Player p);
	void InitRace(Player p);
	void InitPowers(Player p);
	void InitSkills(Player p);


}
