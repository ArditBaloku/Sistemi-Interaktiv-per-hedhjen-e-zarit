package projekti;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class Game extends BorderPane
{
	public static Scene logInScene, signInScene, gameScene;

	public BorderPane getGameView()
	{
		BorderPane pane= new BorderPane();
		
		
		Menu fileMenu = new Menu("File");
		MenuItem newGame = new MenuItem("New Game");
		MenuItem highScores = new MenuItem("High Scores");
		MenuItem personalScores = new MenuItem("Personal Scores");
		
		newGame.setOnAction(e->
								{(Main.window).setScene(gameScene);
								 (Main.window).setTitle("Yahtzee");});
		highScores.setOnAction(e-> new HighScores().getStage2());
		personalScores.setOnAction(e-> new PersonalScores().getStage3());
		
		fileMenu.getItems().addAll(newGame, new SeparatorMenuItem(), highScores, personalScores);
		
		Menu viewMenu = new Menu("View");
		ToggleGroup viewToggle = new ToggleGroup();
		RadioMenuItem light = new RadioMenuItem("Light Mode");
		RadioMenuItem dark = new RadioMenuItem("Dark Mode");
		light.setToggleGroup(viewToggle);
		dark.setToggleGroup(viewToggle);
			
		viewMenu.getItems().addAll(light, dark);
		
		Menu helpMenu = new Menu("Help");
		MenuItem help = new MenuItem("Help");
		
		
		helpMenu.getItems().add(help);
		
		MenuBar bar = new MenuBar();
		bar.getMenus().addAll(fileMenu,viewMenu,helpMenu);
		
		// loja ktu
		Button signOutBtn = new Button("Sign Out");
		signOutBtn.setOnAction(e -> {
			(Main.window).setScene(Main.indexScene);
		});
		pane.setTop(bar);
		pane.setCenter(signOutBtn);
		
		return pane;
	}
}
