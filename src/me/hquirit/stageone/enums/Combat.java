package me.hquirit.stageone.enums;

public enum Combat 
{
	PHYSICAL(1, "Physical"), MAGICAL(2, "Magical");
	
	private final int id;
	private final String name;
	
	private Combat(final int id, final String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId()	
	{
		return id;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
}
