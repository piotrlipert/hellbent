package hellbent.util;

import java.util.Vector;

import hellbent.HellbentGame;
import hellbent.world.Map;

public class LineTargetter extends Targetter {

	LineTargetter(HellbentGame h) {
		super(h);
		// TODO Auto-generated constructor stub
	}


	public Vector<int[]> getArea(int x, int y, Map m)
	{
		
		int plx = hg.ge.pl.getX();
		int ply = hg.ge.pl.getY();
		
		
	
		Vector<int[]> area = new Vector<int[]>();
		
		for(int[] v : Utilities.smoothLinePath(plx, ply, x, y))
		{
			if(m.isInBounds(v))
			{
				area.add(v);
			}
		
		}
		ar = area;
		
		return area;
	}


}
