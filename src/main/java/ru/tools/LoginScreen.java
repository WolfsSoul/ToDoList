package ru.tools;

import com.vaadin.ui.*;
import ru.tools.presenter.LoginBehavior;


public class LoginScreen extends FormLayout {

	private static final long serialVersionUID = 1L;


	private TextField loginField = new TextField("Пользователь");
	private PasswordField passwordField = new PasswordField("Пароль");
	private Button submitButton = new Button("OK");

	public LoginScreen() {
		setMargin(true);
		setSpacing(true);
		addComponent(loginField);
		addComponent(passwordField);
		addComponent(submitButton);

		submitButton.addClickListener(new LoginBehavior(loginField,
				passwordField));

	}
}
