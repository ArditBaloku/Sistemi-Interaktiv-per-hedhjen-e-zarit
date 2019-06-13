package projekti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.BCrypt;
import utils.DBConnection;
import utils.I18N;
import utils.Session;

public class LogInForm extends GridPane {
	
	private Label email = new Label();
	private Label password;
	private Label resultLabel1;
	private Label resultLabel2;
	
	public static TextField emailTxt = new TextField();
	public static PasswordField passwordTxt = new PasswordField();
	public static Label resultLabel = new Label();
	public static Scene gameScene;


	public GridPane getLogIn() {
		email = I18N.getLabel("label1");
		resultLabel1 = I18N.getLabel("TextField1");
		resultLabel2 = I18N.getLabel("resultlabel1");
		password = I18N.getLabel("label2");

		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");

		Button backBtn = new Button("←");
		backBtn.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		backBtn.setOnAction(e -> {
			cleanForm();
			(Main.window).setScene(Main.indexScene);
		});
		Text formName = I18N.getText("text1");
		formName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));

		HBox title = new HBox(120);
		title.getChildren().addAll(formName, backBtn);

		pane.add(title, 0, 0, 2, 1);
		pane.add(email, 0, 1);
		pane.add(emailTxt, 1, 1);
		pane.add(password, 0, 2);
		pane.add(passwordTxt, 1, 2);
		pane.add(resultLabel,0,4,2,1);

		Button logInBtn = I18N.getButton("Button3");
		logInBtn.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		logInBtn.setOnAction(e -> logInAction());
		pane.setOnKeyPressed(e -> {if(e.getCode() == KeyCode.ENTER) 
										logInAction();});
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
	public void logInAction()
	{
		FormValidation.emailValidate(LogInForm.emailTxt, "Invalid Email Address!");
		logIn();
		cleanForm();
	}
	private void logIn() 
	{
		try 
		{
			String query = "SELECT * FROM users WHERE email = ?";
			
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1,  emailTxt.getText().toLowerCase());

			ResultSet resultSet = preparedStatement.executeQuery();			
			if(resultSet.next()) 
			{
				if (BCrypt.checkpw(passwordTxt.getText(), resultSet.getString("password"))) {
					Session.setSession(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					Game game = new Game();
					gameScene = new Scene(game.getGameView(), 400, 400);
					(Main.window).setScene(gameScene);
					(Main.window).setResizable(false);
					(Main.window).setTitle("Yahtzee");
				}
				else {
					resultLabel.setStyle("-fx-text-fill:red");
					resultLabel.setText(resultLabel2.getText());
				}
			} 
			else 
			{
				resultLabel.setStyle("-fx-text-fill:red");
				resultLabel.setText(resultLabel2.getText());
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
	}
}
