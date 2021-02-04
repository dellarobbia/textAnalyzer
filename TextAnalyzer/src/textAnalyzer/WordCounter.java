package textAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter 
{
	//Properties
	private HashMap<String, Integer> wordCount;
	
	//Constructors
	//Default Constructor; uses default parser type
	public WordCounter()
	{
		setWordCount(new HashMap<String,Integer>());
	}
	//Allows user to supply pre-made wordCount collection
	public WordCounter(HashMap<String,Integer> wordCount)
	{
		setWordCount(wordCount);
	}
	
	//Getters & Setters
	public HashMap<String,Integer> getWordCount()
	{
		return wordCount;
	}
	public void setWordCount(HashMap<String,Integer> wordCount)
	{
		this.wordCount = wordCount;
	}
	
	//Class methods
}
