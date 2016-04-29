package me.hquirit.stageone.skills;

public class ExploringSkill extends Skill
{
	
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
	
}
