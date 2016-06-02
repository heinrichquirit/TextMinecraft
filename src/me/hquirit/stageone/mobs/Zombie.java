package me.hquirit.stageone.mobs;

import java.util.Random;

public class Zombie 
{

	private String animalType;
	private int health;
	private int attackDmg;
	private double physicalResistance;
	
	public Zombie()
	{
		animalType = "Zombie";
		health = 300;
		attackDmg = 10;
		physicalResistance = 0.12;
	}
	
	public Zombie(String animalType, int health, int attackDmg)
	{
		animalType = "Zombie";
		setHealth(health);
		setAttackDmg(attackDmg);
		physicalResistance = 0.12;
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
	
	public double getPhysicalResistance() 
	{
		return physicalResistance;
	}
	
}
