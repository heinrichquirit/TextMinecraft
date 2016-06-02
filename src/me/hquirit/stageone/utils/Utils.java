package me.hquirit.stageone.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import me.hquirit.stageone.menu.Player;
import me.hquirit.stageone.skills.Skill;

public class Utils 
{
	
	public static void printf(String s, Object... args)
	{
		System.out.printf(s, args);
	}
	
	public static void debug(Skill skill)
	{
		print("SEL COUNT: " + skill.getSelectionCount());
		print("SKILL LVL: " + skill.getSkillLevel());
	}
	
	public static boolean notEmpty(String dir)
	{
		File directory = new File(dir + "/");
		if (directory.isDirectory())
		{
			return (directory.listFiles().length > 0);
		}
		return false;
	}
	
	public static boolean fileExists(String name)
	{
		/*
		// Might have to change this to check the actual name existence in the file instead
		if (Stage1.getInstance().getObjReader().getPlayer(name) != null)
		{
			return true;
		}
		return false;
		*/
		File dir = new File("players/");
		if (dir.isDirectory())
		{
			for (File f : dir.listFiles())
			{
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f)))
				{
					Player pObj = (Player)os.readObject();
					if (pObj.getName().equals(name))
					{
						return true;
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
		return false;
	}
	
	public static void print(String str) 
	{
		System.out.println(str);
	}
	
}
