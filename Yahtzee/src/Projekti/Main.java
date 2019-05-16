package Projekti;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application
{
	public static Stage window;
	public static Scene indexscene;
	
	public static void main(String[] args) 
    {
    	launch(args);
    }
    @Override
    public void start(Stage primaryStage) 
    {
       window=primaryStage;
       
       Index index = new Index();
       indexscene = new Scene(index.getIndex(),400,400);
       window.setTitle("pitja");
       window.setScene(indexscene);
       window.show();
    }
}
