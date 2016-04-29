package me.hquirit.stageone.skills;

public class Skill
{
	private String name;
	/* Max Count 3
	 * This variable stores how many times the user has selected this option in 
	 * the command menu in order to keep track on when they can level up */
	private int skillLevel;
	private int selectionCount;
	/* Max 5 */
	
	public Skill()
	{
		name = "";
		skillLevel = 0;
		selectionCount = 0;
	}
	
	public void levelUp()
	{
		if (skillLevel != 5)
		{
			skillLevel += 1;
		}
	}
	
	public void levelDown()
	{
		if (skillLevel != 0)
		{
			skillLevel -= 1;
		}
	}
	
	/**
	 * Get current skill level
	 * @return
	 */
	public int getSkillLevel()
	{
		return skillLevel;
	}
	
	/**
	 * Get the current count of selection count
	 * @return
	 */
	public int getSelectionCount()
	{
		return selectionCount;
	}
	
}
