package hellbent.entity;

public class Monster extends Entity {

	public Monster()
	{
		this.setType("Monster");
		
	}
	
	
	public Monster clone()
	{
		return new Monster();
	}
}
