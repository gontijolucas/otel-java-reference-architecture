package dev.lucasgontijo.boardgamestore.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
	
	boolean existsByUsername(String username);
	
	boolean existsByIdOrUsername(Long id, String username);
	
	Optional<UserEntity> findByUsername(String username);
}