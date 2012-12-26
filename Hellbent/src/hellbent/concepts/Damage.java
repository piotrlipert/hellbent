package hellbent.concepts;

import hellbent.entity.Entity;

public class Damage {
	
	private int amount;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	void addEffect(Entity e)
	{
		
	}

}
