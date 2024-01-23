package com.simbirsoft.user.dto;

import com.simbirsoft.user.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private Role role;
}
