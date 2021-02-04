package textAnalyzer;

import java.util.HashMap;
import java.util.Scanner;

public class WordCounter 
{
	//Properties
	private HashMap<String, Integer> wordCount;
	
	//Constructor
	public WordCounter()
	{
		setWordCount(new HashMap<String, Integer>());
		wordCount.put("Word Occurrences", null);
	}
	
	//Getters & Setters
	public HashMap<String, Integer> getWordCount()
	{
		return wordCount;
	}
	public void setWordCount(HashMap<String, Integer> wordCount)
	{
		this.wordCount = wordCount;
	}
	
	//Class Methods
	public void countWords(String wordString)
	{
		//Remove punctuation & change all words in text to lowercase
		String cleanedWordString = wordString.replaceAll("\\p{Punct}", " ").toLowerCase();
		//Remove any &mdash characters from text
		cleanedWordString = cleanedWordString.replaceAll("[-—]+", "");
		
		//read through the sanitized string and count each word's occurrence
		Scanner stringReader = new Scanner(cleanedWordString);
		while(stringReader.hasNext())
		{
			countWord(stringReader.next());
		}
		
		stringReader.close();
	}
	
	private void countWord(String word)
	{
		
	}
	
}
