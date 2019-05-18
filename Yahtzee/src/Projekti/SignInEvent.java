package Projekti;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class SignInEvent implements EventHandler<ActionEvent>
{

	public void handle(ActionEvent e)
	{
		FormValidation.textFieldNotEmpty(SignInForm.FirstNameTextField, "Shëno emrin!");
		FormValidation.textFieldNotEmpty(SignInForm.LastNameTextField, "Shëno mbiemrin!");
		FormValidation.emailValidate(SignInForm.EmailTextField, "Shëno email-in valid!");
	}
}
