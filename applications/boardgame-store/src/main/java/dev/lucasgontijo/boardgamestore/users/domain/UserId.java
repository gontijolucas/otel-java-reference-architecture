package dev.lucasgontijo.boardgamestore.users.domain;

import javax.validation.constraints.NotEmpty;

public class UserId {
	
	@NotEmpty
	private Long value;
	
	
	public UserId() {
	}
	
	public UserId(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}
	
	
}
