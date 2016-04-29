package me.hquirit.stageone.skills;

public class ExploringSkill extends Skill
{
	
	private String name;
	private int skillLevel;
	private int selectionCount;
	
	public ExploringSkill()
	{
		name = "";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public ExploringSkill(String name, int skillLevel, int selectionCount)
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
