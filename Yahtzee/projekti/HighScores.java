package projekti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import utils.DBConnection;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class HighScores
{
	Label label2 = new Label();
	public void getStage2()
	{
		Stage Stage2 = new Stage();  
		VBox pane = new VBox(20);
		pane.setPadding(new Insets(20,20,20,20));
		pane.setAlignment(Pos.CENTER);	
		
		getScores();
		Image image = new Image("img/trofe.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(150);
		imageView.setFitWidth(150);
		
		Label label1 = new Label("HIGH SCORES");
				
		pane.getChildren().addAll(imageView,label1,label2);
				
		Scene scene = new Scene(pane,400,400);
			
		Stage2.setTitle("High Scores");
		Stage2.setScene(scene);
				
		Stage2.show();
	}
	private void getScores()
	{
		try 
		{
			String query = "SELECT MAX(score) FROM games_played WHERE playerId = ?";
			
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, Session.getId());

			ResultSet resultSet = preparedStatement.executeQuery();	
			if(resultSet.next())
			{
				if(resultSet.getInt(1)>0) 
				{
				label2.setText(Integer.toString(resultSet.getInt(1)));
				}
				else
				{
					label2.setText("No High Scores yet!");
				}
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
	}
}

