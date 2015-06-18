package application;
	
import frontEnd.HomeScreen;
import frontEnd.Square;
import frontEnd.ThemeScreen;
import backend.Game;
import backend.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		mainScene = null;
		try {
			AnchorPane root = new AnchorPane();
			
			if(Main.getOS().equals("Mac OS X")){
				System.out.println(true);
				root.setMinSize(450, 450);
			}
			else {
				root.setMinHeight(440);
				root.setMinWidth(440);
			}
			
//			root.getChildren().add(new HomeScreen("basic"));
			root.getChildren().add(Main.game.getMainMenu());
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
		game = new Game(new Player("Player 1", "x"), new Player("Player 2", "circle"), "basic");
		launch(args);
	}
	
	public static void toThemeScreen(String theme){
		mainScene.setRoot(new ThemeScreen(theme));
	}
	
	public static String getOS(){
		return (System.getProperty("os.name"));
	}
	
	public static void newGame(String theme){
		game = new Game(new Player("Player 1", "x"), new Player("Player 2", "circle"), theme);
		mainScene.setRoot(game.getBoard());
	}
}
