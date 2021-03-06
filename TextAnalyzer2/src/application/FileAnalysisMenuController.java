package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class FileAnalysisMenuController implements Initializable 
{
	private File analyzeFile;
	
	public FileAnalysisMenuController() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void setAnalyzeFile(File analyzeFile)
	{
		this.analyzeFile = analyzeFile;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub

	}
	
}
