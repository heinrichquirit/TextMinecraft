package me.hquirit.stageone.commands;

import java.util.Random;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.utils.Utils;

public class FarmCommand extends BaseCommand {

	private String cmd;
	private String description;
	
	public FarmCommand()
	{
		cmd = "farm";
		description = "Farm resources for suvivability and increase your stats. "
				+ "Obtain either wheat or seeds as you farm\n"
				+ "Farm 3 times in total to increase your level.";
	}
	
	@Override
	public void execute(Player player) {
		Utils.print("You have chosen to farm for the day.");
		Utils.print(description);
		
		// Reward player code
		Random rand = new Random();
		// 50% chance of obtaining wheat, vice-versa
		int n = rand.nextInt(2);
		String wheat = "Wheat";
		String seed = "Seed";
		if (n == 0)
		{
			if (player.getInventory().containsItem(wheat))
			{
				player.getInventory().incrementItem(wheat);
				player.sendMessage("You received wheat, you now have '" + player.getInventory().getItemCount(wheat) + "' wheat.");
			}
			else 
			{
				player.getInventory().put(wheat, 1);
				player.sendMessage("You received wheat, you now have '" + player.getInventory().getItemCount(wheat) + "' wheat.");
			}
			
		}
		else if (n == 1)
		{
			if (player.getInventory().containsItem(seed))
			{
				player.getInventory().incrementItem(seed);
				player.sendMessage("You received a seed, you now have '" + player.getInventory().getItemCount(seed) + "' seed(s).");
			}
			else
			{
				player.getInventory().put(seed, 1);
				player.sendMessage("You received a seed, you now have '" + player.getInventory().getItemCount(seed) + "' seed(s).");
			}
		}
		
		// If count is 3, level up skill
		if (player.getFarmingSkill().getSelectionCount() == 3)
		{
			player.getFarmingSkill().levelUp();
			player.sendMessage("You have leveled up! You are now level " + player.getFarmingSkill().getSkillLevel() + "!");
		}
		else
		{
			player.getFarmingSkill().increaseCount();
		}
		
	}
	
	public String getName()
	{
		return cmd;
	}
	
	public String getDescription()
	{
		return description;
	}

}
