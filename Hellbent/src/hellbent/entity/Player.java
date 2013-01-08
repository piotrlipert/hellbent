package hellbent.entity;

public class Player extends Entity {
	
	
	public Player()
	{
	this.setAwake(true);
	this.setType("Player");
	this.setName("ZIUTAS");
	}


	
	public String save()
	{
		String savestr = "<PLAYER>\n";
		savestr += this.saveTypeAndName();
		savestr += this.saveAttributes();
		savestr += this.saveEffects();
		savestr += this.saveItems();
		
		return savestr+"</PLAYER>\n";
	}
	
}
