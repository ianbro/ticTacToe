package frontEnd.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ModeScreenController implements Initializable {

	@FXML private Label single;
	@FXML private Label multi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	@FXML public void chooseSingle(){
		Main.newGame(Main.game.getBoard().theme, "single");
	}
	
	@FXML public void chooseMulti(){
		Main.newGame(Main.game.getBoard().theme, "multi");
	}

}
