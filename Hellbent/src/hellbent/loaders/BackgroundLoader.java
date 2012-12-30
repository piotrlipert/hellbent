package hellbent.loaders;
import hellbent.concepts.Background;

import java.util.HashMap;
import java.util.Vector;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
public class BackgroundLoader {
	
	public HashMap<Integer,Vector<Image>> BackgroundTiles = new HashMap<Integer,Vector<Image>>();
	
	public BackgroundLoader() throws SlickException
	{
	Vector<Image> Grass = new Vector<Image>();
	Grass.add(new Image("resources/tiles/grass.png"));
	
	Vector<Image> GrassA = new Vector<Image>();
	GrassA.add(new Image("resources/tiles/grass1.png"));
	
	Vector<Image> GrassB = new Vector<Image>();
	GrassB.add(new Image("resources/tiles/grass2.png"));
	
	Vector<Image> GrassC = new Vector<Image>();
	GrassC.add(new Image("resources/tiles/grass3.png"));

	
	Vector<Image> Rock = new Vector<Image>();
	Rock.add(new Image("resources/tiles/rock.png"));
	
	
	Vector<Image> WFloor = new Vector<Image>();
	WFloor.add(new Image("resources/tiles/podloga.png"));

	
	BackgroundTiles.put(Background.GRASS,Grass);
	BackgroundTiles.put(Background.GRASSA,GrassA);

	BackgroundTiles.put(Background.GRASSB,GrassB);
	BackgroundTiles.put(Background.GRASSC,GrassC);

	BackgroundTiles.put(Background.ROCK,Rock);
	BackgroundTiles.put(Background.WOODFLOOR,WFloor);

	}

}
