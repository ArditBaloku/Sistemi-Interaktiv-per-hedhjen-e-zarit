package Projekti;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Index extends VBox
{
	public static Scene logInscene, signInscene;
	public VBox getIndex() 
	{
		VBox pane = new VBox(5);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20,20,20,20));
		pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");
		
		LogInForm form1 = new LogInForm();
		SignInForm form2 = new SignInForm();
	    logInscene = new Scene(form1.getLogIn(),400,400);  
	    signInscene = new Scene(form2.getSignIn(),400,400);
		HBox buttonPane = new HBox(10);
		buttonPane.setAlignment(Pos.CENTER);
		
		Button logInbtn = new Button("LogIn");
		Button signInbtn = new Button("SignIn");
		
		logInbtn.setStyle("-fx-text-fill: black; "
				+ "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		signInbtn.setStyle("-fx-text-fill: black; "
				+ "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		
		buttonPane.getChildren().addAll(logInbtn, signInbtn);
		
		logInbtn.setOnAction(e->(Main.window).setScene(logInscene));
		signInbtn.setOnAction(e->(Main.window).setScene(signInscene));
		
		Label label = new Label("Welome to our game!");
		label.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
		
		pane.getChildren().addAll(label, buttonPane);
		return pane;
	}
}
