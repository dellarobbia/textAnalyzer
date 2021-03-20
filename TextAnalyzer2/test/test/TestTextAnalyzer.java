package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import textAnalyzer.TextAnalyzer;

class TestTextAnalyzer 
{
	//.txt file tests
	@Test
	void testGetAnalyzeFile() 
	{
		TextAnalyzer testTextAnalyzer = new TextAnalyzer(new File("Test.txt"));
		File testFile = new File("Test.txt");
		String textAnalyzerFilePath = testTextAnalyzer.getAnalyzeFile().getAbsolutePath();
		String actualFilePath = testFile.getAbsolutePath();
		
		assertEquals(actualFilePath, textAnalyzerFilePath);
	}

	@Test
	void testParseTextFile() 
	{
		TextAnalyzer testTextAnalyzer = new TextAnalyzer(new File("Test.txt"));
		String parsedContents = testTextAnalyzer.parseFile("Text");
		String correctContents = 
				"One\n" +
				"Two Two\n" +
				"Three Three Three\n" +
				"Four Four Four Four\n" +
				"Five Five Five Five Five\n" +
				"Six Six Six Six Six Six\n" +
				"Seven Seven Seven Seven Seven Seven Seven\n";
		assertEquals(correctContents, parsedContents);
	}
}
