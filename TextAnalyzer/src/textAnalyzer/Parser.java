package textAnalyzer;

public class Parser implements Parsers 
{
	//Properties
	private boolean ignoreText = false;
	
	//Constructors
	//Default Parser will not ignore any text in a document
	public Parser()
	{
		setIgnoreText(false);
	}
	//Alternative constructor to allow the user to override the default setting and set ignoreText to true at Parser creation
	public Parser(boolean ignoreText)
	{
		setIgnoreText(ignoreText);
	}
	
	//Getters & Setters
	public boolean getIgnoreText()
	{
		return ignoreText;
	}
	public void setIgnoreText(boolean ignoreText)
	{
		this.ignoreText = ignoreText;
	}
	
	//Interface Methods
	@Override
	public boolean isValid(String tryString)
	{
		if(ignoreText == false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
