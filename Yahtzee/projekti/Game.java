package projekti;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Game extends StackPane
{
	public static Scene logInScene, signInScene;

	public StackPane getGameView()
	{
		StackPane pane= new StackPane();
		Button signOutBtn = new Button("Sign Out");
		signOutBtn.setOnAction(e -> {
			(Main.window).setScene(Main.indexScene);
		});
		pane.getChildren().add(signOutBtn);
		return pane;
	}
}
