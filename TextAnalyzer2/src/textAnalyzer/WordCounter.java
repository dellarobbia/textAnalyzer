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
	
	//Interface Methods
	public String toString()
	{
		String dispWordOccurances = "Word Occurances:\n";
		
		for(String word : wordCount.keySet())
		{
			dispWordOccurances += word + ": " + wordCount.get(word) + "\n";
		}
		
		return dispWordOccurances;
	}
	
	//Class Methods
	public void countWords(String wordString)
	{
		//Remove punctuation & change all words in text to lowercase
		String cleanedWordString = wordString.replaceAll("\\p{Punct}", " ").toLowerCase();
		//Remove any &mdash characters from text
		cleanedWordString = cleanedWordString.replaceAll("[-—]+", " ");
		
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
		int wordOccurance = 1;
		
		if(wordCount.containsKey(word))
		{
			wordOccurance += wordCount.get(word);
			wordCount.put(word, wordOccurance);
		}
		else
		{
			wordCount.put(word, wordOccurance);
		}
	}
	
	public HashMap<String, Integer> sortTopWords(int numberOfWords)
	{
		HashMap<String, Integer> topWords = new HashMap<String, Integer>();
		
		//sets numberOfWords to a max value that equals the total size of wordCount to prevent endless loop
		if(numberOfWords > wordCount.size())
			numberOfWords = wordCount.size();
		//if a negative value or 0 is entered for numberOfWords, pass the entire unsorted wordCount
		else if(numberOfWords <= 0)
			return wordCount;
		
		while(topWords.size() < numberOfWords)
		{
			
		}
		
		return topWords;
	}
	
}
