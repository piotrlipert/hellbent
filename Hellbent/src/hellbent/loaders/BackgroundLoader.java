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
	Grass.add(new Image("resources/tiles/grass1.jpg"));
	
	
	Vector<Image> Rock = new Vector<Image>();
	Rock.add(new Image("resources/tiles/rock.png"));
	
	
	Vector<Image> WFloor = new Vector<Image>();
	WFloor.add(new Image("resources/tiles/podloga.png"));

	
	BackgroundTiles.put(Background.GRASS,Grass);
	BackgroundTiles.put(Background.ROCK,Rock);
	BackgroundTiles.put(Background.WOODFLOOR,WFloor);

	}

}
