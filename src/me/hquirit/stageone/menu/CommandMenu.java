package me.hquirit.stageone.menu;

import java.io.File;
import java.util.Scanner;

import me.hquirit.stageone.utils.ObjectFileWriter;
import me.hquirit.stageone.utils.Utils;

public class CommandMenu 
{

	private Player player = new Player();
	
	public CommandMenu()
	{
	}
	
	public void runInitialMenu()
	{
		Scanner input = new Scanner(System.in);
		
		Utils.print("==============================");
		Utils.print("Input is case sensitive, please select an option.");
		Utils.print("1. New Character");
		Utils.print("2. Load Character");
		Utils.print("==============================");
		
		int selection = input.nextInt();
		
		switch(selection)
		{
			case 1:
				// do stuff
				Utils.print("Please enter your characters name.");
				while(input.hasNext())
				{
					// Consume new-line leftover
					input.nextLine();
					String newName = input.nextLine();
					// check if name exists by comparing de-serialized file name objects and prevent
					// duplicates
					if (Utils.fileExists(newName))
					{
						Utils.print("A character with the name '" + newName + "' already exists!");
						runInitialMenu();
					}
					player.setName(newName);
					Utils.print("You have created a character named '" + newName + "' !");
					File newPlayer = new File("players/" + newName + ".dat");
					ObjectFileWriter writer = new ObjectFileWriter(newPlayer, player);
					writer.save();
					Utils.print("Player saved!");
					runTaskMenu();
				}
				break;
			case 2:
				Utils.print("Please enter a characters name you wish to load.");
				while(input.hasNext())
				{
					// Consume new-line leftover
					input.nextLine();
					String loadName = input.nextLine();
					if (!Utils.fileExists(loadName))
					{
						Utils.print("A character with the name '" + loadName + "' does not exist!"); 
						runInitialMenu();
					}
					player = Stage1.getInstance().getObjReader().getPlayer(loadName);
					Utils.print("Successfully loaded player '" + player.getName() + "' !");
					runTaskMenu();
				}
				break;
			default:
				Utils.print("Option does not exist.");
				runInitialMenu();
				break;
		}
		
	}
	
	private void runTaskMenu()
	{
		Scanner input = new Scanner(System.in);
		
		Utils.print("==============================");
		Utils.print("Please enter one of the following commands.");
		Utils.print("Today is a new a day, what would you like to do?");
		Utils.print("Farm");
		Utils.print("Explore");
		Utils.print("Kill_mobs");
		Utils.print("Exit");
		Utils.print("==============================");
		
		String cmd = input.nextLine();
		if (cmd.equalsIgnoreCase("farm"))
		{
			new FarmCommand().execute(player);
			// Save player/all data
			File playerData = new File("players/" + player.getName() + ".dat");
			ObjectFileWriter writer = new ObjectFileWriter(playerData, player);
			writer.save();
			Utils.print("Your progress has been saved.");
			Utils.print("==============================");
			Utils.print("Would you like to continue? Hit y/n");
			// Consume new-line leftover
			input.nextLine();
			String answer = input.nextLine();
			if (answer.equalsIgnoreCase("y"))
			{
				runTaskMenu();
			}
			else if (answer.equalsIgnoreCase("n"))
			{
				Utils.print("You have exited the game.");
			}
		}
		else if (cmd.equalsIgnoreCase("exit"))
		{
			Utils.print("You have exited the program.");
		}
		else
		{
			Utils.print("That command does not exist!");
		}
	}
	
}
