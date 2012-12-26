package hellbent.entity;
import hellbent.concepts.Action;
import hellbent.concepts.Effect;
import hellbent.concepts.Formulas;
import hellbent.concepts.Profession;
import hellbent.content.actions.Wait;
import hellbent.world.Map;

import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.Image;
public class Entity {
	public HashMap<String, Integer> data = new HashMap<String, Integer>();
	public HashMap<String, String> sdata = new HashMap<String, String>();
	public Vector<Effect> effects = new Vector<Effect>();
	private int x;
	private int y;
	private String mapID;
	private Image sprite;
	public Map map = null;
	private boolean awake;
	private Action action = null;
	private String type;
	private Profession profession;
	private String message;
	private boolean newmess;
	
	
	public String getMessage() {
		return message;
	}

	public void resetMessage()
	{
		this.message = "";
		this.newmess = false;
	}
	
	public void addMessage(String message) {
		if (this.getType() == "Player")
			{
		this.message = this.message + " "+message;
		this.newmess = true;
			}
	}
	
	
	public void sSet(String name, String value) 
	{
	sdata.put(name,value);
	}
	public String sGet(String name)
	{

		if (sdata.get(name) == null)
				return "";
		else
			return sdata.get(name);
	
	}
	
	public void set(String name, int value) 
	{
	data.put(name+"_OLD",this.get(name));
	data.put(name,value);
	}
	public int get(String name)
	{
		if (data.get(name) == null)
				return 0;
		else
			return data.get(name);
	
	}
	
void save(String filename)
{
	
}

void load(String data)
{
	
}

public void add(String name, int value)
{
	this.set(name, this.get(name)+value);
}

public void sub(String name, int value)
{
	this.set(name, this.get(name)-value);

}
public void setPos(int x,int y)
{
	this.setX(x);
	this.setY(y);
}
public String getMapID() {
	return mapID;
}
public void setMapID(String mapID) {
	this.mapID = mapID;
}
public int getY() {
	return get("Y");
}
public void setY(int y) {
	set("Y",y);
}
public int getX() {
	return get("X");
}
public void setX(int x) {
	set("X",x);
}
public Image getSprite() {
	return sprite;
}
public void setSprite(Image sprite) {
	this.sprite = sprite;
}



public Map getMap() {
	return map;
}
public void setMap(Map map) {
	this.map = map;
}
public boolean isAwake() {
	return awake;
}
public void setAwake(boolean awake) {
	this.awake = awake;
}

public Action AI(Map m)
{

	Action a = new Wait(500,this);
	return a;
}
public Action getAction() {
	return action;
}
public void setAction(Action action) {
	this.action = action;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Profession getProfession() {
	return profession;
}
public void setProfession(Profession profession) {
	this.profession = profession;
}

public void die(Entity killer) 
	{
	Map m = this.getMap();
	m.entities.remove(this);
	this.drop();
	killer.add("EXP", Formulas.EXPValue(this));
	

	
	}

private void drop() {
	
}
}
