package projekti;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.DBConnection;
import javafx.scene.Scene;

public class Main extends Application {
	public static Stage window;
	public static Scene indexScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		DBConnection.getConnection();
		window = primaryStage;

		Index index = new Index();
		indexScene = new Scene(index.getIndex(), 400, 400);
		window.setTitle("Welcome");
		window.setScene(indexScene);
		window.show();
	}
}
