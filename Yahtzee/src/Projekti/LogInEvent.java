package Projekti;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class LogInEvent implements EventHandler<ActionEvent>
{
	public void handle(ActionEvent e)
	{
		FormValidation.emailValidate(LogInForm.EmailTextField, "Shëno email-in valid!");
	}
}
