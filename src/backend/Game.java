package backend;

import javafx.scene.Node;
import frontEnd.Board;
import frontEnd.Square;

public class Game {

	private Board gameBoard;
	public Player[] player;
	public int turn = 0;
	
	public Game(Player one, Player two, String theme){
		gameBoard = new Board(theme);
		
		player = new Player[2];
		player[0] = one;
		player[1] = two;
	}
	
	public Board getBoard(){
		return this.gameBoard;
	}
	
	public void nextTurn(){
		if(checkWin(this.player[(turn % 2)])){
			System.out.println("Player " + ((turn % 2) + 1) + " wins!");
			System.exit(0);
		}
		else if(this.checkTie()){
			System.out.println("Tie!");
			System.exit(0);
		}
		else{
			this.turn ++;
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
