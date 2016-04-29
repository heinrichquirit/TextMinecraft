package me.hquirit.stageone.menu;

import java.io.Serializable;

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
	
	/* Stats */
	// Farming Skill (Increase the amount you gain from resources) Max Level 5 for all skills
	// Exploring Skill (Higher percent chance of obtaining random items) 10% increase per level
	// Combat Skill (Increase Damage output) 
	// Mage Skill (Increase Magic Damage Output)
	private int farmingLvl;
	private int exploringLvl;
	private int combatLvl;
	private int mageLvl;
	private int[] skills = {farmingLvl, exploringLvl, combatLvl, mageLvl};
	
	public Player()
	{
		name = "";
		maxHp = 100;
		currentHp = 100;
		maxMana = 100;
		currentMana = 100;
		farmingLvl = 1;
		exploringLvl = 1;
		combatLvl = 1;
		mageLvl = 1;
	}
	
	public Player(String name, int maxHp, int currentHp, int maxMana, int currentMana, 
			int farmingLvl, int exploringLvl, int combatLvl, int mageLvl)
	{
		setName(name);
		setMaxHp(maxHp);
		setCurrentHp(currentHp);
		setMaxMana(maxMana);
		setCurrentMana(currentMana);
		setSkillLevel(0, farmingLvl);
		setSkillLevel(1, exploringLvl);
		setSkillLevel(2, combatLvl);
		setSkillLevel(3, mageLvl);
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
	
	public void setSkillLevel(int arg, int level)
	{
		skills[arg] = level;
	}
	
	public int getSkillLevel(int arg)
	{
		return skills[arg];
	}
	
	/*
	
	public Player name(String name)
	{
		this.name = name;
		return this;
	}
	
	public Player health(int health)
	{
		this.health = health;
		return this;
	}
	
	public Player mana(int mana)
	{
		this.mana = mana;
		return this;
	}
	
	public Player farmingLvl(int level)
	{
		farmingLvl = level;
		return this;
	}
	
	public Player exploringLvl(int level)
	{
		exploringLvl = level;
		return this;
	}
	
	public Player combatLvl(int level)
	{
		combatLvl = level;
		return this;
	}
	
	public Player mageLvl(int level)
	{
		mageLvl = level;
		return this;
	}
	
	public Player build()
	{
		return new Player(name, health, mana, farmingLvl, exploringLvl, combatLvl, mageLvl);
	}
	
	*/
	
}
