package hellbent.concepts;

import hellbent.entity.Entity;

public class Weapon extends Item 
{
	
	public Weapon()
	{
	this.set("TYPE",Formulas.WEAPONS);
	this.CANEQUIP = true;
	this.CANUSE = false;
	
	}


public Damage getDamage(Entity hitting)
{
	Damage ret = new Damage();
	int damage = Formulas.dice(this.get("D_COUNT"), this.get("D_WALLS"));
	damage = damage + hitting.weaponSkillMod(this);
	ret.setDamage(get("DAMAGE_TYPE"), damage);
	return ret;
	
}
	
public void onHit(Entity hit)
{
	
}
	
}
