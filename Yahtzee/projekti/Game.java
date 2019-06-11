package projekti;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Game extends BorderPane
{
	public static Scene logInScene, signInScene, gameScene;
	private int score = 0;
	private int rolls = 0;
	private Dice dice = new Dice();
	private ImageView face = new ImageView(dice.getFace());

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
		MenuItem aboutHelpItem = new MenuItem("About"); 
	    helpMenu.getItems().add(aboutHelpItem); 
	        
	    aboutHelpItem.setOnAction(e -> {Help.about();});
		
		MenuBar bar = new MenuBar();
		bar.getMenus().addAll(fileMenu,viewMenu,helpMenu);
		
		// loja ktu
		Button rollBtn = new Button("Roll Dice");
		Label scoreLabel = new Label();
		rollBtn.setOnAction(e -> {
			int roll = dice.roll();
			score += roll;
			dice.setFace(roll);
			face.setImage(dice.getFace());
			rolls++;
			if (rolls == 10) {
				// insert score and player into database
				// show game has ended message
				rolls = 0;
				score = 0;
			}
			scoreLabel.setText(Integer.toString(score));
		});
		//
		Button signOutBtn = new Button("Sign Out");
		signOutBtn.setOnAction(e -> {
			(Main.window).setScene(Main.indexScene);
		});
			
		
		pane.setTop(bar);
		//pane.setCenter(signOutBtn);
		
		face.setFitHeight(150);
		face.setFitWidth(150);
		pane.setCenter(face);
		pane.setBottom(rollBtn);
		pane.setRight(scoreLabel);
		return pane;
	}
}
