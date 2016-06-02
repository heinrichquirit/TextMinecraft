package me.hquirit.stageone.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.hquirit.stageone.utils.ObjectFileReader;

public class Stage1 
{
	
	private static Stage1 instance = new Stage1();
	
	private static ObjectFileReader objReader;
	private static List<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args)
	{
		
		// Load character data before running menu
		objReader = new ObjectFileReader(players);
		objReader.loadPlayers();
		
		CommandMenu menu = new CommandMenu();
		// Run character to menu, listing options to create/load a character
		menu.runInitialMenu();
	}
	
	public static Stage1 getInstance()
	{
		return instance;
	}
	
	public ObjectFileReader getObjReader()
	{
		return objReader;
	}
	
	public List<Player> getPlayers()
	{
		return players;
	}
	
}
