package frontEnd.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ThemeScreenController implements Initializable {

	@FXML private ImageView basic;
	@FXML private ImageView gold;
	@FXML private Label title;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML public void chooseGold(){
		Main.newGame("gold");
	}
	
	@FXML public void chooseBasic(){
		Main.newGame("basic");
	}
	
	
	SequentialTransition fadeTransition;
	@FXML public void basicGlow(){
		basic.setEffect(new Glow(0.8));

		fadeTransition = new SequentialTransition();

		FadeTransition fadeOut = getFadeTransition(basic,
				basic.getOpacity(), 0.0, 800);
		FadeTransition fadeIn = getFadeTransition(basic, 0.0, 1.0, 800);

		fadeTransition.getChildren().addAll(fadeOut, fadeIn);
		fadeTransition.setCycleCount(Timeline.INDEFINITE);
		fadeTransition.play();
	}
	
	@FXML public void stopGlow(){
		fadeTransition.stop();
		basic.setOpacity(1.0);
		basic.setEffect(null);
		gold.setOpacity(1.0);
		gold.setEffect(null);
	}
	
	@FXML public void goldGlow(){
		gold.setEffect(new Glow(0.8));

		fadeTransition = new SequentialTransition();

		FadeTransition fadeOut = getFadeTransition(gold,
				gold.getOpacity(), 0.0, 800);
		FadeTransition fadeIn = getFadeTransition(gold, 0.0, 1.0, 800);

		fadeTransition.getChildren().addAll(fadeOut, fadeIn);
		fadeTransition.setCycleCount(Timeline.INDEFINITE);
		fadeTransition.play();
	}
	
	public FadeTransition getFadeTransition(ImageView imageView,
			double fromValue, double toValue, int durationInMilliseconds) {

		FadeTransition ft = new FadeTransition(Duration
				.millis(durationInMilliseconds), imageView);
		ft.setFromValue(fromValue);
		ft.setToValue(toValue);

		return ft;

	}
	
}
