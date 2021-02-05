package textAnalyzer;

import java.io.File;
import java.util.Scanner;

public class TextAnalyzer 
{
	private static File analyzeFile;
	private static String fileContents;

	public static void main(String[] args) 
	{
		fileLocPrompt(new Scanner(System.in));
		parserPrompt(new Scanner(System.in));
		analyzerPrompt(new Scanner(System.in));
	}
	
	//console prompts
	//give TextAnalyzer a file location to read
	private static void fileLocPrompt(Scanner userInput)
	{
		System.out.println("Enter the file location of the file to be analyzed:");
		String fileLoc = userInput.nextLine();
		setAnalyzeFile(fileLoc);
	}
	
	//select file type and return a string of file's contents 
	private static void parserPrompt(Scanner userInput)
	{
		System.out.println("Select a file type parser:");
		System.out.println("1: HTML (only analyzes paragraph text and ignores tags)");
		System.out.println("0: Default (analyzes all text in the file)");
		int selection = userInput.nextInt();
		parseFile(selection);
	}
	private static void parseFile(int parserSelection)
	{
		FileReader parser;
		switch(parserSelection)
		{
		case 1:
			parser = new HTMLFileReader(analyzeFile);
			break;
		default:
			parser = new FileReader(analyzeFile);
			break;
		}
		
		parser.readFile();
		fileContents = parser.toString();
	}
	
	//select which Analyzer to use
	private static void analyzerPrompt(Scanner userInput)
	{
		System.out.println("Select an analysis to be performed:");
		System.out.println("1: Word Occurances");
		System.out.println("2: Top x Used Words");
		int selection = userInput.nextInt();
		runAnalysis(selection);
	}
	private static void runAnalysis(int analysisSelection)
	{
		switch(analysisSelection)
		{
		case 1:
			WordCounter wordCounter = new WordCounter();
			dispAnalysisResults(wordCounter.analyze(fileContents));
			break;
		case 2:
			WordCounter topWordCounter = new WordCounter();
			dispAnalysisResults(topWordCounter.analyze(fileContents, numOfTopWords(new Scanner(System.in))));
		}
	}
	
	//select how many words to display for Top x Used Words
	private static int numOfTopWords(Scanner userInput)
	{
		System.out.println("How many words to display?");
		return userInput.nextInt();
	}
	
	//display analysis results
	private static void dispAnalysisResults(String results)
	{
		System.out.print(results);
	}
	
	//handles file to be analyzed
	public static File getAnalyzeFile(String fileLoc)
	{
		return analyzeFile;
	}
	public static  void setAnalyzeFile(File file)
	{
		analyzeFile = file;
	}
	public static void setAnalyzeFile(String fileLoc)
	{
		analyzeFile = new File(fileLoc);
	}
	
	
}
