package frontEnd;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import application.Main;
import backend.Player;

public class Board extends AnchorPane{

	public ArrayList<ArrayList<Square>> squares;
	public String theme;
	
	public Board(String theme){

		this.theme = theme;
		squares = new ArrayList<ArrayList<Square>>();
		
		squares.add(new ArrayList<Square>());
		squares.add(new ArrayList<Square>());
		squares.add(new ArrayList<Square>());
		for(ArrayList<Square> column: squares){
			column.add(Square.init(theme));
			column.add(Square.init(theme));
			column.add(Square.init(theme));
			super.getChildren().add(Square.init(theme));
			super.getChildren().add(Square.init(theme));
			super.getChildren().add(Square.init(theme));
		}
		
		int x = 0;
		int y = 0;
		char row = 'a';
		int column = 1;
		
		for(Node s: this.getChildren()){
			s = (Square)s;
			s.setLayoutX(x);
			s.setLayoutY(y);

			s.setId(String.valueOf(row) + column);
			
			x += 150;
			column ++;
			if(x == 450){
				x = 0;
				column = 1;
				y += 150;
				row ++;
			}
		}
		
		this.theme = theme;
		if(Main.getOS() == "Mac OS X"){
			super.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/" + theme + "/background.jpeg")), null, null, null, new BackgroundSize(100.0, 450.0, true, false, true, true))));
		}
		else {
			super.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/staticFiles/themes/" + theme + "/background.jpg")), null, null, null, new BackgroundSize(100.0, 450.0, true, false, true, true))));
		}
	}
}
