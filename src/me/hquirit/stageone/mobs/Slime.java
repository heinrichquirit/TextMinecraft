package me.hquirit.stageone.mobs;

import java.util.Random;

public class Slime 
{

	private String animalType;
	private int health;
	private int attackDmg;
	private int magicalResistance;
	Random r = new Random();
	int n = r.nextInt(11);
	
	public Slime()
	{
		animalType = "Slime";
		health = 400;
		attackDmg = 7;
		if (n > 0) 
		{
			magicalResistance = n;
		}
	}
	
	public Slime(String animalType, int health, int attackDmg)
	{
		animalType = "Slime";
		setHealth(health);
		setAttackDmg(attackDmg);
		if (n > 0) 
		{
			magicalResistance = n;
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
	
	public int getMagicalResistance() 
	{
		return magicalResistance;
	}
	
}
