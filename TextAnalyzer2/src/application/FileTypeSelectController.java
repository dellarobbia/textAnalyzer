package application;

import java.io.File;
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

public class FileTypeSelectController implements Initializable 
{
	//Comboboxes
	@FXML private ComboBox<String> fileTypeSelector;
	
	//Buttons
	@FXML private Button confirmFileTypeButton;
	
	//Properties
	private File analyzeFile;
	private TextAnalyzer textAnalyzer;
	private ArrayList<String> validFileTypes;
	
	public FileTypeSelectController() 
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
		initializeComboBoxes();
	}
	
	//Event Methods
	public void fileTypeSelected(ActionEvent event) throws IOException
	{
		parseFile();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FileAnalysisMenu.fxml"));
		Parent fileAnalysisMenuParent = loader.load();
		Scene fileAnalysisMenuScene = new Scene(fileAnalysisMenuParent);
		
		FileAnalysisMenuController fileAnalysisMenuController = loader.getController();
		fileAnalysisMenuController.setAnalyzeFile(textAnalyzer);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(fileAnalysisMenuScene);
		window.show();
	}
	
	//Methods
	public void parseFile()
	{
		textAnalyzer = new TextAnalyzer(analyzeFile);
		textAnalyzer.setFileContents(textAnalyzer.parseFile(fileTypeSelector.getValue().toString()));
	}
	
	private void initializeComboBoxes()
	{
		validFileTypes = new ArrayList<String>();
		
		validFileTypes.add("None");
		validFileTypes.add("HTML");
		
		for(String string : validFileTypes)
			fileTypeSelector.getItems().add(string);
		fileTypeSelector.setValue(fileTypeSelector.getItems().get(0));
	}
}
