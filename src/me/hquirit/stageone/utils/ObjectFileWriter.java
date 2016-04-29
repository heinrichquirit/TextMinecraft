package me.hquirit.stageone.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectFileWriter 
{
	
	private File f;
	private Object obj;
	
	public ObjectFileWriter(File f, Object obj)
	{
		this.f = f;
		this.obj = obj;
		
		// Create directory
		File dir = new File("players/");
		if (!dir.exists())
		{
			dir.mkdir();
			Utils.print(dir.getName() + " directory has been created.");
		}
		
		if (!f.exists()) 
		{
			try 
			{
				f.createNewFile();
			} 
			catch (IOException e) 
			{
				Utils.print(f.getName() + " cannot be created.");
			}
		}
	}

	public void save()
	{
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f)))
		{
			os.writeObject(obj);
		} 
		catch (FileNotFoundException e)
		{
			Utils.print(f.getName() + " could not be found.");
		}
		catch (IOException e) 
		{
			Utils.print(f.getName() + " could not be saved.");
		}
	}
	
}
