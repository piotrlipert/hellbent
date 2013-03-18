package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Item;

import hellbent.content.items.ammunition.Arrow;
import hellbent.content.items.ammunition.Bolt;
import hellbent.content.items.ammunition.Bomb;
import hellbent.content.items.armor.LeatherBoots;
import hellbent.content.items.armor.LeatherCap;
import hellbent.content.items.armor.LeatherVest;
import hellbent.content.items.weapons.Axe;
import hellbent.content.items.weapons.Bow;
import hellbent.content.items.weapons.Branch;
import hellbent.content.items.weapons.Crossbow;
import hellbent.content.items.weapons.Dagger;
import hellbent.content.items.weapons.Flail;
import hellbent.content.items.weapons.Hammer;
import hellbent.content.items.weapons.Longsword;
import hellbent.content.items.weapons.Scimitar;
import hellbent.content.items.weapons.Shortsword;
import hellbent.content.items.weapons.Spear;
import hellbent.content.items.weapons.TwoHandedAxe;
import hellbent.content.items.weapons.TwoHandedSword;
import hellbent.entity.Entity;
import hellbent.entity.Monster;

import java.util.HashMap;

public class ItemLoader {
	public HashMap<String,Item> items = new HashMap<String,Item>();

	
	
	public ItemLoader(HellbentGame hg)
	{
		
	

		items.put("LEATHERBOOTS", new LeatherBoots());
		items.put("AXE", new Axe());
		items.put("TWOHANDAXE", new TwoHandedAxe());
		items.put("TWOHANDSWORD", new TwoHandedSword());
		items.put("LONGSWORD", new Longsword());
		items.put("SHORTSWORD", new Shortsword());
		items.put("DAGGER", new Dagger());
		items.put("FLAIL", new Flail());

		items.put("BOLT", new Bolt());
		items.put("ARROW", new Arrow());

		items.put("BOMB", new Bomb());
		items.put("SPEAR", new Spear());
		items.put("LEATHERVEST", new LeatherVest());
		items.put("LEATHERCAP", new LeatherCap());
		items.put("BRANCH", new Branch());
		items.put("SCIMITAR", new Scimitar());
		items.put("HAMMER", new Hammer());
		items.put("BOW", new Bow());
		items.put("CROSSBOW", new Crossbow());


		
	}

	public Item getItem(String name)
	{
		return (items.get(name)).clone();
	}






}
