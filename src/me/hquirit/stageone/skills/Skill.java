package me.hquirit.stageone.skills;

import java.io.Serializable;

public class Skill implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8634634249660722583L;
	
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
	
	public String getName()
	{
		return name;
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
