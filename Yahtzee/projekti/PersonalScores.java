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
	private Label player = I18N.getLabel("label15");
	private Label fullNameTxt = new Label(player.getText() + fullName);
	private Label totalScoreTxt = I18N.getLabel("label20"); 
	private Label onesTxt = I18N.getLabel("label21");
	private Label twosTxt = I18N.getLabel("label22");
	private Label threesTxt = I18N.getLabel("label23");
	private Label foursTxt = I18N.getLabel("label24");
	private Label fivesTxt = I18N.getLabel("label25");
	private Label sixesTxt = I18N.getLabel("label26");
	private Label noOfGamesTxt = I18N.getLabel("label27"); 
	private Label personalScores;

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
			totalScoreTxt.setText(totalScoreTxt.getText() + String.valueOf(totalScore));
			onesTxt.setText(onesTxt.getText() + String.valueOf(ones));
			twosTxt.setText(twosTxt.getText()  + String.valueOf(twos));
			threesTxt.setText(threesTxt.getText()  + String.valueOf(threes));
			foursTxt.setText(foursTxt.getText()  + String.valueOf(fours));
			fivesTxt.setText(fivesTxt.getText()  + String.valueOf(fives));
			sixesTxt.setText(sixesTxt.getText()  + String.valueOf(sixes));
			noOfGamesTxt.setText(noOfGamesTxt.getText() + String.valueOf(noOfGames));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		personalScores = I18N.getLabel("label19");
		BorderPane pane = new BorderPane();
		StatusBar statusBar = new StatusBar();
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(fullNameTxt, totalScoreTxt, onesTxt, twosTxt, threesTxt, foursTxt, fivesTxt, sixesTxt, noOfGamesTxt);
		vbox.setAlignment(Pos.CENTER);
		Stage stage3 = new Stage();  
		
		pane.setCenter(vbox);
		pane.setBottom(statusBar.getStatusBar());
			
		stage3.setScene(new Scene(pane, 500, 500));
		stage3.setTitle(personalScores.getText());
				
		stage3.show();
	}
}
