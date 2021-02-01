package textAnalyzer;

import java.util.ArrayList;

public class HTMLParser extends Parser implements Parsers
{
	//Properties
	//determines if the parser is currently inside an HTML tag
	private boolean isHTMLTag = false;
	
	//Constructors
	//Default Constructor
	public HTMLParser() 
	{
		//HTMLParsers will be constructed to ignoreText by default
		setIgnoreText(true);
		//HTMLParsers will assume they are not already inside an HTML tag by default
		setIsHTMLTag(false);
	}
	//Override Constructors
	public HTMLParser(boolean ignoreText) 
	{
		//Allows user to override ignoreText
		super(ignoreText);
	}
	
	//Getters & Setters
	public boolean getIsHTMLTag()
	{
		return isHTMLTag;
	}
	public void setIsHTMLTag(boolean isHTMLTag)
	{
		this.isHTMLTag = isHTMLTag;
	}
	
	//Interface Methods
	@Override
	public boolean isValid(String tryString) 
	{
		tryString(tryString);
		//Parser reports its current state
		if(isHTMLTag == false && getIgnoreText() == false)
		{
			//Text is considered valid only if it is outside an HTML tag and if the tag that preceded the text is a certain type
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Class Methods
	//Parser is passed a string and changes its state accordingly
	private void tryString(String tryString)
	{
		//If the Parser is currently within an HTML tag, it doesn't change the state
		if(isHTMLTag == true && tryString.contains(">") == false)
		{
			return;
		}
		//If the String passed to the parser contains a < then the parser's state reflects that;
		//also determines whether the text after the tag should be ignored or not based on the tag's type;
		if(tryString.contains("<"))
		{
			setIsHTMLTag(true);
			setIgnoreText(isValidTagType(tryString));
			return;
		}
		//If the String passed contains > then the parser's state will show it is now outside an HTML tag
		if(tryString.contains(">"))
		{
			setIsHTMLTag(false);
			return;
		}
	}
	private boolean isValidTagType(String tagPrefix)
	{
		//Collection of HTML tag prefixes considered valid
		ArrayList<String> validTagHeaders = new ArrayList<String>();
		validTagHeaders.add("<H");
		validTagHeaders.add("<P");
		
		for(String validTag : validTagHeaders)
		{
			if(tagPrefix.equals(validTag))
				return true;
		}
		
		return false;
	}
}
