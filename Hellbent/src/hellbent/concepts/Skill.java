package hellbent.concepts;

import hellbent.entity.Entity;

import org.newdawn.slick.Image;

public class Skill extends Attributable
{
private Image skillImage;

public Image getSkillImage() {
	return skillImage;
}

public void setSkillImage(Image skillImage) {
	this.skillImage = skillImage;
}

public boolean requires(int level)
{
	
	return true;
}


public void loadSkill(Entity e)
{
	
}
	
public boolean SkillCheck(Entity e)
{
	return true;
	
}

public int toHitMod(Entity e) {
	// TODO Auto-generated method stub
	return 0;
}



public Damage modDam(Entity hitting, Damage d) {
	// TODO Auto-generated method stub
	return d;
}

public String getCategory() {
	// TODO Auto-generated method stub
	return sGet("CATEGORY");
}
public void setCategory(String cat) {
	// TODO Auto-generated method stub
	 sSet("CATEGORY",cat);
}

public void setDescription(String desc)
{
	sSet("DESCRIPTION",desc);
}
public String getDescription()
{
	return sGet("DESCRIPTION");
}

public String getName() {
	// TODO Auto-generated method stub
	return sGet("NAME");
}

public void setName(String name)
{
	sSet("NAME",name);
}

public int getLevel() {
	return get("SKILL_LEVEL");
	
}

public void setLevel(int level) {
	set("SKILL_LEVEL",level);
}



}
