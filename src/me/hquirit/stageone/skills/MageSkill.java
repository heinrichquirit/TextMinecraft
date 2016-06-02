package me.hquirit.stageone.skills;

import java.io.Serializable;

public class MageSkill extends Skill implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6511365785150429193L;
	
	private String name;
	private int skillLevel;
	// How many times the character has selected this skill, it will reset after 3 counts and level up the skill
	private int selectionCount;
	
	public MageSkill()
	{
		name = "";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public MageSkill(int skillLevel, int selectionCount)
	{
		name = "MageSkill";
		this.skillLevel = skillLevel;
		this.selectionCount = selectionCount;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setSkillLevel(int skillLevel)
	{
		this.skillLevel	= skillLevel;
	}
	
	public int getSkillLevel()
	{
		return skillLevel;
	}
	
	public void setSelectionCount(int selectionCount)
	{
		this.selectionCount = selectionCount;
	}
	
	public int getSelectionCount()
	{
		return selectionCount;
	}
	
	public void increaseCount()
	{
		if (selectionCount < 3)
		{
			selectionCount += 1;
		}
	}
	
	public void decreaseCount()
	{
		if (selectionCount > 0)
		{
			selectionCount -= 1;
		}
	}
	
	public void levelUp()
	{
		if (skillLevel == 5)
		{
			skillLevel += 0;
		}
		else if (skillLevel < 5 && selectionCount == 3)
		{
			skillLevel += 1;
			selectionCount = 0;
		}
	}
	
}
