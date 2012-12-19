package hellbent.entity;

public class Player extends Entity {
	private String message;
	private boolean newmess = false;
	
	public Player()
	{
	this.setAwake(true);
	this.setType("Player");
	this.sSet("NAME","Player");

	}


	public String getMessage() {
		return message;
	}

	public void resetMessage()
	{
		this.message = "";
		this.newmess = false;
	}
	
	public void addMessage(String message) {
		this.message = this.message + " "+message;
		this.newmess = true;
	}
}
