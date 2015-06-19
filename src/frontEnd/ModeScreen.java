package frontEnd;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.crypto.NullCipher;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class ModeScreen extends AnchorPane{

	private String theme;
	public AnchorPane value;
	
	public ModeScreen(String theme){
		this.theme = theme;
		URL url = getClass().getClassLoader().getResource("frontEnd/fxml/ModeScreen.fxml");
		try {
			this.value = FXMLLoader.load(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			this.value.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/" + theme + "/background.jpeg")), null, null, null, new BackgroundSize(100, 450, true, false, true, true))));
		} catch(NullPointerException n){
			try{
				this.value.setBackground(new Background(new BackgroundImage(new Image("/staticFiles/themes/" + theme + "/background.jpeg"), null, null, null, new BackgroundSize(100, 450, true, false, true, true))));
			} catch(NullPointerException n1){
				n1.printStackTrace();
			}
		}
		
		this.getChildren().add(this.value);
		
		this.getStylesheets().add(getClass().getResource("/staticFiles/themes/" + theme + "/css/style.css").toString());
	}
}
