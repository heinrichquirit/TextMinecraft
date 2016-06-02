package me.hquirit.stageone.skills;

import java.io.Serializable;

public class ExploringSkill extends Skill implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5155532481339206494L;
	
	private String name;
	private int skillLevel;
	private int selectionCount;
	
	public ExploringSkill()
	{
		name = "ExploringSkill";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public ExploringSkill(int skillLevel, int selectionCount)
	{
		name = "ExploringSkill";
		this.skillLevel = skillLevel;
		this.selectionCount = selectionCount;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setSkillLevel(int skillLevel)
	{
		this.skillLevel = skillLevel;
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
