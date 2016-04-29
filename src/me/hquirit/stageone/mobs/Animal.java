package me.hquirit.stageone.mobs;

public class Animal 
{
	
	private String animalType;
	private int health;
	private int attackDmg;
	
	public Animal()
	{
		animalType = "";
		health = 0;
		attackDmg = 0;
	}
	
	public Animal(String animalType, int health, int attackDmg)
	{
		setAnimalType(animalType);
		setHealth(health);
		setAttackDmg(attackDmg);
	}
	
	public void setAnimalType(String animalType)
	{
		this.animalType = animalType;
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
	
}
