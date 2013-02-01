package hellbent.util;

import java.util.Vector;

import org.newdawn.slick.Input;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.entity.Player;

public class InventoryWidget {
	
	HellbentGame h;
	public InventoryWidget(HellbentGame hg)
	{
		h = hg;
	SLOTS = new Vector<int[]>();
	
	int slot[] = new int[3];
	slot[0] = 64;
	slot[1] = 484;
	slot[2] = Formulas.LEFT_HAND;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 394;
	slot[1] = 426;
	slot[2] = Formulas.RIGHT_HAND;
	SLOTS.add(slot);
	/*
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.NECK;
	SLOTS.add(slot);
	slot= new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.TORSO;
	SLOTS.add(slot);
	
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.TRINKET_1;
	SLOTS.add(slot);
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.TRINKET_2;
	SLOTS.add(slot);
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.TOOL;
	SLOTS.add(slot);
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.CLOAK;
	SLOTS.add(slot);
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.BOOTS;
	SLOTS.add(slot);
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.TAIL;
	SLOTS.add(slot);
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.MISSILE;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.MISSILE_WEAPON;
	SLOTS.add(slot);
	
	slot = new int[3];
	slot[0] = 0;
	slot[1] = 1;
	slot[2] = Formulas.LEGS;
	SLOTS.add(slot);
		*/
	}
	
	private boolean dragging = false;
	Vector<Item> inv;
	Vector<Item> invDisplay;
	private int SORT = ALL;
	private Item dragged = null;
	
	public Vector<int[]> SLOTS;
	
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

	public static final int SLOT_DISTANCE_Y = 43;

	public static final int SLOT_DISTANCE_X = 43;
	public static final int SLOT_PER_ROW = 9;
	public static final int SLOT_PER_FIRST_TWO_ROWS = 7;

	public static final int SLOT_PER_COLUMN = 7;
	
	public static final int SLOT_GRID_X = 546;
	public static final int SLOT_GRID_Y = 392;
	public static final int SLOT_GRID_XEND = 923;
	public static final int SLOT_GRID_YEND = 683;
	private static final int HERO_X = 11;
	private static final int HERO_XEND = 511;
	private static final int HERO_Y = 11;
	private static final int HERO_YEND = 755;

	
	
	public void renderItems(HellbentGame hg) 
	{
		invDisplay = new Vector<Item>();
		Player tmp = hg.ge.pl;
		inv = tmp.inventory;
		int slots = 0;
		if(dragging && dragged != null)
		{
			 
	        int mouseX = hg.in.getMouseX();
	        int mouseY = hg.in.getMouseY();
			dragged.getSprite().draw(mouseX-10,mouseY-10);
		}
		int x = 0;
		int y = 0;
		
		for (Item i : inv)
		{
			
			if (i.get("EQUIPPED") == 0)
			{
			if (i.get("TYPE") == SORT || SORT == ALL)
			{
				invDisplay.add(i);
				i.getSprite().draw(x*SLOT_DISTANCE_X+SLOT_GRID_X, y*SLOT_DISTANCE_Y+SLOT_GRID_Y);
			}
			x = x + 1;
			
			if (y > 1)
				slots = SLOT_PER_ROW;
			else
				slots = SLOT_PER_FIRST_TWO_ROWS;
			
			if (x+1 > slots)
			{
				y++;
				x = 0;
			}
			
			if (y > SLOT_PER_COLUMN)
			{
				break;
			}
		}
			
		}
	
		for (int[] i : SLOTS)
		{
			Item it = tmp.getItemAtSlot(i[2]);
			if (it != null)
			{
				it.getSprite().draw(i[0],i[1]);
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
			if (coord[1]<2)
			{
			pos = SLOT_PER_FIRST_TWO_ROWS * coord[1] +  coord[0];	
			}
			else
			{
			pos = SLOT_PER_FIRST_TWO_ROWS * 2;
			pos = pos + SLOT_PER_ROW * (coord[1]-2) +  coord[0];	
			}

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
		return null;
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
}
