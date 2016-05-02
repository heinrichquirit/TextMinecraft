package me.hquirit.stageone.skills;

import java.io.Serializable;
import java.util.HashMap;

public class PlayerInventory implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 500870135442104660L;
	
	private HashMap<String, Integer> map;
	
	public PlayerInventory()
	{
		map = new HashMap<String, Integer>();
	}

	public void incrementItem(String item)
	{
		map.put(item, map.get(item) + 1);
	}
	
	public void put(String item, Integer amount)
	{
		map.put(item, amount);
	}
	
	public void remove(String item)
	{
		map.remove(item);
	}
	
	public int getItemCount(String item)
	{
		if (containsItem(item))
		{
			return map.get(item);
		}
		return 0;
	}
	
	public HashMap<String, Integer> getMap()
	{
		return map;
	}
	
	public boolean containsItem(String item)
	{
		return map.containsKey(item);
	}
	
}
