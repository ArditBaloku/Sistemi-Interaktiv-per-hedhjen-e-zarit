package projekti;

import java.util.Locale;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Index extends VBox {
	public static Scene logInScene, signInScene;
	private Button login;
	private Button signup;
	private Label welcome;

	public VBox getIndex() {
		VBox pane = new VBox(5);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");

		LogInForm form1 = new LogInForm();
		SignUpForm form2 = new SignUpForm();
		logInScene = new Scene(form1.getLogIn(), 400, 400);
		signInScene = new Scene(form2.getSignUp(), 400, 400);
		HBox buttonPane = new HBox(10);
		buttonPane.setAlignment(Pos.CENTER);

		login = I18N.getButton("Button3");
		signup = I18N.getButton("Button4");
		

		login.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		signup.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

		buttonPane.getChildren().addAll(login, signup);
		
		login.setOnAction(e -> {
			(Main.window).setScene(logInScene);
			(Main.window).setTitle("Log In");
		});
		signup.setOnAction(e -> {
			(Main.window).setScene(signInScene);
			(Main.window).setTitle("Sign Up");
		});
		
		HBox languageButtons = new HBox(10);
		
		Button alBtn = new Button();
		Button enBtn = new Button();
		
		Image alImg = new Image("img/al.png");
		Image enImg = new Image("img/en.png");
		alBtn.setGraphic(new ImageView(alImg));
		enBtn.setGraphic(new ImageView(enImg));
		
		alBtn.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});
		
		enBtn.setOnAction(e -> {
			I18N.setLocale(new Locale("en"));
		});
		
		languageButtons.getChildren().addAll(alBtn, enBtn);
		languageButtons.setAlignment(Pos.CENTER);
		

		welcome = I18N.getLabel("label14");
		welcome.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));

		pane.getChildren().addAll(welcome, buttonPane, languageButtons);
		return pane;
	}
}
