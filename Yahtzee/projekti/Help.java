package projekti;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Help {

	public static void about() {

		Stage helpAboutStage = new Stage();

		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();

		String url;

		String lang = I18N.getLocale().toString();

		if (lang.equals("al")) {
			url = Help.class.getResource("alhelp.html").toExternalForm();
		} else {
			url = Help.class.getResource("enhelp.html").toExternalForm();
		}

		System.out.println("Local URL: " + url);

		webEngine.load(url);

		Scene sc = new Scene(browser, 500, 300);

		helpAboutStage.setTitle(I18N.getLabel("label28").getText());
		helpAboutStage.setScene(sc);

		helpAboutStage.show();
	}

}
