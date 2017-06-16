package ru.tools.presenter;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;
import ru.tools.TimelineScreen;
import ru.tools.authentication.AuthenticationException;
import ru.tools.authentication.SimpleUserPasswordAuthenticationStrategy;

import java.security.Principal;

import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;


public class LoginBehavior implements ClickListener {
private static final long serialVersionUID = 1L;

	private final TextField loginField;
	private final PasswordField passwordField;

	public LoginBehavior(TextField loginField, PasswordField passwordField) {

		this.loginField = loginField;
		this.passwordField = passwordField;
	}

	public void buttonClick(Button.ClickEvent event) {

		try {

			String login = loginField.getValue();
			String password = passwordField.getValue();

			Principal user = new SimpleUserPasswordAuthenticationStrategy()
					.authenticate(login, password);

			VaadinSession.getCurrent().setAttribute(Principal.class, user);

			UI.getCurrent().setContent(new TimelineScreen());

			Notification.show("Successful authentication");

		} catch (AuthenticationException e) {

			Notification.show(e.getMessage(), ERROR_MESSAGE);
		}
	}

}
