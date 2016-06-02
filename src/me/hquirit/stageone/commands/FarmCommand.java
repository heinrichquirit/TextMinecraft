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
		description = "Farm resources for suvivability and increase your stats.\n"
				    + "Obtain either wheat or seeds as you farm\n"
				    + "2x, 4x, 6x, 8x, 10x item drop amount will be multiplied by the\n "
				    + "number in accordance to the skill level"
				    + "Farm 3 times in total to increase your level.";
	}
	
	public void execute(Player player) {
		player.sendMessage("You have chosen to farm for the day.");
		player.sendMessage(description);
		
		// Reward player code
		Random rand = new Random();
		// 50% chance of obtaining wheat, vice-versa
		int n = rand.nextInt(2);
		String wheat = "Wheat";
		String seed = "Seed";
		int amount = 1;
		if (n == 0)
		{
			if (player.getInventory().containsItem(wheat))
			{
				player.getInventory().put(wheat, player.getInventory().getItemCount(wheat) + multiply(player, amount));
				player.sendMessage("You received wheat, you now have '" + player.getInventory().getItemCount(wheat) + "' wheat.");
			}
			else 
			{
				player.getInventory().put(wheat, 1 + multiply(player, amount));
				player.sendMessage("You received wheat, you now have '" + player.getInventory().getItemCount(wheat) + "' wheat.");
			}
			
		}
		else if (n == 1)
		{
			if (player.getInventory().containsItem(seed))
			{
				player.getInventory().put(seed, player.getInventory().getItemCount(seed) + multiply(player, amount));
				player.sendMessage("You received a seed, you now have '" + player.getInventory().getItemCount(seed) + "' seed(s).");
			}
			else
			{
				player.getInventory().put(seed, 1 + multiply(player, amount));
				player.sendMessage("You received a seed, you now have '" + player.getInventory().getItemCount(seed) + "' seed(s).");
			}
		}
		
		// If count is 3, level up skill
		if (player.getFarmingSkill().getSelectionCount() == 3)
		{
			if (player.getFarmingSkill().getSkillLevel() <= 5)
			{
				player.getFarmingSkill().levelUp();
				player.sendMessage("You have leveled up! You are now level " + player.getFarmingSkill().getSkillLevel() + "!");
			}
		}
		else
		{
			player.getFarmingSkill().increaseCount();
		}
		
	}
	
	public int multiply(Player player, int amount)
	{
		int level = player.getFarmingSkill().getSkillLevel();
		switch(level)
		{
			case 1:
				return amount *= 2;
			case 2:
				return amount *= 4;
			case 3:
				return amount *= 6;
			case 4: 
				return amount *= 8;
			case 5:
				return amount *= 10;
			default:
				return 0;
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
