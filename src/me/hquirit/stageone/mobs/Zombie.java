package me.hquirit.stageone.mobs;

import java.util.Random;

public class Zombie 
{

	private String animalType;
	private int health;
	private int attackDmg;
	private int physicalResistance;
	Random r = new Random();
	int n = r.nextInt(11);
	
	public Zombie()
	{
		animalType = "Zombie";
		health = 300;
		attackDmg = 10;
		if (n > 0)
		{
			physicalResistance = n;
		}
	}
	
	public Zombie(String animalType, int health, int attackDmg)
	{
		animalType = "Zombie";
		setHealth(health);
		setAttackDmg(attackDmg);
		if (n > 0)
		{
			physicalResistance = n;
		}
	}
	
	public String getAnimalType()
	{
		return animalType;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setAttackDmg(int attackDmg)
	{
		this.attackDmg = attackDmg;
	}
	
	public int getAttackDmg()
	{
		return attackDmg;
	}
	
	public int getPhysicalResistance() 
	{
		return physicalResistance;
	}
	
}
