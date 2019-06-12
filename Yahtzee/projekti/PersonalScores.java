package projekti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.DBConnection;
import utils.Session;

public class PersonalScores 
{
	private String fullName = Session.getFullName();
	private int totalScore, ones, twos, threes, fours, fives, sixes, noOfGames;
	private Label fullNameTxt = new Label("Player: " + fullName);
	private Label totalScoreTxt = new Label();
	private Label onesTxt = new Label();
	private Label twosTxt = new Label();
	private Label threesTxt = new Label();
	private Label foursTxt = new Label();
	private Label fivesTxt = new Label();
	private Label sixesTxt = new Label();
	private Label noOfGamesTxt = new Label();
	
	public void getStage3()
	{
		String query = "SELECT * "
					 + "FROM player_statistics p "
					 + "INNER JOIN users u ON u.idusers = p.userId "
					 + "WHERE p.userId = " + Session.id;
		try {
			PreparedStatement stmnt = DBConnection.getConnection().prepareStatement(query);
			ResultSet result = stmnt.executeQuery();
			result.next();
			totalScore = result.getInt("totalScore");
			ones = result.getInt("ones");
			twos = result.getInt("twos");
			threes = result.getInt("threes");
			fours = result.getInt("fours");
			fives = result.getInt("fives");
			sixes = result.getInt("sixes");
			noOfGames = result.getInt("noOfGames");
			totalScoreTxt.setText("Total score: " + String.valueOf(totalScore));
			onesTxt.setText("Ones: " + String.valueOf(ones));
			twosTxt.setText("Twos: " + String.valueOf(twos));
			threesTxt.setText("Threes: " + String.valueOf(threes));
			foursTxt.setText("Fours: " + String.valueOf(fours));
			fivesTxt.setText("Fives: " + String.valueOf(fives));
			sixesTxt.setText("Sixes: " + String.valueOf(sixes));
			noOfGamesTxt.setText("Games played: " + String.valueOf(noOfGames));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		BorderPane pane = new BorderPane();
		StatusBar statusBar = new StatusBar();
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(fullNameTxt, totalScoreTxt, onesTxt, twosTxt, threesTxt, foursTxt, fivesTxt, sixesTxt, noOfGamesTxt);
		vbox.setAlignment(Pos.CENTER);
		Stage stage3 = new Stage();  
		
		pane.setCenter(vbox);
		pane.setBottom(statusBar.getStatusBar());
			
		stage3.setScene(new Scene(pane, 500, 500));
		stage3.setTitle("Personal Scores");
				
		stage3.show();
	}
}
