package hellbent.concepts;

import org.newdawn.slick.Image;

import hellbent.entity.Entity;

public class Feature extends Attributable{

	private Image im;

	public void load(String s) 
	{
		
	}

	public Feature clone()
	{
		return new Feature();
	}

	public void perform(Entity en) {
		// TODO Auto-generated method stub
		
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return im;
	}
	public void setImage(Image ima)
	{
		im = ima;
	}

	public boolean isTransparent() {
		// TODO Auto-generated method stub
		return false;
	}
}
