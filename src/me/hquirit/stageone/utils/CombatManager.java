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
			player.sendMessage("A slime has spawned.");
			Utils.printf("| Slime | HP: %d | Damage: %d | MagicResistance: %d", slime.getHealth(), 
					slime.getAttackDmg(), slime.getMagicalResistance());
			player.sendMessage("");
			
			Scanner in = new Scanner(System.in);
			
		}
		else if (n == 1)
		{
			// Initiate combat with zombie
			player.sendMessage("");
			player.sendMessage("A zombie has spawned.");
			Utils.printf("| Zombie | HP: %d | Damage: %d | MagicResistance: %d", zombie.getHealth(), 
					zombie.getAttackDmg(), zombie.getPhysicalResistance());
			player.sendMessage("");
		}
	}
	
	public void combat(Player player)
	{
		player.sendMessage("Choose: Physical");
	}
	
}
