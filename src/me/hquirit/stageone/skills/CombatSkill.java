package me.hquirit.stageone.skills;

import java.io.Serializable;

public class CombatSkill extends Skill implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5071027997445524912L;
	
	private String name;
	private int skillLevel;
	private int selectionCount;
	
	public CombatSkill()
	{
		name = "CombatSkill";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public CombatSkill(int skillLevel, int selectionCount)
	{
		name = "CombatSkill";
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
		if (skillLevel <= 5 && selectionCount == 3)
		{
			skillLevel += 1;
			selectionCount = 0;
		}
	}
	
}
