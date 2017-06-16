package ru.tools.authentication;

import java.security.Principal;

/**
 * Created by ikkozlovsky
 */
public class User implements Principal {
	private final String name;
	private final String password;

	/**
	 * Only {@link UserPasswordAuthenticationStrategy} may create new instances.
	 *
	 * @param name
	 */
	User(String name, String password) {

		this.name = name;
		this.password = password;
	}

	public String getName() {

		return name;
	}

	public String getPassword() {
		return password;
	}
}
