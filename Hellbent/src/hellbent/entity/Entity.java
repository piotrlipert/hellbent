package hellbent.entity;
import hellbent.HellbentGame;
import hellbent.concepts.Ability;
import hellbent.concepts.Action;
import hellbent.concepts.Attributable;
import hellbent.concepts.Damage;
import hellbent.concepts.Effect;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.concepts.Profession;
import hellbent.concepts.Skill;
import hellbent.concepts.StateChangeListener;
import hellbent.concepts.TalkState;
import hellbent.concepts.Weapon;
import hellbent.content.actions.Wait;
import hellbent.util.Utilities;
import hellbent.world.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.Image;
public class Entity extends Attributable {
	
	public Vector<Action> actions = new Vector<Action>();
	
	public HashMap<Integer,Item> slots = new HashMap<Integer,Item>(); 
	public HashMap<String,Skill> skills = new HashMap<String,Skill>(); 
	public HashMap<String,Ability> abilities = new HashMap<String,Ability>(); 

	
	public Vector<Effect> effects = new Vector<Effect>();
	public Vector<Item> inventory = new Vector<Item>();
	public Vector<StateChangeListener> statelisten = new Vector<StateChangeListener>();
	private String mapID;
	private Image sprite;
	public Map map = null;
	private boolean awake;
	private String type;
	private Profession profession;
	private String message = "";
	private String name;
	public HellbentGame hg;

	public int[][] sight;

	private HashMap<String, TalkState> talkstate = new HashMap<String, TalkState>();
	
	
	
	protected Entity(HellbentGame h)
	{
		hg = h;
	}
	public String getMessage() {
		return message;
	}

	public void resetMessage()
	{
		this.message = "";
	}
	
	public void addMessage(String message) {
		if (this.getType() == "Player")
			{
		this.message = this.message + " "+message;
			}
	}
	
	
public void setPos(int x,int y)
{
	this.setX(x);
	this.setY(y);
}
public void setMap(Map m)
{
	setMapID(m.getName());
	sight = new int[m.getSizeX()][m.getSizeY()];
	this.map = m;

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
	if (actions.size() > 0)
	{
		return actions.get(0);
		
	}
	else
		return null;
}

public void popAction() {
	if (actions.size() > 0)
		actions.remove(0);		
}

public void setAction(Action action) {
	this.actions.add(action);
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
	String ret = "<ENTITEMS>\n";
	
	for (Item i : inventory)
	{
		ret = ret + i.save();
	}
	return ret + "</ENTITEMS>\n";
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

public void load(String savestr,HellbentGame hg)
{
	this.loadAttributes(savestr);
	this.skills = Formulas.getSkills(this);
	this.loadItems(savestr, hg);
	this.loadEffects(savestr);
	
}

private void loadEffects(String savestr) 

{
	/*String effects = Utilities.substring("EFFECTS", savestr);
	String[] eff = effects.split("</EFF>");

	for (String s : eff)
	{
		
	}
	*/
}

private void loadItems(String savestr, HellbentGame hg) 
{
String items = Utilities.substring("ENTITEMS", savestr);
String[] item = items.split("</ITEM>");
for (String s : item)
{
	if (s.length() > 10)
	{
String type = Utilities.substring("TYPE", s);
Item i = hg.itl.getItem(type);
i.load(s);
if (i.get("EQUIPPED") == 1)
	setItemAtSlot(i, i.get("EQUIPPED_SLOT"));
	
inventory.add(i);
	}
	}

}

public void loadAttributes(String savestr) 
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

public Item getItemAtSlot(int equipslotid) 
{	
	return slots.get(equipslotid);
}

public void setItemAtSlot(Item i, int equipslot) 
{		
	slots.put(equipslot,i);
}

public Vector<Weapon> getWeapon() 
{
	
	Vector<Weapon> w = new Vector<Weapon>();
	for(Item i : inventory)
	{
		if(i.get("TYPE") == Formulas.WEAPONS)
		{
			if (i.get("EQUIPPED") == 1)
			{
				w.add((Weapon) i);
			}
		}
			
	}
	return w;
}


public Weapon chooseWeapon(Vector<Weapon> w)
{
	if(w.size() > 0)
	{
		Collections.shuffle(w);
	}
	else
	{
		//TODO NATURAL WEAPONS?
		return null;
	}
	if (w.size() == 1)
		return w.get(0);
	
	else
	{
		for(Weapon i : w)
		{
			if (i.get("LAST") == 0)
			{
				i.set("LAST", 1);
				return i;
			}
			else
			{
				i.set("LAST",0);
			}
		}
	}
	return null;
}

public Damage getDamage(Weapon w) 
{
Damage ret = new Damage();

	
if (w != null)
	ret = w.getDamage(this);
else
	ret = naturalDamage();

return ret;
}

private Damage naturalDamage() {

	Damage ret = new Damage();
	ret.setDamage(Formulas.SMASH,1);
	return ret;
}

public int weaponSkillMod(Weapon weapon) {
	return 0;
}

public HashMap<String, TalkState> getTalkstate() {
	return talkstate;
}
public void setTalkstate(HashMap<String, TalkState> talkstate) {
	this.talkstate = talkstate;
}

public void addTalkstate(TalkState t,String s)
{
	talkstate.put(s,t);
}

public void removeTalkstate(TalkState t)
{
	talkstate.remove(t);
}
public boolean isTalkable() {
	return false;
}
public Skill getSkill(String string) 
{
	return skills.get(string);
}

}


