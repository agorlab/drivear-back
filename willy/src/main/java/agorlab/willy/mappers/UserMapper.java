package agorlab.willy.mappers;

import agorlab.willy.dto.request.UserRequestDto;
import agorlab.willy.dto.response.UserResponseDto;
import agorlab.willy.models.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDto userRequestDto);

    UserResponseDto toDto(User user);

}