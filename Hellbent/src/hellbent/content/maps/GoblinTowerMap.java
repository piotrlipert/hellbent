package hellbent.content.maps;

import org.newdawn.slick.SlickException;

import hellbent.concepts.Background;
import hellbent.content.monsters.GiantRat;
import hellbent.world.Map;

public class GoblinTowerMap extends Map {

	public GoblinTowerMap() throws SlickException {
		super(100, 100, false, 0);
		background[5][5] = Background.ROCK;
		background[5][6] = Background.ROCK;
		background[5][7] = Background.ROCK;
		background[5][8] = Background.ROCK;
		background[6][5] = Background.ROCK;
		background[6][6] = Background.ROCK;
		background[6][7] = Background.ROCK;
		background[6][8] = Background.ROCK;
		background[10][11] = Background.WOODFLOOR;
		background[10][10] = Background.WOODFLOOR;
		background[11][10] = Background.WOODFLOOR;
		background[11][11] = Background.WOODFLOOR;
		background[21][21] = Background.WOODFLOOR;


		GiantRat test = new GiantRat();
		test.setPos(30, 20);
		test.setMap(this);
		entities.add(test);

		
	}

}
