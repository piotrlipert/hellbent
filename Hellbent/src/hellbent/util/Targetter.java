package hellbent.util;

import hellbent.HellbentGame;
import hellbent.concepts.Feature;
import hellbent.entity.Entity;
import hellbent.entity.Player;
import hellbent.states.GameplayState;
import hellbent.world.Map;

import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Targetter 
{

	
	Image im = null;
	HellbentGame hg;
	Vector<int[]> ar = new Vector<int[]>();
	
	
	Targetter(HellbentGame h)
	{
		hg = h;
		try {
			im = new Image("resources/graphics/menus/target.png",Color.white);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Vector<int[]> getArea(int x, int y, Map m)
	{
		int[] v = new int[2];
		v[0] = x;
		v[1] = y;
		Vector<int[]> area = new Vector<int[]>();
		if(m.isInBounds(v))
		{
			area.add(v);
		}
		ar = area;
		
		return area;
	}

	
	
	public Vector<Entity> getEntities(Map m)
	{
		
		Vector<Entity> en = new Vector<Entity>();
		for(int[] p : ar)
		{
			Entity e = m.entityAtCoord(p[0], p[1]);
			if(e != null)
				en.add(e);
			
		}
		en = FilterEntities(en);
		return en;
	}
	
	private Vector<Entity> FilterEntities(Vector<Entity> en) {
		return en;
	}



	public Vector<Feature> getFeatures(Map m)
	{
		
		Vector<Feature> en = new Vector<Feature>();
		for(int[] p : ar)
		{
			Feature e = m.getFeatureAt(p[0], p[1]);
			if(e != null)
				en.add(e);
			
		}
		en = FilterFeatures(en);
		return en;
	
		
		
	}

	private Vector<Feature> FilterFeatures(Vector<Feature> en) {
		// TODO Auto-generated method stub
		return en;
	}



	public Vector<int[]> getTiles(Map m)
	{
		Vector<int[] > tiles = new Vector<int[] >();
		for (int[] p : ar)
		{
			if (m.isInBounds(p))
				tiles.add(p);
		}
		
		tiles = FilterTiles(tiles);
		return tiles;
		
	}



	private Vector<int[]> FilterTiles(Vector<int[]> tiles) {
		// TODO Auto-generated method stub
		return tiles;
	}


	public void render(GameplayState gs) 
	{
		Player tmp = hg.ge.getPlayer();

		int centerX = tmp.getX();
		int centerY = tmp.getY();
		for (int[] p : ar)
		{
			
			gs.drawOnScreen(p[0] - centerX, p[1] - centerY, im);
			
		}
	}

}
