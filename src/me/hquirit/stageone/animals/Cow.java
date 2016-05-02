package me.hquirit.stageone.animals;

public class Cow 
{

	private String animalType;
	private int health;
	private int attackDmg;
	
	public Cow()
	{
		animalType = "Cow";
		health = 0;
		attackDmg = 0;
	}
	
	public Cow(String animalType, int health, int attackDmg)
	{
		animalType = "Cow";
		setHealth(health);
		setAttackDmg(attackDmg);
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
