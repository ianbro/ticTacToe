package frontEnd;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;

public class HomeScreen extends AnchorPane {

	private String theme;
	private AnchorPane value;
	
	public HomeScreen(String theme){
		this.theme = theme;
		try {
			this.value = FXMLLoader.load(this.getClass().getResource("/frontEnd/fxml/HomeScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.value.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/" + theme + "/background.jpeg")), null, null, null, new BackgroundSize(100, 450, true, false, true, true))));
		
		this.getChildren().add(this.value);
	}
}
