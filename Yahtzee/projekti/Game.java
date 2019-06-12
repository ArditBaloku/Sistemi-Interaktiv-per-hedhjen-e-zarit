package projekti;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
import utils.DBConnection;

public class Game extends BorderPane
{
	public static Scene logInScene, signInScene, gameScene;
	private int score = 0;
	private int rolls = 0;
	private Dice dice = new Dice();
	private ImageView face = new ImageView(dice.getFace());
	private int[] stats = {0, 0, 0, 0, 0, 0};

	public BorderPane getGameView()
	{
		BorderPane pane= new BorderPane();

		
		Menu fileMenu = new Menu("_File");
		MenuItem newGame = new MenuItem("_New Game");
		MenuItem highScores = new MenuItem("_High Scores");
		MenuItem personalScores = new MenuItem("_Personal Scores");
		
		newGame.setOnAction(e->
								{(Main.window).setScene(gameScene);
								 (Main.window).setTitle("Yahtzee");});
		highScores.setOnAction(e-> new HighScores().getStage2());
		personalScores.setOnAction(e-> new PersonalScores().getStage3());
		
		fileMenu.getItems().addAll(newGame, new SeparatorMenuItem(), highScores, personalScores);
		
		Menu viewMenu = new Menu("_View");
		ToggleGroup viewToggle = new ToggleGroup();
		RadioMenuItem light = new RadioMenuItem("_Light Mode");
		RadioMenuItem dark = new RadioMenuItem("_Dark Mode");
		light.setToggleGroup(viewToggle);
		dark.setToggleGroup(viewToggle);
			
		viewMenu.getItems().addAll(light, dark);
		
		Menu helpMenu = new Menu("_Help");
		MenuItem aboutHelpItem = new MenuItem("_About"); 
	    helpMenu.getItems().add(aboutHelpItem); 
	        
	    aboutHelpItem.setOnAction(e -> {Help.about();});
		
		MenuBar bar = new MenuBar();
		bar.getMenus().addAll(fileMenu,viewMenu,helpMenu);
		
		// loja ktu
		Button rollBtn = new Button("Roll Dice");
		Label scoreLabel = new Label();
		Label roundsLabel = new Label("Click the button to start playing");
		rollBtn.setOnAction(e -> {
			int roll = dice.roll();
			score += roll;
			stats[roll-1]++;
			dice.setFace(roll);
			face.setImage(dice.getFace());
			rolls++;
			scoreLabel.setText(Integer.toString(score));
			roundsLabel.setText("You have " + (10 - rolls) + " rounds left");
			if (rolls == 10) {
				if (insertScore(Session.getId(), score, stats)) {
					System.out.println("Score recorded");
				} else {
					System.out.println("Error in recording score");
				};
				// insert statistics into database
				rolls = 0;
				score = 0;
				for (int i = 0; i < stats.length; i++) {
					stats[i] = 0;
				}
				roundsLabel.setText("Game Over! Click the button to start playing again");
			}
			
		});
		//
		Button signOutBtn = new Button("Sign Out");
		signOutBtn.setOnAction(e -> {
			(Main.window).setScene(Main.indexScene);
			Session.clearSession();
		});
			
		
		pane.setTop(bar);
		//pane.setCenter(signOutBtn);
		
		face.setFitHeight(150);
		face.setFitWidth(150);
		pane.setCenter(face);
		pane.setBottom(rollBtn);
		pane.setRight(scoreLabel);
		pane.setLeft(roundsLabel);
		return pane;
	}
	
	public boolean insertScore(int playerId, int score, int[] stats) {
		try {
			String query = "INSERT INTO games_played(playerId, score) "
					     + "VALUES (" + playerId + ", " + score + ");"
					     + "UPDATE player_statistics "
					     + "SET totalScore = totalScore + " + score + ", "
					     + "ones = ones + " + stats[0] + ", "
						 + "twos = twos + " + stats[1] + ", "
						 + "threes = threes + " + stats[2] + ", "
						 + "fours = fours + " + stats[3] + ", "
						 + "fives = fives + " + stats[4] + ", "
						 + "sixes = sixes + " + stats[5] + ", "
						 + "noOfGames = noOfGames + 1 "
						 + "WHERE userId = " + playerId + ";";
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
