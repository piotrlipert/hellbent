package hellbent.loaders;

import hellbent.HellbentGame;

public class Saver 
{
HellbentGame h;
	public Saver(HellbentGame hg)
	{
		h = hg;
	}
	
	
	public void saveGame(String path)
	{
		
		savePlayer(path);
		saveMaps(path);
		saveGlobal(path);
	
	}

	private void saveGlobal(String path) {
		// TODO Auto-generated method stub
		
	}

	private void saveMaps(String path) {
		// TODO Auto-generated method stub
		
	}

	private void savePlayer(String path) {
		// TODO Auto-generated method stub
		
	}
	
}
