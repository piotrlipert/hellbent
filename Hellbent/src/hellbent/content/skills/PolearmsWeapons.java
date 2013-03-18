package hellbent.content.skills;

import hellbent.concepts.Formulas;
import hellbent.concepts.Skill;
import hellbent.entity.Entity;

public class PolearmsWeapons extends Skill 
{

	
	public PolearmsWeapons()
	{
		
		
	}
	
	public void loadSkill(Entity e)
	{
		
		set("SKILL_VALUE", e.get("PolearmsWeapons_SKILL"));
		setCategory("COMBAT");

	}
	
	
	public void setSkill(Entity e, int lvl)
	{
		
		e.set("PolearmsWeapons_SKILL",get("SKILL_VALUE"));
		
	}

}
