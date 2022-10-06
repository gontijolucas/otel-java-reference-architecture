package dev.lucasgontijo.boardgamestore.users.domain;

import javax.validation.constraints.NotEmpty;

public class Username {
	
	@NotEmpty
	private String value;
	
	public Username() {
	}
	
	public Username(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
