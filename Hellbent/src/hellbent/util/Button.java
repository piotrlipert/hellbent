package hellbent.util;

import java.io.FileNotFoundException;

import org.newdawn.slick.Image;

public class Button {
	
	public int x;
	public int y;
	int width;
	int height;
	private Image buttonImage;
	private String text;
	
	
	Button(int x, int y, int width, int height,Image butI)
	{
		setButtonImage(butI);
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
	public void Clicked()  
	{
	}
	public Image getButtonImage() {
		return buttonImage;
	}
	public void setButtonImage(Image buttonImage) {
		this.buttonImage = buttonImage;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	 
	
	
}
