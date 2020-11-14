package com.toy.root.entity.user;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
	
	private UUID		user_uuid;
	private String		user_name;
}
