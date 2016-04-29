package me.hquirit.stageone.skills;

import java.util.HashMap;

public class PlayerInventory
{
	
	private HashMap<String, Integer> map;
	
	public PlayerInventory()
	{
		map = new HashMap<String, Integer>();
	}
	
	public void put(String item, Integer amount)
	{
		map.put(item, amount);
	}
	
	public void remove(String item)
	{
		map.remove(item);
	}
	
}
