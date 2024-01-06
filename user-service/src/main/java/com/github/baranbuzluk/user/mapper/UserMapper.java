package com.github.baranbuzluk.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.baranbuzluk.user.dto.UserDto;
import com.github.baranbuzluk.user.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toEntity(UserDto dto);
}
