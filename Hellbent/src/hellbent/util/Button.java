package hellbent.util;

public class Button {
	
	int x;
	int y;
	int width;
	int height;
	
	Button(int x, int y, int width, int height)
	{
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	}
	public boolean isInBox(int clickx, int clicky) {
		if (clickx >= x && clickx <= x+width)
			if (clicky >= y && clicky <= y+height)
					return true;
		
		return false;
		
	}
	void Clicked() 
	{
	}
	
}
