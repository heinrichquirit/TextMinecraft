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
	
	public FarmingSkill(String name, int skillLevel, int selectionCount)
	{
		this.name = name;
		this.skillLevel = skillLevel;
		this.selectionCount = selectionCount;
	}
	
	public int getSkillLevel()
	{
		return skillLevel;
	}
	
	public int getSelectionCount()
	{
		return selectionCount;
	}
	
}
