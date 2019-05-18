package projekti;

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

public class Index extends VBox {
	public static Scene logInScene, signInScene;

	public VBox getIndex() {
		VBox pane = new VBox(5);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");

		LogInForm form1 = new LogInForm();
		SignInForm form2 = new SignInForm();
		logInScene = new Scene(form1.getLogIn(), 400, 400);
		signInScene = new Scene(form2.getSignIn(), 400, 400);
		HBox buttonPane = new HBox(10);
		buttonPane.setAlignment(Pos.CENTER);

		Button logInBtn = new Button("LogIn");
		Button signInBtn = new Button("SignIn");

		logInBtn.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		signInBtn.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

		buttonPane.getChildren().addAll(logInBtn, signInBtn);

		logInBtn.setOnAction(e -> {
			(Main.window).setScene(logInScene);
			(Main.window).setTitle("Log In");
		});
		signInBtn.setOnAction(e -> {
			(Main.window).setScene(signInScene);
			(Main.window).setTitle("Sign In");
		});

		Label label = new Label("Welome to our game!");
		label.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));

		pane.getChildren().addAll(label, buttonPane);
		return pane;
	}
}
