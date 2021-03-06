package me.hquirit.stageone.menu;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

import me.hquirit.stageone.commands.ExploreCommand;
import me.hquirit.stageone.commands.FarmCommand;
import me.hquirit.stageone.commands.KillMobsCommand;
import me.hquirit.stageone.commands.ViewStatsCommand;
import me.hquirit.stageone.utils.ObjectFileWriter;
import me.hquirit.stageone.utils.TableFrame;
import me.hquirit.stageone.utils.Utils;

public class CommandMenu 
{
	/*
	 * COMPLETE: View all player stats
	 * COMPLETE: Kill mobs command
	 */

	private Player player = new Player();
	private List<String> names = new ArrayList<String>();
	
	public CommandMenu()
	{
		// Populate names array list
		for (Player p : Stage1.getInstance().getPlayers())
		{
			names.add(p.getName());
		}
	}
	
	public void runInitialMenu()
	{
		Scanner input = new Scanner(System.in);
		
		Utils.print("==============================");
		Utils.print("Please select an option.");
		Utils.print("1. New Character");
		Utils.print("2. Load Character");
		Utils.print("3. View All Player Stats");
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
				if (Utils.notEmpty("players"))
				{
					for (String name : names)
					{
						Utils.print("\t- " + name);
					}
				}
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
			case 3:
				Utils.print("Viewing all player statistics in a window dialog, please wait...");
				List<Player> players = Stage1.getInstance().getPlayers();
				int size = players.size();
				String[] columns = {
										"Name",
										"Health",
										"Mana",
										"PhysDmg",
										"MagicDmg",
										"CombatLvl",
										"ExploringLvl",
										"FarmingLvl",
										"MageLvl"
								    };
				DefaultTableModel model = new DefaultTableModel(columns, size);
				TableFrame frame = new TableFrame("All Player Stats", model, 800, 400, new Dimension(700, 325));
				for (int i=0; i<size; i++)
				{
					String name = players.get(i).getName();
					int health = players.get(i).getMaxHp();
					int physDmg = players.get(i).getPhysDamage();
					int magicDmg = players.get(i).getMagicDamage();
					int cLvl = players.get(i).getCombatSkill().getSkillLevel();
					int eLvl = players.get(i).getExploringSkill().getSkillLevel();
					int fLvl = players.get(i).getFarmingSkill().getSkillLevel();
					int mLvl = players.get(i).getMageSkill().getSkillLevel();
					
					Object[] data = {
										name,
										health,
										physDmg,
										magicDmg,
										cLvl,
										eLvl,
										fLvl,
										mLvl
									};
					
					frame.getTableModel().addRow(data);
				}
				frame.display();
			default:
				Utils.print("Option does not exist.");
				runInitialMenu();
				break;
		}
		
	}
	
	private void runTaskMenu()
	{
		Scanner input = new Scanner(System.in);
		
		Utils.print("\n==============================");
		Utils.print("Please enter one of the following commands.");
		Utils.print("Today is a new a day, what would you like to do?");
		Utils.print("View_stats - View your current stats");
		Utils.print("Farm - Obtain resources");
		Utils.print("Explore - Discover new items");
		Utils.print("Kill_mobs - Fight new mobs");
		Utils.print("Exit");
		Utils.print("==============================\n");
		
		String cmd = input.nextLine();
		if (cmd.equalsIgnoreCase("view_stats"))
		{
			new ViewStatsCommand().execute(player);
		}
		else if (cmd.equalsIgnoreCase("farm"))
		{
			new FarmCommand().execute(player);
			saveData(input);
		}
		else if (cmd.equalsIgnoreCase("explore"))
		{
			new ExploreCommand().execute(player);
			saveData(input);
		}
		else if (cmd.equalsIgnoreCase("kill_mobs"))
		{
			// an animal will spawn with randomly generated hp/dmg which will
			// have a set min and max amount.
			// combat approach 1:
			// check whos phys/mgcdmg output is higher, determine winner by highest value
			// combat approach 2:
			// run the battle through a loop, will be based on turn-based attacks, player attacks, then mob attacks
			// then player attacks etc till their hp reaches 0
			new KillMobsCommand().execute(player);
			saveData(input);
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
	
	private void saveData(Scanner input)
	{
		// Save player/all data
		File playerData = new File("players/" + player.getName() + ".dat");
		ObjectFileWriter writer = new ObjectFileWriter(playerData, player);
		writer.save();
		Utils.print("\nYour progress has been saved.");
		Utils.print("==============================");
		Utils.print("Would you like to continue? Hit y/n");
		try 
		{
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
		catch(NoSuchElementException e)
		{
			// This stops the error that is caused when the users exits with no input
		}
	}
	
}
