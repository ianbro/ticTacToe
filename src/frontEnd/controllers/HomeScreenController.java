package frontEnd.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import frontEnd.ModeScreen;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeScreenController implements Initializable {

	@FXML private Button btnPlay;
	@FXML private Button btnThemes;
	@FXML private Label title;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	@FXML private void btnPlayPressed(){
		Main.mainScene.setRoot(new ModeScreen(Main.game.getBoard().theme));
	}
	
	@FXML private void btnThemesPressed(){
		Main.toThemeScreen(Main.game.getBoard().theme);
	}

}
