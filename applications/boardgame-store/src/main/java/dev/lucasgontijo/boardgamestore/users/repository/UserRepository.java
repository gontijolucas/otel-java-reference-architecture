package dev.lucasgontijo.boardgamestore.users.repository;

import dev.lucasgontijo.boardgamestore.users.domain.User;
import dev.lucasgontijo.boardgamestore.users.domain.UserId;
import dev.lucasgontijo.boardgamestore.users.domain.Username;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
class UserRepository implements UserRepositoryAPI {
	
	private final UserRepositoryJPA userJpaRepository;
	
	UserRepository(UserRepositoryJPA userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}
	
	
	@Override
	public Optional<User> findById(UserId id) {
		
		Objects.requireNonNull(id, "User 'id' cannot be null");
		Objects.requireNonNull(id.getValue(), "User 'id' value cannot be null");
		
		Optional<UserEntity> byId = userJpaRepository.findById(id.getValue());
		
		return byId.map(UserPersistenceMapper::toDomain);
	}
	
	@Override
	public Optional<User> findByUsername(Username username) {
		
		Objects.requireNonNull(username, "'username' cannot be null");
		Objects.requireNonNull(username.getValue(), "'username' value cannot be null");
		
		Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username.getValue());
		return byUsername.map(UserPersistenceMapper::toDomain);
	}
	
	@Override
	public boolean existsById(UserId id) {
		
		Objects.requireNonNull(id, "'id' cannot be null");
		Objects.requireNonNull(id.getValue(), "'id' value cannot be null");
		
		return userJpaRepository.existsById(id.getValue());
	}
	
	@Override
	public boolean existsByUsername(Username username) {
		
		Objects.requireNonNull(username, "'username' cannot be null");
		Objects.requireNonNull(username.getValue(), "'username' value cannot be null");
		
		return userJpaRepository.existsByUsername(username.getValue());
	}
	
	@Override
	public boolean existsByIdOrUsername(UserId id, Username username) {
		
		Objects.requireNonNull(id, "'id' cannot be null");
		Objects.requireNonNull(id.getValue(), "'id' value cannot be null");
		Objects.requireNonNull(username, "'username' cannot be null");
		Objects.requireNonNull(username.getValue(), "'username' value cannot be null");
		
		return userJpaRepository.existsByIdOrUsername(id.getValue(), username.getValue());
	}
	
	@Override
	public User save(User user) {
		
		UserEntity userEntity = UserPersistenceMapper.toEntity(user);
		
		UserEntity savedUserEntity = userJpaRepository.save(userEntity);
		
		return UserPersistenceMapper.toDomain(savedUserEntity);
	}
	
	@Override
	public void delete(User user) {
		
		UserEntity userToDelete = UserPersistenceMapper.toEntity(user);
		
		userJpaRepository.delete(userToDelete);
	}
	
}
