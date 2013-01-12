package hellbent.entity;
import hellbent.concepts.Action;
import hellbent.concepts.Effect;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.concepts.Profession;
import hellbent.content.actions.Wait;
import hellbent.util.Utilities;
import hellbent.world.Map;

import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.Image;
public class Entity {
	public HashMap<String, Integer> data = new HashMap<String, Integer>();
	public HashMap<String, String> sdata = new HashMap<String, String>();
	
	
	public Vector<Effect> effects = new Vector<Effect>();
	private Vector<Item> inventory = new Vector<Item>();

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
	private String name;
	
	
	
	
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
	if (name.indexOf("_OLD") == -1)
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public String save()
{
	String savestr = "<ENTITY>\n";
	savestr += this.saveTypeAndName();
	savestr += this.saveAttributes();
	savestr += this.saveEffects();
	savestr += this.saveItems();
	
	return savestr+"</ENTITY>\n";
}


protected String saveItems() {
	// TODO Auto-generated method stub
	return "";
}

protected String saveEffects() {
	// TODO Auto-generated method stub
	return "";
}

protected String saveAttributes() 
{
	String ret = "<ATR>\n";
for(String i : this.data.keySet())
	{
	ret = ret + i + "::" + Integer.toString(this.get(i)) + "\n";
	}
	ret = ret + "</ATR>\n";

	ret = ret + "<sATR>\n";
	
	for(String i : this.sdata.keySet())
	{
	ret = ret + i + "::" + this.sGet(i) + "\n";
	}
	
	
	return ret+"</sATR>\n";
	
	
}

protected String saveTypeAndName() {

	String ret = "<TYPE>"+this.getType()+"</TYPE>\n";
	ret = ret + "<NAME>"+this.getName() + "</NAME>\n";
	ret = ret + "<MNAME>"+this.getMapID() + "</MNAME>\n";
	
	return ret;
}

public void load(String savestr)
{
	this.loadAttributes(savestr);
	this.loadItems(savestr);
	this.loadEffects(savestr);
	
}

private void loadEffects(String savestr) {
	// TODO Auto-generated method stub
	
}

private void loadItems(String savestr) {
	// TODO Auto-generated method stub
	
}

private void loadAttributes(String savestr) 
{
String atr = Utilities.substring("ATR", savestr);
String satr = Utilities.substring("sATR", savestr);

String[] aS = atr.split("[\r\n]+");
String[] SaS = satr.split("[\r\n]+");

for (String i : aS)
{
	if (i.length() > 3)
	 this.set(i.split("::")[0],Integer.parseInt(i.split("::")[1]));
}
	
for (String i : SaS)
{
	if (i.length() > 3)
	 this.sSet(i.split("::")[0],i.split("::")[1]);
}

}

public Vector<Item> getInventory() {
	return inventory;
}

public void setInventory(Vector<Item> inventory) {
	this.inventory = inventory;
}

public boolean hasItem(Item e, boolean take)
{
	for(Item i : inventory)
	{
		if (i.getName() == e.getName())
			return true;
		
	}
	return false;
	
}

}


