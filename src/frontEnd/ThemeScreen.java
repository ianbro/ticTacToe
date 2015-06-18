package frontEnd;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class ThemeScreen extends AnchorPane {

	private String theme;
	private AnchorPane value;
	private ImageView basic;
	private ImageView gold;
	
	public ThemeScreen(String theme){
		this.theme = theme;
		try {
			this.value = FXMLLoader.load(this.getClass().getResource("/frontEnd/fxml/ThemeScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.value.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/" + theme + "/background.jpeg")), null, null, null, new BackgroundSize(100, 450, true, false, true, true))));
		
		this.getChildren().add(this.value);
		
		this.getStylesheets().add(getClass().getResource("/staticFiles/themes/" + theme + "/css/style.css").toString());
		
		basic = (ImageView)(Main.mainScene.lookup("#basicImage"));
		basic.setImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/basic/sample.png")));

		gold = (ImageView)(Main.mainScene.lookup("#goldImage"));
		gold.setImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/gold/sample.png")));
	}
}
