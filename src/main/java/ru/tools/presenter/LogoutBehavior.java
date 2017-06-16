package ru.tools.presenter;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import ru.tools.LoginScreen;

import java.security.Principal;


public class LogoutBehavior implements ClickListener {
	private static final long serialVersionUID = 1L;

	public void buttonClick(Button.ClickEvent event) {

		VaadinSession.getCurrent().setAttribute(Principal.class, null);

		UI.getCurrent().setContent(new LoginScreen());

		Notification.show("You've been logged out");
	}
}
