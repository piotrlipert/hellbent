package hellbent.loaders;

import hellbent.HellbentGame;
import hellbent.concepts.Feature;
import hellbent.concepts.Item;
import hellbent.content.features.forest.LeaveTree;
import hellbent.content.features.forest.Trunk;
import hellbent.content.features.mine.Barrel;
import hellbent.content.features.mine.WoodenDoor;
import hellbent.content.features.mine.Rock;
import hellbent.content.features.mine.Stalactit;
import hellbent.content.features.mine.Stalagmit;
import java.util.HashMap;

public class FeatureLoader 
{
	public HashMap<String,Feature> features = new HashMap<String,Feature>();

	public FeatureLoader(HellbentGame hg)
	{
		
		features.put("STALACTIT", new Stalactit());
		features.put("STALAGMIT", new Stalagmit());
		features.put("ROCK", new Rock());
		features.put("LEAVE_TREE", new LeaveTree());
		features.put("BARREL", new Barrel());
		features.put("WOODEN_DOOR", new WoodenDoor());
		features.put("TRUNK", new Trunk());
		
		
		
	}

	public Feature getFeature(String name)
	{
		return (features.get(name)).clone();
	}

}
