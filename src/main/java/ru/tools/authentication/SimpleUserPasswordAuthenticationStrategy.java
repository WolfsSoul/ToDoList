package ru.tools.authentication;

import java.security.Principal;

/**
 * Created by Admin
 */
public class SimpleUserPasswordAuthenticationStrategy implements UserPasswordAuthenticationStrategy {

	protected int count=0;

	public Principal authenticate(String login, String password)
		throws AuthenticationException {

	if ("admin".equals(login) && "password".equals(password)) {
		count++;
		throw new AuthenticationException("Try again");
	}

	return new User(login, password);
	}
}
