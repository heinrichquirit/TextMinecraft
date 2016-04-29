package me.hquirit.stageone.skills;

public class CombatSkill extends Skill
{

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
	
}
