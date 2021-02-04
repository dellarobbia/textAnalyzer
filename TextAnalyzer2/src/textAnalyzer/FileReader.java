package textAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Generic FileReader designed to output all of a given file's text to a String; does not parse out any formatting
public class FileReader implements Readers 
{
	private File file;
	private String fileContents = "";
	
	//Constructors
	//FileReader only requires a File object to work with; user should not be able to change fileContents
	public FileReader(File file)
	{
		setFile(file);
	}
	
	//Getters & Setters
	public File getFile()
	{
		return file;
	}
	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFileContents()
	{
		return fileContents;
	}
	
	public void setFileContents(String fileContents)
	{
		this.fileContents = fileContents;
	}
	
	
	//Interface Methods
	@Override
	//Read the file's text contents into fileContents
	public void readFile() 
	{
		try 
		{
			Scanner fileScanner = new Scanner(file);
			
			while(fileScanner.hasNextLine())
			{
				fileContents += fileScanner.nextLine() + "\n";
			}
			
			fileScanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public String toString()
	{
		return getFileContents();
	}

	//Class Methods
}
