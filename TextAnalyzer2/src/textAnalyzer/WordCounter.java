package textAnalyzer;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Analyzes the number of times each word occurs in a file
 * @author Andrew McKay
 *
 */
public class WordCounter implements Analyzers
{
	//Properties
	/**
	 * HashMap that maps distinct Strings to an integer representing the number of times 
	 * 		each word occurs in the file
	 */
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
	public String analyze(String analyzeText)
	{
		countWords(analyzeText);
		return toString();
	}
	/**
	 * Overloaded analyze method that only returns the top number of words determined by the user
	 * @param analyzeText String
	 * @param numOfTopWords integer
	 * @return String of text representing the top occurring words
	 */
	public String analyze(String analyzeText, int numOfTopWords)
	{
		countWords(analyzeText);
		return toString(numOfTopWords);
	}
	public String toString()
	{
		String dispWordOccurances = "Word Occurances:\n\n";
		sortTopWords();
		
		for(String word : wordCount.keySet())
		{
			dispWordOccurances += word + ": " + wordCount.get(word) + "\n";
		}
		
		return dispWordOccurances;
	}
	public String toString(int numOfWords)
	{
		String dispTopWordOccurances = "Top " + numOfWords + " Words:\n\n";
		int topCounter = 0;
		sortTopWords();
		
		for(String word : wordCount.keySet())
		{
			if(topCounter < numOfWords)
				dispTopWordOccurances += word + ": " + wordCount.get(word) + "\n";
			topCounter++;
		}
		
		return dispTopWordOccurances;
	}
	
	//Class Methods
	/**
	 * Count the number of times each word occurs in the given text string
	 * @param wordString String of text to process
	 */
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
	
	/**
	 * Check if a single word has been counted already. 
	 * 		If so, increment its count by one; if not, add the word to the HashMap
	 * @param word single word to check
	 */
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
	
	/**
	 * Sort the words from greatest to least in terms of number of occurrences
	 */
	public void sortTopWords()
	{
		//create a copy of wordCount to sort
		HashMap<String, Integer> topWords = new HashMap<String, Integer>();
		topWords = getWordCount();
		
		List<Entry<String, Integer>> sortList = new LinkedList<Entry<String, Integer>>(topWords.entrySet());
		
		Collections.sort(sortList, new Comparator<Entry<String, Integer>>()   
		{  
			public int compare(Entry<String, Integer> word1, Entry<String, Integer> word2)   
			{  
				//compare each word and return the one with the higher count 
				return (word2.getValue()).compareTo(word1.getValue());
			}
		});
		
		HashMap<String, Integer> sortedTopWords = new LinkedHashMap<String, Integer>();
		for(Entry<String, Integer> entry : sortList)
			sortedTopWords.put(entry.getKey(), entry.getValue());
		
		wordCount = sortedTopWords;
	}
	
}
