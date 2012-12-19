package hellbent.content.classes;
import java.util.Vector;

import hellbent.concepts.Item;
import hellbent.concepts.Profession;
import hellbent.entity.Player;
public class BanditClass implements Profession {

	private String name;
	public BanditClass()
	{
		setName("Bandit");
		
	}
	public Vector<Item> StartingItems(String birthsign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ModAttributes(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitClass(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitPowers(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitSkills(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int HPperLevel() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int HPperV() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int HPperR() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int MPperLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int MPperR() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SPperLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SPperC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sAptitude(String skill) {
		if (skill == "MELEE")
			return 1;
		if (skill == "FISHING")
			return 1;
		
		return 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int MPperM() {
		// TODO Auto-generated method stub
		return 0;
	}

}
