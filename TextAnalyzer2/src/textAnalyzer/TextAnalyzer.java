package textAnalyzer;

import java.io.File;

public class TextAnalyzer 
{

	public static void main(String[] args) 
	{
		
		testHTMLFileReader();
	}
	
	private static void testHTMLFileReader()
	{
		File testFile = new File("The Raven.html");
		
		HTMLFileReader testHTMLReader = new HTMLFileReader(testFile);
		
		testHTMLReader.readFile();
		WordCounter wordCounter = new WordCounter();
		wordCounter.countWords(testHTMLReader.toString());
		System.out.print(wordCounter.toString());
	}
	
	private static void testFileReader()
	{
		File testFile = new File("The Raven.html");
		
		FileReader testFileReader = new FileReader(testFile);
		
		testFileReader.readFile();
		String fileContents = testFileReader.toString();
		System.out.println(fileContents);
	}
}
