package projekti;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import utils.Session;

public class StatusBar extends HBox
{
	public HBox getStatusBar()
	{
		HBox statusBar = new HBox(10);
		Label userInfo = new Label();
		userInfo.setPadding(new Insets(5,20,5,5));
		String fullName = Session.getFullName();
		userInfo.setText("Player: " + fullName);
		userInfo.setStyle("-fx-text-fill:black;");
		statusBar.getChildren().add(userInfo);
		statusBar.setStyle("-fx-background-color:linear-gradient(#c2b6b6, #576574);");
		
		return statusBar;
	}
}
