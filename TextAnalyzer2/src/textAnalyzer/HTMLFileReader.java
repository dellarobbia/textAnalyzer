package textAnalyzer;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Variant FileReader that passes all text from an HTML file to a String; parses out HTML tags; 
 * 		only returns text under header and paragraph elements
 * @author Andrew McKay
 *
 */
public class HTMLFileReader extends FileReader implements Readers 
{
	
	public HTMLFileReader(File file) 
	{
		super(file);
	}
	
	//Interface Methods
	//Override the superclass's version of readFile to implement HTML parsing
	public void readFile()
	{
		Document htmlDocument;
		try 
		{
			htmlDocument = Jsoup.parse(getFile(), "UTF-8");
		
			//String documentLoc = htmlDocument.location();
			//System.out.println(documentLoc);
			
			Elements paragraphs = htmlDocument.select("p");
			
			for (int i = 0; i < paragraphs.size(); i++)
			{
				setFileContents(getFileContents() + paragraphs.get(i).text());
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
