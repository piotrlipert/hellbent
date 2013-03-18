package hellbent.content.skills;

import hellbent.concepts.Damage;
import hellbent.concepts.Formulas;
import hellbent.concepts.Skill;
import hellbent.entity.Entity;

public class SlashWeapons extends Skill 
{

	
	public SlashWeapons()
	{
		
		
	}
	
	public void loadSkill(Entity e)
	{
		
		set("SKILL_VALUE", e.get("SlashWeapons_SKILL"));
		setCategory("COMBAT");
		setName("Slash Weapons");

	}
	
	
	public void setSkill(Entity e, int lvl)
	{
		
		e.set("SlashWeapons_SKILL",get("SKILL_VALUE"));
		
	}

	@Override
	public boolean SkillCheck(Entity e) {
		// TODO Auto-generated method stub
		return super.SkillCheck(e);
	}

	public int toHitMod(Entity e) 
	{
	int sv = get("SKILL_VALUE");
	return sv * 10;
	
	}

	@Override
	public Damage modDam(Entity hitting, Damage d) 
	{
		int sv = get("SKILL_VALUE");

		int slashDam = d.getDamage(Formulas.SLASH);
		slashDam = slashDam + sv * 1000;
		d.setDamage(Formulas.SLASH, slashDam);
	return d;
	}

	
	
	
}
