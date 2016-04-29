package me.hquirit.stageone.menu;

import me.hquirit.stageone.utils.Utils;

public class FarmCommand extends BaseCommand {

	private String cmd;
	private String description;
	
	public FarmCommand()
	{
		cmd = "farm";
		description = "Farm resources for suvivability and stat increase. "
				+ "Obtain either wheat or seeds as you farm"
				+ "Farm 3 times in total to increase your level.";
	}
	
	@Override
	public void execute(Player player) {
		// TODO Auto-generated method stub
		// farm and collect resources stuff
		Utils.print("You have chosen to farm for the day.");
		Utils.print(description);
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
