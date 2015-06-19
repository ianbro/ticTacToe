package frontEnd;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import application.Main;

public class ResultScreen extends AnchorPane {

	private Label result;
	public Button newGame;
	
	public ResultScreen(String theme, int player){
		super.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/" + theme + "/background.jpeg")), null, null, null, new BackgroundSize(100, 450, true, false, true, true))));
		this.setMinSize(450, 450);
		
		this.setResult(player);
		this.setButtonProperties();
		
		this.getChildren().add(newGame);
		this.getChildren().add(result);
		
		double left;
		if(result.getText().equals("Cats Game!")){
			left = 120;
		}
		else{
			left = 110;
		}
		
		AnchorPane.setLeftAnchor(newGame, 185.0);
		AnchorPane.setTopAnchor(newGame, 220.0);
		
		AnchorPane.setLeftAnchor(result, left);
		AnchorPane.setTopAnchor(result, 150.0);
		
		this.getStylesheets().add(getClass().getResource("/staticFiles/themes/" + theme + "/css/style.css").toString());
	}
	
	public void setButtonProperties(){
		this.newGame = new Button("New Game");
		this.newGame.setId("newGame");
		
		this.newGame.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Main.mainScene.setRoot(new HomeScreen(Main.game.getBoard().theme));
			}
		});
	}
	
	private void setResult(int player){
		player --;
		String result1 = null;
		
		switch(player){
		case 0:
			result1 = Main.game.player[player].name;
			break;
		case 1:
			result1 = Main.game.player[player].name;
			break;
		case 2:
			result1 = "Cats Game!";
			break;
		}
		
		if(player < 2){
			result1 = result1 + " Wins!";
		}
		
		result = new Label(result1);
		result.setTextFill(Color.WHITE);
		result.setFont(Font.font("PT Mono", FontWeight.BOLD, 36));
		result.setMaxWidth(400);
		result.setId("result");
	}
}
