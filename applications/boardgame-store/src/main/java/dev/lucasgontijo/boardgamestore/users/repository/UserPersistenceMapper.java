package dev.lucasgontijo.boardgamestore.users.repository;

import dev.lucasgontijo.boardgamestore.users.domain.User;
import dev.lucasgontijo.boardgamestore.users.domain.UserId;
import dev.lucasgontijo.boardgamestore.users.domain.Username;

class UserPersistenceMapper {
	
	public static User toDomain(UserEntity entity) {
		
		User user = new User();
		user.setId(new UserId(entity.getId()));
		user.setUsername(new Username(entity.getUsername()));
		user.setPassword(entity.getPassword());
		user.setFirstName(entity.getFirstName());
		user.setMiddleName(entity.getMiddleName());
		user.setLastName(entity.getLastName());
		user.setEmail(entity.getEmail());
		user.setMobilePhone(entity.getMobilePhone());
		user.setThumbnailId(entity.getThumbnailId());
		user.setPhotoId(entity.getPhotoId());
		user.setBirthDate(entity.getBirthDate());
		user.setNeedChangePassword(entity.getNeedChangePassword());
		
		return user;
	}
	
	public static UserEntity toEntity(User domain) {
		
		UserEntity entity = new UserEntity();
		entity.setId(domain.getId() == null ? null : domain.getId().getValue());
		entity.setUsername(domain.getUsername() == null ? null : domain.getUsername().getValue());
		entity.setPassword(domain.getPassword());
		entity.setFirstName(domain.getFirstName());
		entity.setMiddleName(domain.getMiddleName());
		entity.setLastName(domain.getLastName());
		entity.setEmail(domain.getEmail());
		entity.setMobilePhone(domain.getMobilePhone());
		entity.setThumbnailId(domain.getThumbnailId());
		entity.setPhotoId(domain.getPhotoId());
		entity.setBirthDate(domain.getBirthDate());
		entity.setNeedChangePassword(domain.getNeedChangePassword());
		
		return entity;
		
	}
}
