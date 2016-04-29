package me.hquirit.stageone.skills;

public class CombatSkill extends Skill
{

	private String name;
	private int skillLevel;
	private int selectionCount;
	
	public CombatSkill()
	{
		name = "";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public CombatSkill(String name, int skillLevel, int selectionCount)
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
