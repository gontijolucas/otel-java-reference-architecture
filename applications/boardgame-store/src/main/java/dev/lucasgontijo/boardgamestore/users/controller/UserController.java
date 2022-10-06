package dev.lucasgontijo.boardgamestore.users.controller;

import dev.lucasgontijo.boardgamestore.users.domain.User;
import dev.lucasgontijo.boardgamestore.users.domain.UserId;
import dev.lucasgontijo.boardgamestore.users.domain.Username;
import dev.lucasgontijo.boardgamestore.users.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping
	@ResponseBody
	public UserRepresentation create(@RequestBody UserRepresentation user) {
		
		User userToCreate = UserRepresentationMapper.toDomain(user);
		
		User createdUser = userService.create(userToCreate);
		
		return UserRepresentationMapper.toRepresentation(createdUser);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public UserRepresentation findById(@PathVariable("id") Long id) {
		
		UserId userId = new UserId(id);
		
		User foundUser = userService.findById(userId);
		
		return UserRepresentationMapper.toRepresentation(foundUser);
	}
	
	@GetMapping
	@ResponseBody
	public UserRepresentation findByUsername(@Param("username") String username) {
		
		Username usernameToBeFound = new Username(username);
		
		User foundUser = userService.findByUsername(usernameToBeFound);
		
		return UserRepresentationMapper.toRepresentation(foundUser);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		
		UserId userId = new UserId(id);
		
		userService.deleteById(userId);
	}
	
}
