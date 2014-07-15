package hellbent.util;

import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.entity.Player;
import hellbent.world.Map;

public class InventoryWidget {
	
	
	
	HellbentGame h;
	private boolean dragging = false;
	Vector<Item> inv;
	Vector<Item> invDisplay;
	private int SORT = ALL;
	private Item dragged = null;
	Image scroll = null;
	private Item displayed = null;
	public int scrollGround = 0;
	public int scrollBackPack = 0;
	
	public Vector<int[]> SLOTS;
	public boolean start_scrollin_ground = false;
	public boolean start_scrollin_pack = false;
	
	public int lastGroundsize = 0;
	public int lastInventoryDisplaySize = 0;
	
	public static final int ALL = 0;
	public static final int WEAPONS = 1;
	public static final int ARMOR = 2;
	public static final int TRINKET = 3;
	public static final int AMULETS = 4;
	public static final int POTIONS = 5;
	public static final int SCROLLS = 6;
	public static final int OTHER = 7;
	public static final int TOOLS = 8;
	public static final int MISSILE = 9;
	public static final int MISSILE_WEAPONS = 10;
	public static final int UNIDENTIFIED = 11;

	
	public static final int DESC_X = 502;
	public static final int DESC_Y = 25;
	public static final int DESC_WIDTH = 900;
	public static final int DESC_HEIGHT = 300;
	
	public static final int SLOT_DISTANCE_Y = 43;

	public static final int SLOT_DISTANCE_X = 43;
	public static final int SLOT_PER_ROW = 9;
	public static final int SLOT_PER_FIRST_TWO_ROWS = 7;

	public static final int SLOT_PER_COLUMN = 7;
	
	public static final int SLOT_GRID_X = 534;
	public static final int SLOT_GRID_Y = 399;
	public static final int SLOT_GRID_XEND = 923;
	public static final int SLOT_GRID_YEND = 683;
	private static final int HERO_X = 11;
	private static final int HERO_XEND = 511;
	private static final int HERO_Y = 11;
	private static final int HERO_YEND = 625;
	private static final int GROUND_X = 59;
	private static final int GROUND_Y = 626;
	private static final int GROUND_XEND = 438;
	private static final int GROUND_YEND = 699;
	private static final int GROUND_SCROLL_X = 413;
	private static final int GROUND_SCROLL_Y = 626;
	private static final int GROUND_SCROLL_XEND = 432;
	private static final int GROUND_SCROLL_YEND = 700;
	private static int GROUND_SCROLL_POS = 0;

	private static final int PACK_SCROLL_X = 949;
	private static final int PACK_SCROLL_Y = 402;
	private static int PACK_SCROLL_POS = 0;
	private static final int PACK_SCROLL_XEND = 960;
	private static final int PACK_SCROLL_YEND = 691;
	
	public InventoryWidget(HellbentGame hg)
	{
		h = hg;
	SLOTS = new Vector<int[]>();
	
	int slot[] = new int[3];
	slot[0] = 128;
	slot[1] = 417;
	slot[2] = Formulas.LEFT_HAND;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 327;
	slot[1] = 417;
	slot[2] = Formulas.RIGHT_HAND;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 326;
	slot[1] = 74;
	slot[2] = Formulas.HEAD;
	SLOTS.add(slot);
	
	slot= new int[3];
	slot[0] = 146;
	slot[1] = 130;
	slot[2] = Formulas.NECK;
	SLOTS.add(slot);
	
	slot= new int[3];
	slot[0] = 222;
	slot[1] = 182;
	slot[2] = Formulas.TORSO;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 92;
	slot[1] = 254;
	slot[2] = Formulas.CLOAK;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 254;
	slot[1] = 362;
	slot[2] = Formulas.LEGS;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 218;
	slot[1] = 569;
	slot[2] = Formulas.BOOTS;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 344;
	slot[1] = 470;
	slot[2] = Formulas.TRINKET_1;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 110;
	slot[1] = 470;
	slot[2] = Formulas.TRINKET_2;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 380;
	slot[1] = 182;
	slot[2] = Formulas.MISSILE;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 393;
	slot[1] = 218;
	slot[2] = Formulas.MISSILE_WEAPON;
	SLOTS.add(slot);
	
	try {
		scroll = new Image("resources/graphics/menus/dyngs.png",Color.white);
	} catch (SlickException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	

	

	
	public void drawStack(HellbentGame hg,int x, int y,Item it)
	{
		hg.fontCommon.drawString(x, y, Integer.toString(it.get("STACK")));
		
	}
	

	
	
	public void renderItems(HellbentGame hg) 
	{
		invDisplay = new Vector<Item>();

		Player tmp = hg.ge.pl;
		Map m = tmp.getMap();
		inv = tmp.inventory;
		Vector<Item>ground = Utilities.getItemsAtCoord(m, tmp.getX(),tmp.getY());
		ground = Utilities.stackize(ground);
		
		int mouseX = hg.in.getMouseX();
	    int mouseY = hg.in.getMouseY();
		
	    int packscrolldiff = 0;
	    int groundscrolldiff = 0;
	     
	
	    
	    
	    if (lastGroundsize/8 != ground.size()/8)
	    {
	    	if(scrollGround >= ground.size()/8 && ground.size()/8 > 0)
	    		scrollGround = scrollGround - 1;
	    }
	    lastGroundsize = ground.size();
	   
	    if (ground.size() > 8)
		{
		int groundverses = ground.size()/8;
	
		groundscrolldiff = (GROUND_SCROLL_YEND - GROUND_SCROLL_Y) / groundverses;
		if(start_scrollin_ground)
	    {
	    	GROUND_SCROLL_POS =  (mouseY - GROUND_SCROLL_Y);
	    	
    		scrollGround = GROUND_SCROLL_POS/groundscrolldiff;

	    	if (GROUND_SCROLL_POS <= 0)
	    		scrollGround = 0;
	    	
	    	if (GROUND_SCROLL_POS  > GROUND_SCROLL_YEND - (GROUND_SCROLL_Y + groundscrolldiff))
	    		scrollGround = groundverses - 1;
	    	
	    	
	    }
	    	
		}

		
		// TODO STACK!!!
		for (Item i : inv)
		{
			if (i.get("EQUIPPED") == 0)
			{
			if (i.get("TYPE") == SORT || SORT == ALL)
			{
			invDisplay.add(i);
			}
			}
		}
		invDisplay = Utilities.stackize(invDisplay);
		
		
		if(!isDragging())
	    	setDisplayed(getItemAt(mouseX,mouseY));
		
		 if (lastInventoryDisplaySize/9 != invDisplay.size()/9 && invDisplay.size()/9 > 0)
		    {
			 if(scrollBackPack >= (invDisplay.size()/SLOT_PER_ROW))
		    		scrollBackPack = scrollBackPack - 1;
		    }
		    lastInventoryDisplaySize = invDisplay.size();
		
		if(invDisplay.size()>SLOT_PER_ROW)
		{
		int invverses = invDisplay.size()/SLOT_PER_ROW;

		packscrolldiff = (PACK_SCROLL_YEND - PACK_SCROLL_Y) / invverses;


		if(start_scrollin_pack)
			
		{
			

			PACK_SCROLL_POS =  (mouseY - PACK_SCROLL_Y);
    		scrollBackPack = PACK_SCROLL_POS/packscrolldiff;

			if (PACK_SCROLL_POS <= 0)
	    		scrollBackPack = 0;
	    	
	    	if (PACK_SCROLL_POS >= PACK_SCROLL_YEND - (PACK_SCROLL_Y + packscrolldiff))
	    		scrollBackPack = invverses-1;
	    	

		}
		}
		scroll.draw(GROUND_SCROLL_X,GROUND_SCROLL_Y+ scrollGround * groundscrolldiff ,0.5F);
		scroll.draw(PACK_SCROLL_X,PACK_SCROLL_Y+scrollBackPack * packscrolldiff,0.5F);

		
		
		if(dragging && dragged != null)
		{
			 
	       
			hg.rel.getItemImage(dragged.getType()).draw(mouseX-10,mouseY-10);
		}
		int x = 0;
		int y = 0;
		int count = 0;
		
			for (Item i : ground)
			{
			if(count >= scrollGround * 8)
			{
			Image ii = hg.rel.getItemImage(i.getType());
			ii.draw(x*SLOT_DISTANCE_X+GROUND_X, y*SLOT_DISTANCE_Y+GROUND_Y);
			drawStack(hg, x*SLOT_DISTANCE_X+GROUND_X, y*SLOT_DISTANCE_Y+GROUND_Y, i);
			x = x + 1;
			if(x > 7)
			{
				y = y + 1;
				x = 0;
			}
			if (y > 1)
				break;
			}
			count++;
			}
		
		 x = 0;
		 y = 0;
		
		
		count = 0;
		for (Item i : invDisplay)
		{
			
			
		if(count >= SLOT_PER_ROW * scrollBackPack)
		{
			Image ii = hg.rel.getItemImage(i.getType());

			ii.draw(x*SLOT_DISTANCE_X+SLOT_GRID_X, y*SLOT_DISTANCE_Y+SLOT_GRID_Y);
			drawStack(hg, x*SLOT_DISTANCE_X+SLOT_GRID_X, y*SLOT_DISTANCE_Y+SLOT_GRID_Y, i);

			x = x + 1;

		}	
			
			
		count++;
			
			if (x+1 > SLOT_PER_ROW)
			{
				y++;
				x = 0;
			}
			
			if (y > SLOT_PER_COLUMN - 1)
				break;
			
			}
		
			
		
	
		for (int[] i : SLOTS)
		{
			Item it = tmp.getItemAtSlot(i[2]);
			if (it != null)
			{
				Image ii = hg.rel.getItemImage(it.getType());

				ii.draw(i[0],i[1]);
			}
		}
	}



	public boolean isDragging() {
		return dragging;
	}



	public void setDragging(boolean dragging) {
		this.dragging = dragging;
	}



	public int getSORT() {
		return SORT;
	}



	public void setSORT(int sORT) {
		SORT = sORT;
	}



	public Item getDragged() {
		return dragged;
	}



	public void setDragged(Item dragged) {
		this.dragged = dragged;
	}

	
	
	
	
	
	public Item getItemAt(int x, int y)
	{			

	if(isClickInBackpack(x,y))
	{
		int[] coord = getSlotCoord(x,y);
		if (coord[1] == -1 || coord[0] == -1){
			return null;

		}
		else
		{
			int pos = 0;
			
			pos = SLOT_PER_ROW * (coord[1] + scrollBackPack) +  coord[0];	
			

			System.out.println(invDisplay.size());
			
			if (invDisplay.size() > pos)
				return invDisplay.get(pos);
			else
			{
			return null;
			}
		}
	}
	if(isClickOnHero(x,y))
	{
		for (int[] k : SLOTS)
		{
			if (Utilities.Ddistance(k[0]+16, k[1]+16, x, y) < 20)
			{
			return h.ge.pl.getItemAtSlot(k[2]);
			}
			
			
		}
	}
	if(isClickOnGround(x,y))
	{
		Player tmp = h.ge.pl;
		Vector<Item> ground = Utilities.getItemsAtCoord(tmp.getMap(), tmp.getX(), tmp.getY());
		int[] coord = getGroundSlotCoord(x,y);
		if (coord[1] == -1 || coord[0] == -1)
			return null;
		else
			{
			int pos = 0;
			pos = 8 * (coord[1] + scrollGround) +  coord[0];	
			
			if (ground.size() > pos)
			return ground.get(pos);
			else
			{

			return null;
			}	
			
			
			}

		
	}
	
		return null;
	}



	public boolean isClickOnGround(int x, int y) {
	if (x>GROUND_X && x < GROUND_XEND)
		if (y>GROUND_Y && y<GROUND_YEND)
			return true;
	return false;
	}
	public boolean isClickOnGroundScroll(int x, int y) {
		if (x>GROUND_SCROLL_X && x < GROUND_SCROLL_XEND)
			if (y>GROUND_SCROLL_Y && y<GROUND_SCROLL_YEND)
				return true;
		return false;
		}
	
	public boolean isClickOnPackScroll(int x, int y) {
			if (x>PACK_SCROLL_X && x < PACK_SCROLL_XEND)
				if (y>PACK_SCROLL_Y && y<PACK_SCROLL_YEND)
					return true;
			return false;
			}


	public int[] getSlotCoord(int x, int y) 
	{
		int xx, yy;
		xx = x - SLOT_GRID_X;
		if (xx%SLOT_DISTANCE_X > 32)
			xx = -1;
		else
			xx = (xx / SLOT_DISTANCE_X);
		
		yy = y - SLOT_GRID_Y;
		if (yy%SLOT_DISTANCE_Y > 32)
			yy = -1;
		else
			yy = (yy / SLOT_DISTANCE_Y);
		
				
		int[] ret = new int[2];
		ret[0] = xx;
		ret[1] = yy;
		return ret;
		
	}


	public int[] getGroundSlotCoord(int x, int y) 
	{
		int xx, yy;
		xx = x - GROUND_X;
		if (xx%SLOT_DISTANCE_X > 32)
			xx = -1;
		else
			xx = (xx / SLOT_DISTANCE_X);
		
		yy = y - GROUND_Y;
		if (yy%SLOT_DISTANCE_Y > 32)
			yy = -1;
		else
			yy = (yy / SLOT_DISTANCE_Y);
		
				
		int[] ret = new int[2];
		ret[0] = xx;
		ret[1] = yy;
		return ret;
		
	}

	

	public boolean isClickOnHero(int x, int y) {
		if (x > HERO_X && x<HERO_XEND)
			if (y > HERO_Y && y<HERO_YEND)
				return true;
		return false;
	}



	public boolean isClickInBackpack(int x, int y) {
		if (x>SLOT_GRID_X && x < SLOT_GRID_XEND)
			if (y>SLOT_GRID_Y && y<SLOT_GRID_YEND)
				return true;
		return false;
	}









	public void renderDescription(HellbentGame hg) 
	{
		int x = DESC_X;
		int y = DESC_Y;
		
		if (displayed!=null)
		{
			
			hg.fontCommon.drawString(x, y, displayed.getName());
			
			
		}
		return;
		//TODO
	}









	public Item getDisplayed() {
		return displayed;
	}









	public void setDisplayed(Item displayed) {
		this.displayed = displayed;
	}
}
