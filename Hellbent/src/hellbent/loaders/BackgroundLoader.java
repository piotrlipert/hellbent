package hellbent.loaders;
import hellbent.HellbentGame;
import hellbent.concepts.Background;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
public class BackgroundLoader {
	
	public HashMap<Integer,ArrayList<Image>> BackgroundTiles = new HashMap<Integer,ArrayList<Image>>();
	
	public BackgroundLoader(HellbentGame hg) throws SlickException
	{
	ArrayList<Image> Grass = new ArrayList<Image>();
	Grass.add(new Image("resources/graphics/tiles/grass.png"));
	Grass.add(new Image("resources/graphics/tiles/grass1.png"));
	Grass.add(new Image("resources/graphics/tiles/grass2.png"));
	Grass.add(new Image("resources/graphics/tiles/grass3.png"));

	
	ArrayList<Image> Rock = new ArrayList<Image>();
	Rock.add(new Image("resources/graphics/tiles/rock.png"));
	
	
	ArrayList<Image> WFloor = new ArrayList<Image>();
	WFloor.add(new Image("resources/graphics/tiles/podloga.png"));

	ArrayList<Image> CAVEFLOOR = new ArrayList<Image>();
	CAVEFLOOR.add(new Image("resources/graphics/tiles/mine/cavefloor.png"));

	ArrayList<Image> CAVEWALL = new ArrayList<Image>();
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/cavewall.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/1.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/2.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/3.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/4.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/5.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/6.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/7.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/8.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/9.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/10.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/11.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/12.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/13.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/14.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/15.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/16.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/17.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/18.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/19.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/20.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/21.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/22.png"));
	CAVEWALL.add(new Image("resources/graphics/tiles/mine/23.png"));

	BackgroundTiles.put(Background.GRASS,Grass);


	BackgroundTiles.put(Background.ROCK,Rock);
	BackgroundTiles.put(Background.WOODFLOOR,WFloor);
	
	BackgroundTiles.put(Background.CAVEFLOOR,CAVEFLOOR);
	BackgroundTiles.put(Background.CAVEWALL,CAVEWALL);


	}

}
