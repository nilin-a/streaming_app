package com.simbirsoft.user.mapper;

import com.simbirsoft.user.dto.UserDTO;
import com.simbirsoft.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}
