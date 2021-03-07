package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FileAnalysisResultsController implements Initializable 
{
	//Labels
	@FXML private Label resultsText;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//Empty
	}
	
	public void setResultsText(String resultsText)
	{
		this.resultsText.setText(resultsText);
	}
}
