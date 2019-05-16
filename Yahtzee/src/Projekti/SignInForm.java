package Projekti;

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

public class SignInForm extends GridPane
{
	 Index index = new Index();
	 private GridPane SignIn()
	    {
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(20,20,20,20));
			pane.setHgap(10);
			pane.setVgap(10);
			pane.setStyle("-fx-background-color:linear-gradient(pink, lightblue); ");
			
			Button backbtn = new Button("<-");
			backbtn.setOnAction(e->(Main.window).setScene(Main.indexscene));
			
			Text FormName = new Text("Welcome");
			FormName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
			Label FirstName = new Label("Frist Name:");
			TextField FirstNameTextField = new TextField();
			Label LastName = new Label("Last Name:");
			TextField LastNameTextField = new TextField();
			Label Email = new Label("e-mail:");
			TextField EmailTextField = new TextField();
			Label Password = new Label("Password:");
			PasswordField PasswordTextField = new PasswordField();
			
			HBox title = new HBox(100);
			title.getChildren().addAll(FormName,backbtn);
			
			pane.add(title, 0, 0, 2, 1);
			pane.add(FirstName, 0, 1);
			pane.add(FirstNameTextField, 1, 1);
			pane.add(LastName, 0, 2);
			pane.add(LastNameTextField, 1, 2);
			pane.add(Email, 0, 3);
			pane.add(EmailTextField, 1, 3);
			pane.add(Password, 0, 4);
			pane.add(PasswordTextField, 1, 4);
			

			Button SignInBtn = new Button("Sign In");
			SignInBtn.setStyle("-fx-text-fill: black; "
					+ "-fx-font-family:'Arial'; "
					+ "-fx-background-color: linear-gradient(lightblue, pink); "
					+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(SignInBtn);
			pane.add(hbBtn, 1, 5);
			
			final Text actionTarget = new Text();
			pane.add(actionTarget, 1, 9);
			
			//SignInBtn.setOnAction();
			return pane;
	    }
	 public GridPane getSignIn()
	 {
		 return SignIn();
	 }
}
