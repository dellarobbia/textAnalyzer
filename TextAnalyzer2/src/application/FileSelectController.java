package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller for the File Select user interface
 * <p>Allows the user to select a file for analysis</p>
 * @author Andrew McKay
 *
 */
public class FileSelectController implements Initializable
{
	//Labels
	@FXML private Label fileSelectPrompt;
	@FXML private Label fileDirectoryLabel;
	
	//Buttons
	@FXML private Button fileSelectButton;
	@FXML private Button confirmFileSelectButton;
	
	//Properties
	private File selectFile;

	//Initialization
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		fileSelectPrompt.setText("Select file to analyze:");
		fileDirectoryLabel.setText("Selected File Directory");
	}
	
	//Event Methods
	public void selectFile ()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select file to analyze...");
		fileChooser.setInitialDirectory(new File("c:\\"));
		
		selectFile = fileChooser.showOpenDialog(null);
		fileDirectoryLabel.setText(selectFile.getAbsolutePath());
	}
	
	public void confirmFileSelect(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FileTypeSelect.fxml"));
		Parent fileTypeSelectParent = loader.load();
		Scene fileTypeSelectScene = new Scene(fileTypeSelectParent);
		
		FileTypeSelectController fileTypeSelectController = loader.getController();
		fileTypeSelectController.setAnalyzeFile(selectFile);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(fileTypeSelectScene);
		window.show();
	}
}
