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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.BCrypt;

public class SignInForm extends GridPane {
	
	public static Label FirstName = new Label("First Name:");
	public static TextField FirstNameTextField = new TextField();
	public static Label LastName = new Label("Last Name:");
	public static TextField LastNameTextField = new TextField();
	public static Label Email = new Label("Email:");
	public static TextField EmailTextField = new TextField();
	public static Label Password = new Label("Password:");
	public static PasswordField PasswordTextField = new PasswordField();
	public static Scene gameScene;

	public GridPane getSignIn() {
		
		Game game = new Game();
		gameScene = new Scene(game.getGameView(), 400, 400);
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");

		Button backBtn = new Button("<-");
		backBtn.setOnAction(e -> {
			cleanForm();
			(Main.window).setScene(Main.indexScene);
		});

		Text FormName = new Text("Sign In");
		FormName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));

		HBox title = new HBox(100);
		title.getChildren().addAll(FormName, backBtn);

		pane.add(title, 0, 0, 2, 1);
		pane.add(FirstName, 0, 1);
		pane.add(FirstNameTextField, 1, 1);
		pane.add(LastName, 0, 2);
		pane.add(LastNameTextField, 1, 2);
		pane.add(Email, 0, 3);
		pane.add(EmailTextField, 1, 3);
		pane.add(Password, 0, 4);
		pane.add(PasswordTextField, 1, 4);

		Button signInBtn = new Button("Sign In");
		signInBtn.setStyle("-fx-text-fill: black; " + "-fx-font-family:'Arial'; "
				+ "-fx-background-color: linear-gradient(lightblue, pink); "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		signInBtn.setOnAction(e -> {
			removeErrors();
			if(valid())
			{
				addUser(FirstNameTextField.getText(), LastNameTextField.getText(), EmailTextField.getText(), PasswordTextField.getText());
				cleanForm();
				(Main.window).setScene(gameScene);
				(Main.window).setTitle("Yahtzee");
			}
			else
			{
				FormValidation.textFieldNotEmpty(SignInForm.FirstNameTextField, "Shëno emrin!");
				FormValidation.textFieldNotEmpty(SignInForm.LastNameTextField, "Shëno mbiemrin!");
				FormValidation.emailValidate(SignInForm.EmailTextField, "Shëno email-in valid!");
			}
		});
		
		pane.add(signInBtn, 1, 5);
		GridPane.setHalignment(signInBtn, HPos.RIGHT);

		final Text actionTarget = new Text();
		pane.add(actionTarget, 1, 9);

		return pane;
	}

	public void cleanForm() {
		FirstNameTextField.setText("");
		FirstNameTextField.setStyle("-fx-background:white;");
		FirstNameTextField.setPromptText("");
		LastNameTextField.setText("");
		LastNameTextField.setStyle("-fx-background:white;");
		LastNameTextField.setPromptText("");
		EmailTextField.setText("");
		EmailTextField.setStyle("-fx-background:white;");
		EmailTextField.setPromptText("");
		PasswordTextField.setText("");
		PasswordTextField.setStyle("-fx-background:white;");
		PasswordTextField.setPromptText("");
	}

	public void removeErrors() {
		FirstNameTextField.setStyle("-fx-background:white;");
		FirstNameTextField.setPromptText("");
		LastNameTextField.setStyle("-fx-background:white;");
		LastNameTextField.setPromptText("");
		EmailTextField.setStyle("-fx-background:white;");
		EmailTextField.setPromptText("");
		PasswordTextField.setStyle("-fx-background:white;");
		PasswordTextField.setPromptText("");
	}
	public static boolean valid()
	{
		return FormValidation.emailValidate(SignInForm.EmailTextField,"Sheno email valid") && FormValidation.textFieldNotEmpty(SignInForm.FirstNameTextField) && FormValidation.textFieldNotEmpty(SignInForm.LastNameTextField) && FormValidation.textFieldNotEmpty(SignInForm.PasswordTextField);
	}
	public static boolean addUser(String firstName, String lastName, String email, String password) {
		try 
		{
			String hash = BCrypt.hashpw(password, BCrypt.gensalt());
			String query = "INSERT INTO users(firstName, lastName, email, password) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, hash);
			
			if (preparedStatement.executeUpdate() > 0) {
				ResultSet rs = preparedStatement.getGeneratedKeys();
				rs.next();
			    String query2 = "INSERT INTO player_statistics VALUES(?)";
			    PreparedStatement preparedStatement2 = DBConnection.getConnection().prepareStatement(query);
			    preparedStatement2.setInt(1, rs.getInt(1));
			    if (preparedStatement2.executeUpdate() > 0) {
			    	return true;
			    } else {
			    	return false;
			    }
			}
			return false;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
