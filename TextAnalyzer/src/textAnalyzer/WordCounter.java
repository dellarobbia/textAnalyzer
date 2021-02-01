package textAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter 
{
	//Properties
	private HashMap<String, Integer> wordCount;
	private Parser fileParser;
	
	//Constructors
	//Default Constructor; uses default parser type
	public WordCounter()
	{
		setWordCount(new HashMap<String,Integer>());
		setFileParser(new Parser());
	}
	//Allows user to specify what kind of parser to use
	public WordCounter(Parser fileParser)
	{
		setWordCount(new HashMap<String,Integer>());
		setFileParser(fileParser);
	}
	//Allows user to supply pre-made wordCount collection
	public WordCounter(HashMap<String,Integer> wordCount)
	{
		setWordCount(wordCount);
		setFileParser(new Parser());
	}
	//Allows user to supply both a pre-made word count and specify a fileParser
	public WordCounter(HashMap<String,Integer> wordCount, Parser fileParser)
	{
		setWordCount(wordCount);
		setFileParser(fileParser);
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
	
	public Parser getFileParser()
	{
		return fileParser;
	}
	public void setFileParser(Parser fileParser)
	{
		this.fileParser = fileParser;
	}
	
	//Class methods
	public void readFile(File file) throws FileNotFoundException
	{
		Scanner fileReader = new Scanner(file);
		String readString = null;
		
		while(fileReader.hasNext())
		{
			readString = fileReader.next();
			if(fileParser.isValid(readString))
				addWord(readString);
		}
		
		fileReader.close();
	}
	
	private void addWord(String word)
	{
		Integer wordOccurance = 1;
		if(wordCount.containsKey(word))
		{
			wordOccurance = wordCount.get(word);
			wordCount.put(word, wordOccurance++);
		}
		else
		{
			wordCount.put(word, wordOccurance);
		}
	}
}
