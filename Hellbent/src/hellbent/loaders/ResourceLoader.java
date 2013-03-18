package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Feature;
import hellbent.concepts.Item;
import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ResourceLoader 
{
	public HashMap<String,Image> entity_images = new HashMap<String,Image>();
	public HashMap<String,Image> item_images = new HashMap<String,Image>();
	public HashMap<String,Image> feature_images = new HashMap<String,Image>();

	
	public ResourceLoader(HellbentGame hg) throws SlickException
	{
		
		
		
	item_images.put("ARROW", new Image("resources/graphics/items/ammunition/bolt.png"));
	item_images.put("BOLT", new Image("resources/graphics/items/ammunition/arrow.png"));

	item_images.put("AXE", new Image("resources/graphics/items/weapons/axe.png"));
	item_images.put("LONGSWORD", new Image("resources/graphics/items/weapons/longsword.png"));
	item_images.put("TWOHANDSWORD", new Image("resources/graphics/items/weapons/twohandedsword.png"));
	item_images.put("TWOHANDAXE", new Image("resources/graphics/items/weapons/twohandaxe.png"));
	item_images.put("BOW", new Image("resources/graphics/items/weapons/bow.png"));
	item_images.put("CROSSBOW", new Image("resources/graphics/items/weapons/crossbow.png"));
	item_images.put("SHORTSWORD", new Image("resources/graphics/items/weapons/shortsword.png"));
	item_images.put("DAGGER", new Image("resources/graphics/items/weapons/dagger.png"));
	item_images.put("FLAIL", new Image("resources/graphics/items/weapons/flail.png"));
	item_images.put("BOMB", new Image("resources/graphics/items/ammunition/bomb.png"));
	item_images.put("SPEAR", new Image("resources/graphics/items/weapons/spear.png"));
	item_images.put("BRANCH", new Image("resources/graphics/items/weapons/branch.png"));
	item_images.put("SCIMITAR", new Image("resources/graphics/items/weapons/scimitar.png"));
	item_images.put("HAMMER", new Image("resources/graphics/items/weapons/hammer.png"));

	item_images.put("LEATHERVEST", new Image("resources/graphics/items/armor/leathervest.png"));
	item_images.put("LEATHERBOOTS", new Image("resources/graphics/items/armor/leatherboots.png"));
	item_images.put("LEATHERCAP", new Image("resources/graphics/items/armor/leathercap.png"));

	
	
	feature_images.put("MINE_BARREL", new Image("resources/graphics/features/mine/barrel.png"));
	
	
	feature_images.put("ROCK", new Image("resources/graphics/features/mine/rock1.png"));
	feature_images.put("ROCK1", new Image("resources/graphics/features/mine/rock2.png"));
	feature_images.put("ROCK2", new Image("resources/graphics/features/mine/rock3.png"));
	feature_images.put("ROCK3", new Image("resources/graphics/features/mine/rock4.png"));
	feature_images.put("ROCK4", new Image("resources/graphics/features/mine/rock5.png"));
	
	feature_images.put("STALACTIT", new Image("resources/graphics/features/mine/stalaktyt1.png"));
	feature_images.put("STALACTIT1", new Image("resources/graphics/features/mine/stalaktyt2.png"));
	feature_images.put("STALAGMIT", new Image("resources/graphics/features/mine/stalagmit1.png"));
	feature_images.put("STALAGMIT1", new Image("resources/graphics/features/mine/stalagmit2.png"));

	
	
	feature_images.put("LEAVE_TREE", new Image("resources/graphics/features/forest/tree1.png"));
	feature_images.put("LEAVE_TREE1", new Image("resources/graphics/features/forest/tree2.png"));
	feature_images.put("LEAVE_TREE2", new Image("resources/graphics/features/forest/tree3.png"));
	feature_images.put("LEAVE_TREE3", new Image("resources/graphics/features/forest/tree4.png"));
	feature_images.put("LEAVE_TREE4", new Image("resources/graphics/features/forest/tree5.png"));
	
	feature_images.put("TRUNK", new Image("resources/graphics/features/forest/trunk1.png"));
	feature_images.put("TRUNK1", new Image("resources/graphics/features/mine/rock4.png"));
	
	
	feature_images.put("WOODEN_DOOR", new Image("resources/graphics/features/mine/woodendoorclosed.png"));
	feature_images.put("WOODEN_DOOR_OPEN", new Image("resources/graphics/features/mine/woodendooropen.png"));
	
	
	entity_images.put("GOBLIN_MINER", new Image("resources/graphics/entities/goblins/goblinminer.png"));
	entity_images.put("GOBLIN_WORKER1", new Image("resources/graphics/entities/goblins/goblinworker1.png"));
	entity_images.put("GOBLIN_WORKER2", new Image("resources/graphics/entities/goblins/goblinworker2.png"));
	entity_images.put("GOBLIN_SLAVE_LEADER", new Image("resources/graphics/entities/goblins/slaveleader.png"));
	
	
	entity_images.put("HUMAN_GUARD", new Image("resources/graphics/entities/humans/humanguard.png"));
	entity_images.put("HUMAN_ARCHER_GUARD", new Image("resources/graphics/entities/humans/humanarcher.png"));
	entity_images.put("HUMAN_GUARD_LEADER", new Image("resources/graphics/entities/humans/humanknight.png"));

	entity_images.put("DWARVEN_GUARD", new Image("resources/graphics/entities/dwarves/dwarvenguard.png"));

	
	entity_images.put("GIANT_RAT", new Image("resources/graphics/entities/animals/giantrat.png"));

	
	
	
	
	
	
	}

	
	public Image getFeatureImage(String name)
	{
		return (feature_images.get(name));
	}
	
	public Image getEntityImage(String name)
	{
		return (entity_images.get(name));
	}

	public Image getItemImage(String name) {
		return (item_images.get(name));
	}

}
