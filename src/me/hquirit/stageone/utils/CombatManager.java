package me.hquirit.stageone.utils;

import java.util.Random;
import java.util.Scanner;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.mobs.Slime;
import me.hquirit.stageone.mobs.Zombie;
import me.hquirit.stageone.skills.Skill;

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
			printSlimeCombat();
			
			Scanner in = new Scanner(System.in);
			player.sendMessage("To begin combat, please select your damage type:");
			player.sendMessage("1. Physical");
			player.sendMessage("2. Magical");
			int choice = in.nextInt();
			
			int slimeHp = slime.getHealth();
			int playerHp = player.getMaxHp();
			
			switch(choice)
			{
				case 1:
					player.sendMessage("Using physical damage in battle.");
					
					while(slimeHp > 0)
					{
						if (slimeHp > 0)
						{
							slimeHp -= player.getPhysDamage();
							player.sendMessage("You attacked slime for " + player.getPhysDamage() + " damage.");
							player.sendMessage("Slime Hp: " + slimeHp); 
						}
						if (playerHp > 0) 
						{
							playerHp -= player.getPhysDamage();
							player.sendMessage("Slime attacked you for " + slime.getAttackDmg() + " damage.");
							player.sendMessage("Your Hp: " + playerHp);
						}
						if (slimeHp == 0) 
						{
							player.sendMessage("You won the battle.");
							break;
						}
						if (playerHp == 0)
						{
							player.sendMessage("Slime wins the battle.");
							break;
						}
					}
					break;
				case 2:
					player.sendMessage("Using magical damage in battle.");
					
					double a = slime.getMagicalResistance() * player.getMagicDamage();
					double playerActualDmg = Math.round(player.getMagicDamage() - a);
					int playerDmg = (int) playerActualDmg;
					
					while(slimeHp > 0)
					{
						if (slimeHp > 0)
						{
							slimeHp -= playerDmg;
							player.sendMessage("You attacked slime for " + playerDmg + " damage.");
							player.sendMessage("Slime Hp: " + slimeHp); 
						}
						if (playerHp > 0) 
						{
							playerHp -= playerDmg;
							player.sendMessage("Slime attacked you for " + slime.getAttackDmg() + " damage.");
							player.sendMessage("Your Hp: " + playerHp);
						}
						if (slimeHp == 0) 
						{
							player.sendMessage("You won the battle.");
							break;
						}
						if (playerHp == 0)
						{
							player.sendMessage("Slime wins the battle.");
							break;
						}
					}
					break;
				default:
					startCombat(player);
					
			}
		}
		else if (n == 1)
		{
			// Initiate combat with zombie
			printZombieCombat();
			
			Scanner in = new Scanner(System.in);
			player.sendMessage("To begin combat, please select your damage type:");
			player.sendMessage("1. Physical");
			player.sendMessage("2. Magical");
			int choice = in.nextInt();
			
			int zombieHp = zombie.getHealth();
			int playerHp = player.getMaxHp();
			
			switch(choice)
			{
				case 1:
					player.sendMessage("Using physical damage in battle.");
					
					double a = zombie.getPhysicalResistance() * player.getMagicDamage();
					double playerActualDmg = Math.round(player.getPhysDamage() - a);
					int playerDmg = (int) playerActualDmg;
					
					while(zombieHp > 0)
					{
						if (zombieHp > 0)
						{
							zombieHp -= playerDmg;
							player.sendMessage("You attacked zombie for " + playerDmg + " damage.");
							player.sendMessage("Zombie Hp: " + zombieHp); 
						}
						if (playerHp > 0) 
						{
							playerHp -= zombie.getAttackDmg();
							player.sendMessage("Zombie attacked you for " + zombie.getAttackDmg() + " damage.");
							player.sendMessage("Your Hp: " + playerHp);
						}
						if (zombieHp == 0) 
						{
							player.sendMessage("You won the battle.");
							levelUpCombat();
							break;
						}
						if (playerHp == 0)
						{
							player.sendMessage("Zombie wins the battle.");
							break;
						}
					}
					break;
				case 2:
					player.sendMessage("Using magical damage in battle.");
					
					while(zombieHp > 0)
					{
						if (zombieHp > 0)
						{
							zombieHp -= player.getMagicDamage();
							player.sendMessage("You attacked zombie for " + player.getMagicDamage() + " damage.");
							player.sendMessage("Zombie Hp: " + zombieHp); 
						}
						if (playerHp > 0) 
						{
							playerHp -= zombie.getAttackDmg();
							player.sendMessage("Zombie attacked you for " + zombie.getAttackDmg() + " damage.");
							player.sendMessage("Your Hp: " + playerHp);
						}
						if (zombieHp == 0) 
						{
							player.sendMessage("You won the battle.");
							levelUpMage();
							break;
						}
						if (playerHp == 0)
						{
							player.sendMessage("Zombie wins the battle.");
							break;
						}
					}
					break;
				default:
					startCombat(player);
					
			}
			
		}
	}
	
	public void printSlimeCombat()
	{
		player.sendMessage("");
		player.sendMessage("A slime has spawned!");
		player.sendMessage("|----------------------------|");
		player.sendFMessage("| %-27s|", "Slime Stats");
		player.sendFMessage("| %s: %-23d|", "Hp", slime.getHealth());
		player.sendFMessage("| %s: %-19d|", "Damage", slime.getAttackDmg());
		player.sendFMessage("| %s: %-10f|", "MagicResistance", slime.getMagicalResistance());
		player.sendMessage("|----------------------------|");
		player.sendMessage("|----------------------------|");
		player.sendFMessage("| %-27s|", player.getName() + "'s Stats");
		player.sendFMessage("| %s: %-11d|", "PhysicalDamage", player.getPhysDamage());
		player.sendFMessage("| %s: %-14d|", "MagicDamage", player.getMagicDamage());
		player.sendMessage("|----------------------------|");
	}
	
	public void printZombieCombat()
	{
		player.sendMessage("");
		player.sendMessage("A Zombie has spawned!");
		player.sendMessage("|----------------------------|");
		player.sendFMessage("| %-27s|", "Zombie Stats");
		player.sendFMessage("| %s: %-23d|", "Hp", zombie.getHealth());
		player.sendFMessage("| %s: %-19d|", "Damage", zombie.getAttackDmg());
		player.sendFMessage("| %s: %-10f|", "PhysicalResistance", zombie.getPhysicalResistance());
		player.sendMessage("|----------------------------|");
		player.sendMessage("|----------------------------|");
		player.sendFMessage("| %-27s|", player.getName() + "'s Stats");
		player.sendFMessage("| %s: %-11d|", "PhysicalDamage", player.getPhysDamage());
		player.sendFMessage("| %s: %-14d|", "MagicDamage", player.getMagicDamage());
		player.sendMessage("|----------------------------|");
	}
	
	public void levelUpCombat()
	{
		if (player.getCombatSkill().getSkillLevel() <= 5)
		{
			player.getCombatSkill().levelUp();
			player.sendMessage("You have leveled up! You are now level " + player.getCombatSkill().getSkillLevel() + "!");
		}
	}
	
	public void levelUpMage()
	{
		if (player.getMageSkill().getSkillLevel() <= 5)
		{
			player.getMageSkill().levelUp();
			player.sendMessage("You have leveled up! You are now level " + player.getMageSkill().getSkillLevel() + "!");
		}
	}
	
}
