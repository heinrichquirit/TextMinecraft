package me.hquirit.stageone.commands;

import java.util.Random;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.utils.Utils;

public class ExploreCommand extends BaseCommand
{
	
	private String cmd;
	private String description;
	
	public ExploreCommand()
	{
		cmd = "explore";
		description = "Explore caves or mine rocks to obtain either cobblestone or coal.\n"
				    + "1x, 2x, 3x, 4x, 5x item drop amount will be multiplied by the\n "
				    + "number in accordance to the skill level\n"
				    + "Explore 3 times in total to increase your level.";
	}
	
	public void execute(Player player) 
	{
		player.sendMessage("You have chosen to explore for the day.");
		player.sendMessage(description);
		
		Random r = new Random();
		int n = r.nextInt(2);
		String cobble = "Cobblestone";
		String coal = "Coal";
		int amount = 1;
		Utils.debug(player.getExploringSkill());
		if (n == 0)
		{
			if (player.getInventory().containsItem(cobble))
			{
				player.getInventory().put(cobble, player.getInventory().getItemCount(cobble) + multiply(player, amount));
				player.sendMessage("You received cobble, you now have '" + player.getInventory().getItemCount(cobble) + "' cobble.");
			}
			else 
			{
				player.getInventory().put(cobble, 1 + multiply(player, amount));
				player.sendMessage("You received cobble, you now have '" + player.getInventory().getItemCount(cobble) + "' cobble.");
			}
		}
		else if (n == 1)
		{
			if (player.getInventory().containsItem(coal))
			{
				player.getInventory().put(coal, player.getInventory().getItemCount(coal) + multiply(player, amount));
				player.sendMessage("You received coal, you now have '" + player.getInventory().getItemCount(coal) + "' coal.");
			}
			else 
			{
				player.getInventory().put(coal, 1 + multiply(player, amount));
				player.sendMessage("You received coal, you now have '" + player.getInventory().getItemCount(coal) + "' coal.");
			}
		}
		
		// If count is 3, level up skill
		if (player.getExploringSkill().getSelectionCount() == 3)
		{
			if (player.getExploringSkill().getSkillLevel() == 5)
			{
				return;
				// Stop the user from leveling up
			}
			player.getExploringSkill().levelUp();
			player.sendMessage("You have leveled up! You are now level " + player.getExploringSkill().getSkillLevel() + "!");
		}
		else
		{
			player.getFarmingSkill().increaseCount();
		}
	}
	
	public int multiply(Player player, int amount)
	{
		int level = player.getExploringSkill().getSkillLevel();
		switch(level)
		{
			case 1:
				return amount *= 1;
			case 2:
				return amount *= 2;
			case 3:
				return amount *= 3;
			case 4: 
				return amount *= 4;
			case 5:
				return amount *= 5;
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
