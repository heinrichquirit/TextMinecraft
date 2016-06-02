package me.hquirit.stageone.utils;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import me.hquirit.stageone.menu.Player;

public class StatsDialog extends JDialog
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4061660074266313274L;
	
	private Player player;
	private String stats;
	
	public StatsDialog(Player player)
	{
		this.player = player;
		
		stats = "Name: " + player.getName() + "\n"
			  + "Max Hp: " + player.getMaxHp() + "\n"
			  + "Physical Damage: " + player.getPhysDamage() + "\n"
			  + "Magical Damage: " + player.getMagicDamage() + "\n"
			  + "Combat Level: " + player.getCombatSkill().getSkillLevel() + "\n"
			  + "Exploring Level: " + player.getExploringSkill().getSkillLevel() + "\n"
			  + "Farming Level: " + player.getFarmingSkill().getSkillLevel() + "\n"
			  + "Mage Level: " + player.getMageSkill().getSkillLevel();
		
	}
	
	public void show()
	{
		JOptionPane.showMessageDialog(null, stats, player.getName() + "'s Statistics", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public String getStatsMessage()
	{
		return stats;
	}
	
}
