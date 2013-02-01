package hellbent.util;

import org.newdawn.slick.Input;

import hellbent.HellbentGame;
import hellbent.concepts.Formulas;
import hellbent.concepts.Item;
import hellbent.content.actions.Equip;
import hellbent.content.actions.Unequip;
import hellbent.entity.Entity;
import hellbent.states.InventoryState;

public class InventoryControl {

	private InventoryState is;
	HellbentGame hg;
	
	public InventoryState getIs() {
		return is;
	}

	public void setIs(InventoryState is) {
		this.is = is;
	}

	static int EXIT_KEY;

	public InventoryControl(HellbentGame hg) {
		this.hg = hg;
		initConfig();
	}

	public void initConfig() {
		
		EXIT_KEY = Input.KEY_ESCAPE;

	}

	public void loadKeyConfig() {

	}

	public String saveKeyConfig() {
		return "";

	}

	public void KeyBindings() {

	}

	public void keyPressed(int key, char c) {

		if (key == EXIT_KEY) {
			is.statechange = HellbentGame.GAMEPLAYSTATE;
		}

		
	}

	public void keyReleased(int key, char c) {



		}

	public void mouseReleased(int button, int x, int y) 
	{
		switch(button)
		{
		// 0 - left button
		case 0:
			
		if (is.iw.isDragging())
		{
			if(is.iw.getDragged().get("EQUIPPED") == 1)
			{
				if (is.iw.isClickInBackpack(x, y))
				{
					hg.ge.pl.setAction(new Unequip(hg.ge.pl,is.iw.getDragged()));
					System.out.println("CLICK IN BACKPACK");
					hg.ge.TURN();
				}
			}
			
			for(int[] k : is.iw.SLOTS)
			{
				
				if (Utilities.distance(x,y,k[0]+16,k[1]+16) < 20)
				{
					int slotid =  k[2];
					int equipslotid = is.iw.getDragged().get("EQUIP_SLOT");
					
					if (Formulas.slotCheck(equipslotid,slotid))
					{
						if (equipslotid == Formulas.HANDS)
						{
							equipItemAtSlot(is.iw.getDragged(),Formulas.RIGHT_HAND);
							equipItemAtSlot(is.iw.getDragged(),Formulas.LEFT_HAND);

						}
						else	
							equipItemAtSlot(is.iw.getDragged(),slotid);
						
					}
					
					
				}
			
		}
		}
		is.iw.setDragged(null);
		is.iw.setDragging(false);
			
		
			break;
		}
		
	}

	private void equipItemAtSlot(Item dragged, int slotid) 
	{
		if (hg.ge.pl.getItemAtSlot(slotid) == null)
		{
			
			if (dragged.get("EQUIPPED") == 1)
			{
				hg.ge.pl.setAction(new Unequip(hg.ge.pl,dragged));
			}
			
		hg.ge.pl.setAction(new Equip(hg.ge.pl,dragged,slotid));
		hg.ge.TURN();

		}
		else
		{
			if (dragged.get("EQUIPPED") == 1)
			{
				hg.ge.pl.setAction(new Unequip(hg.ge.pl,dragged));
			}
			
			hg.ge.pl.setAction(new Unequip(hg.ge.pl,hg.ge.pl.getItemAtSlot(slotid)));
			hg.ge.pl.setAction(new Equip(hg.ge.pl,dragged,slotid));
			hg.ge.TURN();
		}		
	}

	public void mousePressed(int button, int x, int y) 
	{
		
		switch(button)
		{
		// 0 - left button
		case 0:
		if(!is.iw.isDragging())
		{

			Item i = is.iw.getItemAt(x,y);
			if (i != null)
					{
				is.iw.setDragged(i);
				is.iw.setDragging(true);
					}
			
		}
		break;
			
		// 1 - right button
		case 1:
		break;
			
		}
	}
	}


