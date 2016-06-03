package me.hquirit.stageone.commands;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map.Entry;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.utils.DataTable;
import me.hquirit.stageone.utils.StatsDialog;

public class ViewStatsCommand extends BaseCommand
{

	private String cmd;
	private String description;
	
	public ViewStatsCommand()
	{
		cmd = "view_stats";
		description = "You can view certain attributes of your character.\n"
				    + "These include information about your health and mana\n"
				    + "as well inventory contents and skill levels.";
	}
	
	public void execute(Player player) 
	{
		player.sendMessage("Displaying information in a window dialog, please wait...");
		HashMap<String, Integer> playerMap = player.getInventory().getMap();
		int size = playerMap.size();
		String[] columns = {"Item", "Amount"};
		Object[][] data = new Object[size][size];
		if (size != 0)
		{
			int count = 0;
			for (Entry<String, Integer> entries : playerMap.entrySet())
			{
				data[count][0] = entries.getKey();
				data[count][1] = entries.getValue(); // Fix
				count++;
			}
		}
		DataTable table = new DataTable(data, columns, 300, 225);
		StatsDialog dialog = new StatsDialog(player);
		dialog.setLocationRelativeTo(table);
		table.display(player.getName() + "'s Inventory", 300, 225);
		dialog.show();
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
