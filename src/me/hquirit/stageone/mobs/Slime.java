package me.hquirit.stageone.mobs;

import java.util.Random;

public class Slime 
{

	private String animalType;
	private int health;
	private int attackDmg;
	private double magicalResistance;
	
	public Slime()
	{
		animalType = "Slime";
		health = 400;
		attackDmg = 7;
		magicalResistance = 0.09;
	}
	
	public Slime(String animalType, int health, int attackDmg)
	{
		animalType = "Slime";
		setHealth(health);
		setAttackDmg(attackDmg);
		magicalResistance = 0.09;
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
	
	public double getMagicalResistance() 
	{
		return magicalResistance;
	}
	
}
