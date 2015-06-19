package frontEnd;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import backend.Piece;
import backend.Player;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import com.sun.javafx.sg.prism.NGNode;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Square extends AnchorPane {

	private ImageView frame;
	private Image square;
	private Controller controller;
	private boolean isTaken;
	public Player owner;

	public SequentialTransition fadeTransition;

	public boolean isOwnedBy(Player p) {
		if (this.isTaken) {
			if (this.owner.equals(p)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static Square init(String theme) {
		Square toInit = new Square(theme);
		toInit.controller = toInit.new Controller(toInit);
		toInit.isTaken = false;

		toInit.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				toInit.setEffect(new Glow(0.8));

				ImageView image = (ImageView) toInit.getChildren().get(0);

				toInit.fadeTransition = new SequentialTransition();

				FadeTransition fadeOut = getFadeTransition(image,
						image.getOpacity(), 0.0, 800);
				FadeTransition fadeIn = getFadeTransition(image, 0.0, 1.0, 800);

				toInit.fadeTransition.getChildren().addAll(fadeOut, fadeIn);
				toInit.fadeTransition.setCycleCount(Timeline.INDEFINITE);
				toInit.fadeTransition.play();
			}

			public FadeTransition getFadeTransition(ImageView imageView,
					double fromValue, double toValue, int durationInMilliseconds) {

				FadeTransition ft = new FadeTransition(Duration
						.millis(durationInMilliseconds), imageView);
				ft.setFromValue(fromValue);
				ft.setToValue(toValue);

				return ft;

			}
		});

		toInit.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				toInit.setEffect(null);
				toInit.fadeTransition.stop();
				((ImageView) toInit.getChildren().get(0)).setOpacity(1.0);
			}
		});

		toInit.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				toInit.placePiece(Main.game.player[(Main.game.turn % 2)].team);
			}
		});
		return toInit;
	}

	public Square(String theme) {
		square = new Image(getClass().getResourceAsStream(
				"/staticFiles/themes/" + theme + "/square.png"));
		frame = new ImageView(square);
		frame.setFitWidth(150);
		frame.setPreserveRatio(true);
		super.getChildren().add(frame);
		this.controller = new Controller(this);
	}

	public void placePiece(String team) {
		this.controller.selected(team);
	}

	public boolean isTaken() {
		return this.isTaken;
	}

	public class Controller {

		private Square parent;

		public Controller(Square parent) {
			this.parent = parent;
		}

		public void selected(String team) {
			Piece toAdd = new Piece(team);

			if (!(this.parent.isTaken())) {
				this.parent.getChildren().add(toAdd);
				this.parent.setLeftAnchor(toAdd, 10.0);
				this.parent.setTopAnchor(toAdd, 10.0);
				this.parent.isTaken = true;
				this.parent.owner = Main.game.player[(Main.game.turn % 2)];
				Main.game.nextTurn();
			}
		}
	}
}
