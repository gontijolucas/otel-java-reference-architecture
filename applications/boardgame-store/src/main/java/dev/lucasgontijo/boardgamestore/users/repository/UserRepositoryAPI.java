package dev.lucasgontijo.boardgamestore.users.repository;

import dev.lucasgontijo.boardgamestore.users.domain.User;
import dev.lucasgontijo.boardgamestore.users.domain.UserId;
import dev.lucasgontijo.boardgamestore.users.domain.Username;

import java.util.Optional;

public interface UserRepositoryAPI  {
	
	Optional<User> findById(UserId id);
	
	Optional<User> findByUsername(Username username);
	
	boolean existsById(UserId id);
	boolean existsByUsername(Username username);
	
	boolean existsByIdOrUsername(UserId id, Username username);
	
	User save(User user);
	
	void delete(User user);
}
