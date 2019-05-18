package projekti;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LogInForm extends GridPane {
	public static Label email = new Label("Email:");
	public static TextField emailTxt = new TextField();
	public static Label password = new Label("Password:");
	public static PasswordField passwordTxt = new PasswordField();

	public GridPane getLogIn() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");

		Button backBtn = new Button("<-");
		backBtn.setOnAction(e -> {
			cleanForm();
			(Main.window).setScene(Main.indexScene);
		});

		Text formName = new Text("Log In");
		formName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));

		HBox title = new HBox(100);
		title.getChildren().addAll(formName, backBtn);

		pane.add(title, 0, 0, 2, 1);
		pane.add(email, 0, 1);
		pane.add(emailTxt, 1, 1);
		pane.add(password, 0, 2);
		pane.add(passwordTxt, 1, 2);

		Button logInBtn = new Button("Log In");
		logInBtn.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		logInBtn.setOnAction(e -> {
			FormValidation.emailValidate(LogInForm.emailTxt, "Shëno email-in valid!");
		});

		pane.add(logInBtn, 1, 3);
		GridPane.setHalignment(logInBtn, HPos.RIGHT);

		final Text actionTarget = new Text();
		pane.add(actionTarget, 1, 4);

		return pane;
	}

	public void cleanForm() {
		emailTxt.setText("");
		emailTxt.setStyle("-fx-background:white;");
		passwordTxt.setText("");
		passwordTxt.setStyle("-fx-background:white;");
	}
	
	public void removeErrors() {
		emailTxt.setStyle("-fx-background:white;");
		passwordTxt.setStyle("-fx-background:white;");
		emailTxt.setPromptText("");
		passwordTxt.setPromptText("");
	}
}
