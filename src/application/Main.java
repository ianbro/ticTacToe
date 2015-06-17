package application;
	
import frontEnd.Square;
import backend.Game;
import backend.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		mainScene = null;
		try {
			AnchorPane root = new AnchorPane();
			root.setMinHeight(440);
			root.setMinWidth(440);
			root.getChildren().add(game.getBoard());
			((AnchorPane)root.getChildren().get(0)).setCenterShape(true);
			
			mainScene = new Scene(root,root.getMinWidth(),root.getMinHeight());
			primaryStage.setScene(mainScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		primaryStage.setResizable(false);
	}
	
	public static Game game;
	
	public static void main(String[] args) {
		game = new Game(new Player("Ian", "x"), new Player("Jake", "circle"), "basic");
		launch(args);
	}
}
