package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textAnalyzer.WordCounter;

class TestWordCounter 
{

	@Test
	void testCountWordsString() 
	{
		WordCounter testWordCounter = new WordCounter();
		String testString = 
				"One\n" +
				"Two Two\n" +
				"Three Three Three\n" +
				"Four Four Four Four\n" +
				"Five Five Five Five Five\n" +
				"Six Six Six Six Six Six\n" +
				"Seven Seven Seven Seven Seven Seven Seven\n";
		String correctString = "one";
		
		testWordCounter.countWords(testString);
		assertEquals(true, testWordCounter.getWordCount().containsKey(correctString));
	}
	
	@Test
	void testCountWordsInt()
	{
		WordCounter testWordCounter = new WordCounter();
		String testString =  
				"One\n" +
				"Two Two\n" +
				"Three Three Three\n" +
				"Four Four Four Four\n" +
				"Five Five Five Five Five\n" +
				"Six Six Six Six Six Six\n" +
				"Seven Seven Seven Seven Seven Seven Seven\n";
		int correctCount = 7;
		
		testWordCounter.countWords(testString);
		assertEquals(correctCount, testWordCounter.getWordCount().get("seven"));
	}

}
