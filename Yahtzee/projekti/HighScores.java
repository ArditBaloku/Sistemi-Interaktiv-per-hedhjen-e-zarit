package projekti;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighScores
{
	private Label label2 = new Label();
	private TableView table = new TableView();
	public void getStage2()
	{
		Stage Stage2 = new Stage();  
		BorderPane pane = new BorderPane();
		VBox insidePane = new VBox(20);
		insidePane.setPadding(new Insets(20,20,20,20));
		insidePane.setAlignment(Pos.CENTER);	
		
		StatusBar statusBar = new StatusBar();
		Image image = new Image("img/trofe.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(150);
		imageView.setFitWidth(150);
		
		Label label1 = new Label("HIGH SCORES");
				
		insidePane.getChildren().addAll(imageView,label1,label2);
		
		TableColumn<String, Scores> column1 = new TableColumn<>("Player");
		TableColumn<String, Scores> column2 = new TableColumn<>("Score");
		column1.setCellValueFactory(new PropertyValueFactory("player"));
		column2.setCellValueFactory(new PropertyValueFactory("score"));
		column1.setPrefWidth(300);
		column2.setPrefWidth(300);
		
		table.getColumns().addAll(column1, column2);
		table.setPrefHeight(300);
		table.setPrefWidth(600);
		
		
		Pane tablePane = new Pane();
		tablePane.getChildren().add(table);
		
		pane.setLeft(insidePane);
		pane.setRight(tablePane);
		pane.setBottom(statusBar.getStatusBar());
		
		
		Scene scene = new Scene(pane,800,400);
			
		Stage2.setTitle("High Scores");
		Stage2.setScene(scene);
		showScores();
		Stage2.show();
	}
	
	private void showScores()
	{
		List<Scores> scores = Scores.getScores();
		ObservableList<Scores> scoreList = FXCollections.observableArrayList();
		for (int i = 0; i < scores.size(); i++) {
			scoreList.add(scores.get(i));
		}
		table.setItems(scoreList);
	}
}

