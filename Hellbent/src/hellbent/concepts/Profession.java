package hellbent.concepts;

import hellbent.entity.Player;

import java.util.List;

public interface Profession {

	/* 
	 * V - Vigor
	 * R - Resolve
	 * C - Cunning
	 * D - Dexterity
	 * S - Strength
	 * P - Perception
	 * I - Influence
	 * M - Mana
	
	*/
	List<Item> StartingItems(String birthsign);
	void ModAttributes(Player p);
	void InitClass(Player p);
	void InitPowers(Player p);
	void InitSkills(Player p);
	
	// Health points.
	int HPperLevel();
	int HPperV();
	int HPperR();
	
	// Mana points.
	int MPperLevel();
	int MPperR();
	int MPperM();

	// Skill points.
	int SPperLevel();
	int SPperC();
	
	int sAptitude(String skill);
	
		
	


}
