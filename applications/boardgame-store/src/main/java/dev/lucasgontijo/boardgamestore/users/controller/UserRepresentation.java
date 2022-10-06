package dev.lucasgontijo.boardgamestore.users.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_NULL)
record UserRepresentation(Long id,
						  String username,
						  String firstName,
						  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
						  String password,
						  String middleName,
						  String lastName,
						  String email,
						  String mobilePhone,
						  String thumbnailId,
						  String photoId,
						  @JsonSerialize(using = LocalDateSerializer.class)
						  LocalDate birthDate,
						  Boolean needChangePassword) {
	
}
