package me.hquirit.stageone.utils;

import java.util.Random;
import java.util.Scanner;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.mobs.Slime;
import me.hquirit.stageone.mobs.Zombie;

public class CombatManager 
{

	private Player player;
	private Slime slime;
	private Zombie zombie;
	Random r = new Random();
	
	public CombatManager(Player player) 
	{
		this.player = player;
		slime = new Slime();
		zombie = new Zombie();
	}
	
	public void startCombat(Player player)
	{
		int n = r.nextInt(2);
		if (n == 0) 
		{
			// Initiate combat with slime
			player.sendMessage("");
			player.sendMessage("A slime has spawned!");
			player.sendMessage("|----------------------------|");
			player.sendFMessage("| %-27s|", "Slime Stats");
			player.sendFMessage("| %s: %-23d|", "Hp", slime.getHealth());
			player.sendFMessage("| %s: %-19d|", "Damage", slime.getAttackDmg());
			player.sendFMessage("| %s: %-10d|", "MagicResistance", slime.getMagicalResistance());
			player.sendMessage("|----------------------------|");
			player.sendMessage("|----------------------------|");
			player.sendFMessage("| %-27s|", player.getName() + "'s Stats");
			player.sendFMessage("| %s: %-11d|", "PhysicalDamage", player.getPhysDamage());
			player.sendFMessage("| %s: %-14d|", "MagicDamage", player.getMagicDamage());
			player.sendMessage("|----------------------------|");

			Scanner in = new Scanner(System.in);
			player.sendMessage("To begin combat, please select your damage type:");
			player.sendMessage("1. Physical");
			player.sendMessage("2. Magical");
			int choice = in.nextInt();
			switch(choice)
			{
				case 1:
					
					break;
				case 2:
					
					break;
				default:
					startCombat(player);
			}
		}
		else if (n == 1)
		{
			// Initiate combat with zombie
			player.sendMessage("");
			player.sendMessage("A zombie has spawned!");
			player.sendMessage("|----------------------------|");
			player.sendFMessage("|%15s|", "Slime Stats");
			player.sendFMessage("|%s: %15d|", "Hp", slime.getHealth());
			player.sendFMessage("|%s: %15d|", "Damage", slime.getAttackDmg());
			player.sendFMessage("|%s: %15d|", "MagicResistance", slime.getMagicalResistance());
			player.sendMessage("|----------------------------|");
			player.sendMessage("|----------------------------|");
			player.sendFMessage("|%15s|", player.getName() + "'s Stats");
			player.sendFMessage("|%s: %15d|", "PhysicalDamage", player.getPhysDamage());
			player.sendFMessage("|%s: %15d|", "MagicDamage", player.getMagicDamage());
			player.sendMessage("|----------------------------|");
		}
	}
	
	public void combat(Player player)
	{
		player.sendMessage("Choose: Physical");
	}
	
}
