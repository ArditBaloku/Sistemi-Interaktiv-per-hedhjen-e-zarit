package projekti;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class HighScores
{
	public void getStage2()
	{
		Stage Stage2 = new Stage();  
		VBox pane = new VBox(20);
		pane.setPadding(new Insets(20,20,20,20));
		pane.setAlignment(Pos.CENTER);	
		
		Image image = new Image("img/trofe.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(150);
		imageView.setFitWidth(150);
		
		Label label1 = new Label("HIGH SCORES");
		Label label2 = new Label();
				
		pane.getChildren().addAll(imageView,label1,label2);

				
		Scene scene = new Scene(pane,400,400);
			
		Stage2.setTitle("High Scores");
		Stage2.setScene(scene);
				
		Stage2.show();
	}
}
