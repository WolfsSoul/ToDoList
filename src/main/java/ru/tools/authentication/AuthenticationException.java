package ru.tools.authentication;

/**
 * Created by Admin
 */
public class AuthenticationException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String msg, Throwable t) {

		super(msg, t);
	}

	public AuthenticationException(String msg) {

		super(msg);
	}

	public AuthenticationException(Throwable t) {

		super(t);
	}
}
