package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FileAnalysisResultsController implements Initializable 
{
	//Labels
	@FXML private Label resultsTextLabel;
	
	//Buttons
	@FXML private Button exitButton;
	
	//Initialization Methods
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//Empty
	}
	
	public void setResultsText(String resultsText)
	{
		resultsTextLabel.setText(resultsText);
	}
	
	//Event Methods
	public void exitButtonPressed(ActionEvent event)
	{
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
}
