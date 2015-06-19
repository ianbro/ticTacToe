package backend;

import frontEnd.Board;
import frontEnd.HomeScreen;
import frontEnd.ResultScreen;
import frontEnd.Square;
import javafx.scene.Node;
import application.Main;
import backend.ai.CPU;

public class Game {

	private Board gameBoard;
	private HomeScreen mainMenu;
	private ResultScreen resultScreen;
	
	private String theme;
	public Player[] player;
	public int turn = 0;
	public String mode; //either "single" or "multi"
	
	public Game(Player one, Player two, String theme, String mode){
		this.mode = mode;
		gameBoard = new Board(theme);
		mainMenu = new HomeScreen(theme);
		
		player = new Player[2];
		player[0] = one;
		player[1] = two;
		
		this.theme = theme;
	}
	
	public Board getBoard(){
		return this.gameBoard;
	}
	
	public HomeScreen getMainMenu(){
		return this.mainMenu;
	}
	
	public void setResultScreen(ResultScreen rs){
		this.resultScreen = rs;
	}
	
	public ResultScreen getResultScreen(){
		return this.resultScreen;
	}
	
	public void nextTurn(){
		if(checkWin(this.player[(turn % 2)])){
			this.resultScreen = new ResultScreen(this.theme, (turn % 2)+1);
			Main.mainScene.setRoot(this.resultScreen);
		}
		else if(this.checkTie()){
			this.resultScreen = new ResultScreen(this.theme, 3);
			Main.mainScene.setRoot(this.resultScreen);
		}
		else{
			this.turn ++;
			if(this.mode.equals("single") && this.turn%2 == 1){
				System.out.println("moving");
				CPU cpu = (CPU)player[1];
				cpu.decideMove();
			}
		}
	}
	
	private boolean checkTie(){
		
		boolean full = false;
		
		for(Node s1: this.gameBoard.getChildren()){
			Square s = (Square)s1;
			
			if(!s.isTaken()){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkWin(Player p){
		Square a1 = (Square) this.gameBoard.getChildren().get(0);
		Square a2 = (Square) this.gameBoard.getChildren().get(1);
		Square a3 = (Square) this.gameBoard.getChildren().get(2);
		Square b1 = (Square) this.gameBoard.getChildren().get(3);
		Square b2 = (Square) this.gameBoard.getChildren().get(4);
		Square b3 = (Square) this.gameBoard.getChildren().get(5);
		Square c1 = (Square) this.gameBoard.getChildren().get(6);
		Square c2 = (Square) this.gameBoard.getChildren().get(7);
		Square c3 = (Square) this.gameBoard.getChildren().get(8);
		
		if(a1.isOwnedBy(p) && a2.isOwnedBy(p) && a3.isOwnedBy(p)){
			return true;
		}
		else if(b1.isOwnedBy(p) && b2.isOwnedBy(p) && b3.isOwnedBy(p)){
			return true;
		}
		else if(c1.isOwnedBy(p) && c2.isOwnedBy(p) && c3.isOwnedBy(p)){
			return true;
		}
		

		else if(a1.isOwnedBy(p) && b1.isOwnedBy(p) && c1.isOwnedBy(p)){
			return true;
		}
		else if(a2.isOwnedBy(p) && b2.isOwnedBy(p) && c2.isOwnedBy(p)){
			return true;
		}
		else if(a3.isOwnedBy(p) && b3.isOwnedBy(p) && c3.isOwnedBy(p)){
			return true;
		}
		

		else if(a1.isOwnedBy(p) && b2.isOwnedBy(p) && c3.isOwnedBy(p)){
			return true;
		}
		else if(c1.isOwnedBy(p) && b2.isOwnedBy(p) && a3.isOwnedBy(p)){
			return true;
		}
		
		else{
			return false;
		}
	}
}
