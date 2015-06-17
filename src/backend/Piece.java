package backend;

import application.Main;
import frontEnd.Square;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Piece extends ImageView{

	private Image image;
	private Square place;
	public String type;
	
	public Piece(String team){
		image = new Image(getClass().getResourceAsStream("/staticFiles/themes/" + Main.game.getBoard().theme + "/" + team + ".png"));
		super.setImage(image);
		this.type = team;
		super.setFitHeight(150);
		super.setPreserveRatio(true);
	}
}
