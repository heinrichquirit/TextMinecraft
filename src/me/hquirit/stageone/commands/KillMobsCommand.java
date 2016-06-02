package me.hquirit.stageone.commands;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.utils.CombatManager;

public class KillMobsCommand extends BaseCommand
{

	private String cmd;
	private String description;
	
	public KillMobsCommand()
	{
		cmd = "kill_mobs";
		description = "Venture out and fight slimes or zombies to increase your damage output.\n"
				+ "When you fight a mob, you have the option to use magic or physical damage.\n"
				+ "Your damage will level up and multiplied by your original damage\n"
				+ "according to which type of damage you use in combat (2x, 3x, 4x, 5x, 6x).";
	}
	
	public void execute(Player player) {
		player.sendMessage("You have chosen to fight a mob for the day.");
		player.sendMessage(description);
		CombatManager cm = new CombatManager(player);
		cm.startCombat(player);
	}

}
