package dev.lucasgontijo.boardgamestore.users.services;

import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import dev.lucasgontijo.boardgamestore.commons.validation.OnDelete;
import dev.lucasgontijo.boardgamestore.commons.validation.OnGet;
import dev.lucasgontijo.boardgamestore.users.domain.User;
import dev.lucasgontijo.boardgamestore.users.domain.errors.UserAlreadyExistsException;
import dev.lucasgontijo.boardgamestore.users.domain.UserId;
import dev.lucasgontijo.boardgamestore.users.domain.errors.UserNotFoundException;
import dev.lucasgontijo.boardgamestore.users.domain.Username;
import dev.lucasgontijo.boardgamestore.users.repository.UserRepositoryAPI;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;

@Service
@Validated
public class UserService {
	
	private final UserRepositoryAPI userRepository;
	
	public UserService(UserRepositoryAPI userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Validated(OnCreate.class)
	public User create(@Valid User user) {
		
		boolean userAlreadyExists = userRepository.existsByUsername(user.getUsername());
		
		if (userAlreadyExists) {
			throw new UserAlreadyExistsException(String.format("User with username '%s', already exists.", user.getUsername()
					.getValue()));
		}
		
		user.setNeedChangePassword(true);
		
		return userRepository.save(user);
	}
	
	@Validated(OnGet.class)
	public User findById(@Valid UserId id) {
		
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(String.format("User with id '%s' not found.", id.getValue())));
	}
	
	@Validated(OnGet.class)
	public User findByUsername(@Valid Username usernameToBeFound) {
		
		return userRepository.findByUsername(usernameToBeFound)
				.orElseThrow(() -> new UserNotFoundException(String.format("User with username '%s' not found.", usernameToBeFound.getValue())));
	}
	
	@Validated(OnDelete.class)
	public void deleteById(@Valid UserId id) {
		
		Optional<User> byId = userRepository.findById(id);
		
		if (byId.isEmpty()) {
			throw new UserNotFoundException(String.format("User with id '%s' not found.", id.getValue()));
		}
		
		userRepository.delete(byId.get());
	}
}
