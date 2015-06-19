package backend.ai;

import javafx.scene.Node;
import backend.Player;
import application.Main;
import frontEnd.Square;

public class CPU extends Player {
	
	public CPU(String team){
		super("Computer", team);
	}
	
	public void decideMove(){

		Square a1 = (Square) Main.game.getBoard().getChildren().get(0);
		Square a2 = (Square) Main.game.getBoard().getChildren().get(1);
		Square a3 = (Square) Main.game.getBoard().getChildren().get(2);
		Square b1 = (Square) Main.game.getBoard().getChildren().get(3);
		Square b2 = (Square) Main.game.getBoard().getChildren().get(4);
		Square b3 = (Square) Main.game.getBoard().getChildren().get(5);
		Square c1 = (Square) Main.game.getBoard().getChildren().get(6);
		Square c2 = (Square) Main.game.getBoard().getChildren().get(7);
		Square c3 = (Square) Main.game.getBoard().getChildren().get(8);
		
		Player p = Main.game.player[0];
		System.out.println(a1.owner);

		
		if(a1.isOwnedBy(this) && a2.isOwnedBy(this) && !a3.isTaken()){
			this.move(a3);
		}
		else if(a2.isOwnedBy(this) && a3.isOwnedBy(this) && !a1.isTaken()){
			this.move(a1);
		}
		else if(a1.isOwnedBy(this) && a3.isOwnedBy(this) && !a2.isTaken()){
			this.move(a2);
		}
		
		else if(b1.isOwnedBy(this) && b2.isOwnedBy(this) && !b3.isTaken()){
			System.out.println("yay");
			this.move(b3);
		}
		else if(b2.isOwnedBy(this) && b3.isOwnedBy(this) && !b1.isTaken()){
			this.move(b1);
		}
		else if(b1.isOwnedBy(this) && b3.isOwnedBy(this) && !b2.isTaken()){
			this.move(b2);
		}
		
		else if(c1.isOwnedBy(this) && c2.isOwnedBy(this) && !c3.isTaken()){
			this.move(c3);
		}
		else if(c2.isOwnedBy(this) && c3.isOwnedBy(this) && !c1.isTaken()){
			this.move(c1);
		}
		else if(c1.isOwnedBy(this) && c3.isOwnedBy(this) && !c2.isTaken()){
			this.move(c2);
		}
		
		
		else if(a1.isOwnedBy(this) && b1.isOwnedBy(this) && !c1.isTaken()){
			this.move(c1);
		}
		else if(b1.isOwnedBy(this) && c1.isOwnedBy(this) && !a1.isTaken()){
			this.move(a1);
		}
		else if(a1.isOwnedBy(this) && c1.isOwnedBy(this) && !b1.isTaken()){
			this.move(b1);
		}
		
		else if(a2.isOwnedBy(this) && b2.isOwnedBy(this) && !c2.isTaken()){
			this.move(c2);
		}
		else if(b2.isOwnedBy(this) && c2.isOwnedBy(this) && !a2.isTaken()){
			this.move(a2);
		}
		else if(a2.isOwnedBy(this) && c2.isOwnedBy(this) && !b2.isTaken()){
			this.move(b2);
		}
		
		else if(a3.isOwnedBy(this) && b3.isOwnedBy(this) && !c3.isTaken()){
			this.move(c3);
		}
		else if(b3.isOwnedBy(this) && c3.isOwnedBy(this) && !a3.isTaken()){
			this.move(a3);
		}
		else if(a3.isOwnedBy(this) && c3.isOwnedBy(this) && !b3.isTaken()){
			this.move(b3);
		}
		
		
		else if(a1.isOwnedBy(this) && b2.isOwnedBy(this) && !c3.isTaken()){
			this.move(c3);
		}
		else if(b2.isOwnedBy(this) && c3.isOwnedBy(this) && !a1.isTaken()){
			this.move(a1);
		}
		else if(a1.isOwnedBy(this) && c3.isOwnedBy(this) && !b2.isTaken()){
			this.move(b2);
		}
		
		else if(c1.isOwnedBy(this) && b2.isOwnedBy(this) && !a3.isTaken()){
			this.move(a3);
		}
		else if(a3.isOwnedBy(this) && b2.isOwnedBy(this) && !c1.isTaken()){
			this.move(c1);
		}
		else if(c1.isOwnedBy(this) && a3.isOwnedBy(this) && !b2.isTaken()){
			this.move(b2);
		}
		
		
		else if(a1.isOwnedBy(p) && a2.isOwnedBy(p) && !a3.isTaken()){
			this.move(a3);
		}
		else if(a2.isOwnedBy(p) && a3.isOwnedBy(p) && !a1.isTaken()){
			this.move(a1);
		}
		else if(a1.isOwnedBy(p) && a3.isOwnedBy(p) && !a2.isTaken()){
			this.move(a2);
		}
		
		else if(b1.isOwnedBy(p) && b2.isOwnedBy(p) && !b3.isTaken()){
			this.move(b3);
		}
		else if(b2.isOwnedBy(p) && b3.isOwnedBy(p) && !b1.isTaken()){
			this.move(b1);
		}
		else if(b1.isOwnedBy(p) && b3.isOwnedBy(p) && !b2.isTaken()){
			this.move(b2);
		}
		
		else if(c1.isOwnedBy(p) && c2.isOwnedBy(p) && !c3.isTaken()){
			this.move(c3);
		}
		else if(c2.isOwnedBy(p) && c3.isOwnedBy(p) && !c1.isTaken()){
			this.move(c1);
		}
		else if(c1.isOwnedBy(p) && c3.isOwnedBy(p) && !c2.isTaken()){
			this.move(c2);
		}
		
		
		else if(a1.isOwnedBy(p) && b1.isOwnedBy(p) && !c1.isTaken()){
			this.move(c1);
		}
		else if(b1.isOwnedBy(p) && c1.isOwnedBy(p) && !a1.isTaken()){
			this.move(a1);
		}
		else if(a1.isOwnedBy(p) && c1.isOwnedBy(p) && !b1.isTaken()){
			this.move(b1);
		}
		
		else if(a2.isOwnedBy(p) && b2.isOwnedBy(p) && !c2.isTaken()){
			this.move(c2);
		}
		else if(b2.isOwnedBy(p) && c2.isOwnedBy(p) && !a2.isTaken()){
			this.move(a2);
		}
		else if(a2.isOwnedBy(p) && c2.isOwnedBy(p) && !b2.isTaken()){
			this.move(b2);
		}
		
		else if(a3.isOwnedBy(p) && b3.isOwnedBy(p) && !c3.isTaken()){
			this.move(c3);
		}
		else if(b3.isOwnedBy(p) && c3.isOwnedBy(p) && !a3.isTaken()){
			this.move(a3);
		}
		else if(a3.isOwnedBy(p) && c3.isOwnedBy(p) && !b3.isTaken()){
			this.move(b3);
		}
		
		
		else if(a1.isOwnedBy(p) && b2.isOwnedBy(p) && !c3.isTaken()){
			this.move(c3);
		}
		else if(b2.isOwnedBy(p) && c3.isOwnedBy(p) && !a1.isTaken()){
			this.move(a1);
		}
		else if(a1.isOwnedBy(p) && c3.isOwnedBy(p) && !b2.isTaken()){
			this.move(b2);
		}
		
		else if(c1.isOwnedBy(p) && b2.isOwnedBy(p) && !a3.isTaken()){
			this.move(a3);
		}
		else if(a3.isOwnedBy(p) && b2.isOwnedBy(p) && !c1.isTaken()){
			this.move(c1);
		}
		else if(c1.isOwnedBy(p) && a3.isOwnedBy(p) && !b2.isTaken()){
			this.move(b2);
		}
		
		
		else if(!b2.isTaken()){
			this.move(b2);
		}
		
		else{
			for(Node n: Main.game.getBoard().getChildren()){
				Square s = (Square)n;
				if(!s.isTaken()){
					this.move(s);
					return;
				}
			}
		}
	}
	
	public void move(Square place){
		System.out.println(this + ", " + place);
		place.placePiece(Main.game.player[(Main.game.turn % 2)].team);
	}
}
