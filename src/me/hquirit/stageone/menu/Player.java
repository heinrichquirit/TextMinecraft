package me.hquirit.stageone.menu;

import java.io.Serializable;

import me.hquirit.stageone.skills.CombatSkill;
import me.hquirit.stageone.skills.ExploringSkill;
import me.hquirit.stageone.skills.FarmingSkill;
import me.hquirit.stageone.skills.MageSkill;
import me.hquirit.stageone.skills.PlayerInventory;
import me.hquirit.stageone.utils.Utils;

public class Player implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5835463986102424614L;
	
	private String name;
	private int maxHp;
	private int physDmgOutput;
	private int mgcDmgOutput;
	private PlayerInventory inventory;
	
	/* Stats */
	// Farming Skill (Increase the amount you gain from resources) Max Level 5 for all skills
	// Exploring Skill (Higher percent chance of obtaining random items) 1x, 2x, 3x, 4x, 5x item drop amount will be
	// multiplied by the numbers in accordance to the skill level
	// Combat Skill (Increase Damage output) 
	// Mage Skill (Increase Magic Damage Output)
	private CombatSkill cSkill;
	private ExploringSkill eSkill;
	private FarmingSkill fSkill;
	private MageSkill mSkill;
	
	public Player()
	{
		name = "";
		maxHp = 100;
		physDmgOutput = 25;
		mgcDmgOutput = 25;
		inventory = new PlayerInventory();
		// Skills
		cSkill = new CombatSkill();
		eSkill = new ExploringSkill();
		fSkill = new FarmingSkill();
		mSkill = new MageSkill();
	}
	
	public void sendMessage(String msg)
	{
		Utils.print(msg);
	}
	
	public void sendFMessage(String msg, Object... args) 
	{
		System.out.printf(msg + "\n", args);
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setMaxHp(int maxHp)
	{
		this.maxHp = maxHp;
	}
	
	public int getMaxHp()
	{
		return maxHp;
	}
	
	public void setPhysDamage(int dmg)
	{
		physDmgOutput = dmg;
	}
	
	public int getPhysDamage()	
	{
		int combatLvl = cSkill.getSkillLevel();
		switch(combatLvl) 
		{
			case 1:
				return physDmgOutput *= 2;
			case 2:
				return physDmgOutput *= 3;
			case 3:
				return physDmgOutput *= 4;
			case 4:
				return physDmgOutput *= 5;
			case 5:
				return physDmgOutput *= 6;
			default:
				return physDmgOutput;
		}
	}
	
	public void setMagicDamage(int dmg)
	{
		mgcDmgOutput = dmg;
	}
	
	public int getMagicDamage()
	{
		int mageLvl = mSkill.getSkillLevel();
		switch(mageLvl) 
		{
			case 1:
				return mgcDmgOutput *= 2;
			case 2:
				return mgcDmgOutput *= 3;
			case 3:
				return mgcDmgOutput *= 4;
			case 4:
				return mgcDmgOutput *= 5;
			case 5:
				return mgcDmgOutput *= 6;
			default:
				return mgcDmgOutput;
		}
	}
	
	public PlayerInventory getInventory()
	{
		return inventory;
	}
	
	public CombatSkill getCombatSkill()
	{
		return cSkill;
	}
	
	public ExploringSkill getExploringSkill()
	{
		return eSkill;
	}
	
	public FarmingSkill getFarmingSkill()
	{
		return fSkill;
	}
	
	public MageSkill getMageSkill()
	{
		return mSkill;
	}
	
}
