package dev.lucasgontijo.boardgamestore.users.domain.errors;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
