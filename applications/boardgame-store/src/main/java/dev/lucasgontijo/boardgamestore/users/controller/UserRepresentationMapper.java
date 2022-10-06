package dev.lucasgontijo.boardgamestore.users.controller;

import dev.lucasgontijo.boardgamestore.users.domain.User;
import dev.lucasgontijo.boardgamestore.users.domain.UserId;
import dev.lucasgontijo.boardgamestore.users.domain.Username;

class UserRepresentationMapper {
	
	public static User toDomain(UserRepresentation representation) {
		
		User user = new User();
		
		user.setId(representation.id() == null ? null : new UserId(representation.id()));
		user.setUsername(representation.username() == null ? null : new Username(representation.username()));
		user.setPassword(representation.password());
		user.setFirstName(representation.firstName());
		user.setMiddleName(representation.middleName());
		user.setLastName(representation.lastName());
		user.setEmail(representation.email());
		user.setMobilePhone(representation.mobilePhone());
		user.setThumbnailId(representation.thumbnailId());
		user.setPhotoId(representation.photoId());
		user.setBirthDate(representation.birthDate());
		user.setNeedChangePassword(representation.needChangePassword());
		
		return user;
	}
	
	public static UserRepresentation toRepresentation(User domain) {
		
		return new UserRepresentation(
				domain.getId().getValue(),
				domain.getUsername().getValue(),
				domain.getFirstName(),
				null,
				domain.getMiddleName(),
				domain.getLastName(),
				domain.getEmail(),
				domain.getMobilePhone(),
				domain.getThumbnailId(),
				domain.getPhotoId(),
				domain.getBirthDate(),
				domain.getNeedChangePassword()
		);
	}
}
