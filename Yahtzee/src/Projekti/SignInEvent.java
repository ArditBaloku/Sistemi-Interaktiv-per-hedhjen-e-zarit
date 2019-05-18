package Projekti;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class SignInEvent implements EventHandler<ActionEvent>
{

	public void handle(ActionEvent e)
	{
		FormValidation.textFieldNotEmpty(SignInForm.FirstNameTextField, "Sh�no emrin!");
		FormValidation.textFieldNotEmpty(SignInForm.LastNameTextField, "Sh�no mbiemrin!");
		FormValidation.emailValidate(SignInForm.EmailTextField, "Sh�no email-in valid!");
	}
}
