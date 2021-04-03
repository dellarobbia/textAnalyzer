package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import textAnalyzer.TextAnalyzer;

/**
 * Controller for the File Analysis Menu:
 * <p>Allows  the user to select an analysis to perform on their file</p>
 * @author Andrew McKay
 *
 */
public class FileAnalysisMenuController implements Initializable 
{
	//Comboboxes
	@FXML ComboBox<String> fileAnalysisSelector;
	
	//Buttons
	@FXML Button fileAnalysisConfirm;
	
	//Properties
	private TextAnalyzer analyzeFile;
	private ArrayList<String> validAnalysisTypes;
	
	public void setAnalyzeFile(TextAnalyzer analyzeFile)
	{
		this.analyzeFile = analyzeFile;
	}
	
	//Initialization Methods
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		initializeComboBoxes();
	}
	
	private void initializeComboBoxes()
	{
		setFileAnalysisSelect();
	}
	
	private void setFileAnalysisSelect()
	{
		validAnalysisTypes = new ArrayList<String>();
		
		validAnalysisTypes.add("Word Count");
		validAnalysisTypes.add("Top 20 Word Count");
		
		for(String string : validAnalysisTypes)
			fileAnalysisSelector.getItems().add(string);
		fileAnalysisSelector.setValue(fileAnalysisSelector.getItems().get(0));
	}
	
	//Event Methods
	public void runAnalysis(ActionEvent event) throws IOException
	{
		analyzeFile.runAnalysis(fileAnalysisSelector.getValue().toString());
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FileAnalysisResults.fxml"));
		Parent fileAnalysisResultsParent = loader.load();
		Scene fileAnalysisResultsScene = new Scene(fileAnalysisResultsParent);
		
		FileAnalysisResultsController fileAnalysisResultsController = loader.getController();
		fileAnalysisResultsController.setResultsText(analyzeFile.toString());
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(fileAnalysisResultsScene);
		window.show();
	}
}
