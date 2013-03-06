package hellbent.util;

import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import hellbent.HellbentGame;
import hellbent.concepts.Skill;

public class SkillWidget {

	private static  int MAXSKILLS = 0;
	public HellbentGame h;
	private Image catbgImage;
	private Image catbgFocImage;
	private Image skillbgImage;
	private Image skillbgFocImage;
	private Image skillBar;
	private Image skillLevelElement;
	
	
	public static final int CATEGORIES_WIDTH = 310;
	public static final int CATEGORIES_HEIGHT = 150;

	public static final int SKILLS_WIDTH = 280;

	public static final int SKILLS_HEIGHT = 95;
	public static final int SKILLS_X = 350;
	public static final int CATEGORIES_X = 10;
	public static final int DESCRIPTION_X = 350 + 290;
	public static final int DESCRIPTION_Y = 10;
	
	public static final int DESC_HEIGHT = 400;
	public static final int DESC_WIDTH = 300;
	public static final int SKILLS_Y_INC = 100;
	private static final float SKILLPOINTS_X = 900;
	private static final float SKILLPOINTS_Y = 600;

	
	
	public int scroll = 0;
	String focusedCategory;
	String focusedSkill;

	Vector<Category> cats = new Vector<Category>();
	Vector<Skill> skills = new Vector<Skill>();
	private Image skillPointsElement;
	private Image skillDescriptionElement;
	public SkillWidget(HellbentGame hg) throws SlickException 
	{
		focusedCategory = "";
		catbgImage = new Image("resources/graphics/menus/skill_big.png");
		catbgFocImage = new Image("resources/graphics/menus/skill_big_focused.png");
		
		skillbgImage = new Image("resources/graphics/menus/skill_small.png");
		skillbgFocImage = new Image("resources/graphics/menus/skill_small_focused.png");
		
		skillBar = new Image("resources/graphics/menus/skill_bar.png");
		skillLevelElement = new Image("resources/graphics/menus/skill_element.png");
		skillPointsElement = new Image("resources/graphics/menus/skill_points.png");
		skillDescriptionElement = new Image("resources/graphics/menus/skill_desc.png");

		
		MAXSKILLS = (1024 / skillbgImage.getHeight() + 5);
		initCategories();
		
		h = hg;
	}
	private void initCategories() throws SlickException 
	{
		Category combat = new Category("COMBAT",new Image("resources/graphics/icons/combat_icon.png"));
		Category magic = new Category("MAGIC",new Image("resources/graphics/icons/combat_icon.png"));
		Category creation = new Category("CREATION",new Image("resources/graphics/icons/combat_icon.png"));
		Category art = new Category("ART",new Image("resources/graphics/icons/combat_icon.png"));
		Category misc = new Category("MISC",new Image("resources/graphics/icons/combat_icon.png"));
			
		
		combat.setDisplayname("Combat skills");
		combat.setDescription("assdadsa");
		
		cats.add(combat);
		cats.add(magic);
		cats.add(creation);
		cats.add(art);
		cats.add(misc);

		
	}
	public void renderCategories(HellbentGame hg) 
	{
		int displayint = 0;
		int initial = 5;
		for (Category i : cats)
		{
			if(i.getName() == focusedCategory)
			{
				i.render(catbgFocImage, 10, displayint * 152 + initial );
			}
			else
			{
				i.render(catbgImage, 10, displayint * 152 + initial);

			}
			displayint++;
		}
		
		
	}
	
	public void renderSkills(HellbentGame hg) 
	{

		if(focusedCategory != null)
		{
			skills = new Vector<Skill>();
			for (String i : hg.ge.pl.skills.keySet())
			{
				if (hg.ge.pl.skills.get(i).getCategory() == focusedCategory)
				{
					
					skills.add(hg.ge.pl.skills.get(i));
					
				}
			
			}
		
		
		for (int x=scroll;x<skills.size();x++)
		{
			Skill s = skills.get(x);
			if(x - scroll > MAXSKILLS)
				break;
			
			if (s.getName() == focusedSkill)
				skillbgFocImage.draw(SKILLS_X,(x-scroll)*SKILLS_Y_INC + 20);

			else
				skillbgImage.draw(SKILLS_X,(x-scroll)*SKILLS_Y_INC + 20);
			String name = s.getName();
			drawSkillName(x-scroll,name);
			int level = s.getLevel();
			drawSkillProgress(x-scroll,level);
			
			
			
		}
		
		}
	}
	private void drawSkillProgress(int x, int level) 
	{
		int y = (x+1) * 50 + 20;
	
		x = 370;
		skillBar.draw(x,y);
		for(int i=0;i<3;i++)
		{
			skillLevelElement.draw(379 + i*14,y+7);

		}
		

	}

	private void drawSkillName(int x, String name) 
	{
	int y = x * 100 + 20;
	x = 350;
	
	h.fontCommon.drawString(x+50, y+10, name,Color.red);
	
	}
	public void renderDescription(HellbentGame hg) 
	{
		
		skillDescriptionElement.draw(DESCRIPTION_X,DESCRIPTION_Y);
		
	}
	public void renderScroller(HellbentGame hg) {
		// TODO Auto-generated method stub
		
	}
	public void renderAbilities(HellbentGame hg) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void renderSkillPoints(HellbentGame hg)
	{
		
		skillPointsElement.draw(SKILLPOINTS_X,SKILLPOINTS_Y);
		
	}
	class Category
	{
		private String name;
		private String displayname = "";

		int cx,cy = 0;
		private String description = "";
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Image getIm() {
			return im;
		}
		public void setIm(Image im) {
			this.im = im;
		}
		Image im;
		public Category(String argname, Image argim)
		{
			this.name = argname;
			this.im = argim;
		}
		
		public void render(Image bgimage, int x, int y)
		{
			cx = x;
			cy = y;
			bgimage.draw(x,y);
			im.draw(x+50, y+50);
			drawDescription();
			drawName();
		}
		private void drawName() 
		{
			
			h.fontCommon.drawString(cx+5,cy+5,displayname);
		}
		private void drawDescription() 
		{
		
			h.fontCommon.drawString(cx+5,cy+15,description);

		}
		public String getDisplayname() {
			return displayname;
		}
		public void setDisplayname(String displayname) {
			this.displayname = displayname;
		}
	}

	public boolean isClickInCategories(int x, int y) {
		if (x < 310 && y < 750)
			return true;
		return false;
	}
	public String getActiveCategory(int x, int y) {
		y = y - 5;
		y = y / 152;
		return cats.get(y).getName();
		
	}
	public boolean isClickInSkills(int x, int y) {
		if (x > SKILLS_X && y < 750)
			return true;
		return false;
	}
	
	public boolean isClickInDescription(int x, int y)
	{
		return false;
		
		
	}
	
	

	public String getSkillAt(int x, int y)
	{
		Skill s = null;
		y = y - 20;
		if (y<0 || y > 728)
			return "";
		
		if (y%SKILLS_Y_INC > 95)
			return "";
		
		
		int position = y/SKILLS_Y_INC;
		
		
		if (skills.size() > position)
		{
			s =  skills.get(position);
		}
		
		if (s!= null)
	return s.getName();
		else return ""; 
	}
	
}
