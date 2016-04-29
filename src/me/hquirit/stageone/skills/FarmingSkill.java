package me.hquirit.stageone.skills;

public class FarmingSkill extends Skill 
{
	
	private String name;
	private int skillLevel;
	// How many times the character has selected this skill, it will reset after 3 counts and level up the skill
	private int selectionCount;
	
	public FarmingSkill()
	{
		name = "";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public FarmingSkill(int skillLevel, int selectionCount)
	{
		name = "FarmingSkill";
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
	
}
