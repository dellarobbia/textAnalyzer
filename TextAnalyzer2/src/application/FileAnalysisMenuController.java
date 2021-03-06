package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import textAnalyzer.TextAnalyzer;

public class FileAnalysisMenuController implements Initializable 
{
	//Properties
	private TextAnalyzer analyzeFile;
	
	public FileAnalysisMenuController() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void setAnalyzeFile(TextAnalyzer analyzeFile)
	{
		this.analyzeFile = analyzeFile;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub

	}

}
