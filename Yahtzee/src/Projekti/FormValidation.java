package Projekti;

import java.util.regex.Pattern;
import javafx.scene.control.TextField;

public class FormValidation 
{
	public static final String textPattern = "[a-z A-Z]+"; 
	public static final String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com";
	public static final Pattern pattern = Pattern.compile(emailPattern);
	
	public static boolean textFieldNotEmpty(TextField t)
	{
		boolean b = false;
		if(t.getText()!=null && !t.getText().isEmpty())
		{
			b=true;
		}
		return b;
	}
	public static boolean textFieldNotEmpty(TextField t, String sValidationText)
	{
		boolean b = true;
		String err = null;
		if(!textFieldNotEmpty(t))
		{
			b=false;
			err=sValidationText;
			t.setStyle("-fx-background:red;");
			t.setPromptText(err);
		}
		return b;
	}
	public static boolean emailValidate(TextField t, String sValidationText)
	{
		boolean b = true;
		String email = t.getText();
		String err = null;
		if(!textFieldNotEmpty(t)||!pattern.matcher(email).matches())
		{
			b=false;
			err=sValidationText;
			t.setStyle("-fx-background:red;");
			t.setPromptText(err);
		}
		return b;
	}
}