package me.hquirit.stageone.menu;

import java.io.Serializable;

import me.hquirit.stageone.skills.CombatSkill;
import me.hquirit.stageone.skills.ExploringSkill;
import me.hquirit.stageone.skills.FarmingSkill;
import me.hquirit.stageone.skills.MageSkill;
import me.hquirit.stageone.skills.PlayerInventory;

public class Player implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5835463986102424614L;
	
	private String name;
	private int maxHp;
	private int currentHp;
	private int maxMana;
	private int currentMana;
	private PlayerInventory inventory;
	
	/* Stats */
	// Farming Skill (Increase the amount you gain from resources) Max Level 5 for all skills
	// Exploring Skill (Higher percent chance of obtaining random items) 10% increase per level
	// Combat Skill (Increase Damage output) 
	// Mage Skill (Increase Magic Damage Output)
	private CombatSkill cSkill;
	private ExploringSkill eSkill;
	private FarmingSkill fSkill;
	private MageSkill mSkill;
	
	public Player()
	{
		name = "";
		maxHp = 100;
		currentHp = 100;
		maxMana = 100;
		currentMana = 100;
		inventory = new PlayerInventory();
		// Skills
		cSkill = new CombatSkill();
		eSkill = new ExploringSkill();
		fSkill = new FarmingSkill();
		mSkill = new MageSkill();
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setMaxHp(int maxHp)
	{
		this.maxHp = maxHp;
	}
	
	public int getMaxHp()
	{
		return maxHp;
	}
	
	public void setCurrentHp(int currHp) 
	{
		currentHp = currHp;
	}
	
	public int getCurrentHp()
	{
		return currentHp;
	}
	
	public void setMaxMana(int maxMana)
	{
		this.maxMana = maxMana;
	}
	
	public int getMaxMana()
	{
		return maxMana;
	}
	
	public void setCurrentMana(int currMana)
	{
		this.currentMana = currMana;
	}
	
	public int getCurrentMana()
	{
		return currentMana;
	}
	
	public PlayerInventory getInventory()
	{
		return inventory;
	}
	
	public CombatSkill getCombatSkill()
	{
		return cSkill;
	}
	
	public ExploringSkill getExploringSkill()
	{
		return eSkill;
	}
	
	public FarmingSkill getFarmingSkill()
	{
		return fSkill;
	}
	
	public MageSkill getMageSkill()
	{
		return mSkill;
	}
	
}
