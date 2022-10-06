package dev.lucasgontijo.boardgamestore.users.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import dev.lucasgontijo.boardgamestore.commons.validation.OnDelete;
import dev.lucasgontijo.boardgamestore.commons.validation.OnGet;
import dev.lucasgontijo.boardgamestore.commons.validation.OnUpdate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

public class User {
	
	@Null(groups = OnCreate.class)
	@NotEmpty(groups = { OnGet.class, OnUpdate.class, OnDelete.class })
	@Valid
	private UserId id;
	
	@NotNull
	@Valid
	private Username username;
	
	@JsonIgnore
	@NotEmpty(groups = OnCreate.class)
	private String password;
	
	@NotEmpty
	private String firstName;
	
	private String middleName;
	
	@NotEmpty
	private String lastName;
	
	@Email
	@NotEmpty
	private String email;
	
	private String mobilePhone;
	
	private String thumbnailId;
	
	private String photoId;
	
	private LocalDate birthDate;
	
	@Null(groups = OnCreate.class)
	@NotNull(groups = OnGet.class)
	private Boolean needChangePassword;
	
	public UserId getId() {
		return id;
	}
	
	public void setId(UserId id) {
		this.id = id;
	}
	
	public Username getUsername() {
		return username;
	}
	
	public void setUsername(Username username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public String getThumbnailId() {
		return thumbnailId;
	}
	
	public void setThumbnailId(String thumbnailId) {
		this.thumbnailId = thumbnailId;
	}
	
	public String getPhotoId() {
		return photoId;
	}
	
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public Boolean getNeedChangePassword() {
		return needChangePassword;
	}
	
	public void setNeedChangePassword(Boolean needChangePassword) {
		this.needChangePassword = needChangePassword;
	}
}
