package textAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalyzer 
{

	public static void main(String[] args) 
	{
		testTextAnalyzer();
	}

	
	private static void testTextAnalyzer()
	{
		WordCounter wordCounter = new WordCounter(new HTMLParser());
		File htmlFile = new File("The Raven.htm");
		try 
		{
			wordCounter.readFile(htmlFile);
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(wordCounter.getWordCount().toString());
	}
}
