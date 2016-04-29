package me.hquirit.stageone.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import me.hquirit.stageone.menu.Player;

public class ObjectFileReader 
{

	private List<Player> players;
	
	public ObjectFileReader(List<Player> players)
	{
		this.players = players;
	}
	
	public Player getPlayer(String name)
	{
		Player player = null;
		File dir = new File("players/");
		if (dir.isDirectory())
		{
			for (File f : dir.listFiles())
			{
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f)))
				{
					Player pObj = (Player)os.readObject();
					if (pObj.getName().equalsIgnoreCase(name))
					{
						player = pObj;
						return player;
					}
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return player;
	}
	
	/* This method must run in order to load all players in list */
	public List<Player> loadPlayers()
	{
		File dir = new File("players/");
		if (dir.isDirectory())
		{
			for (File f : dir.listFiles())
			{
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f))) 
				{
					players.add((Player)os.readObject());
					if (players.size() == dir.list().length)
					{
						// Now we know that all saved players have been transferred to the list
						return players;
					}
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
