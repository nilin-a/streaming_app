package com.simbirsoft.user.service;

import com.simbirsoft.user.dto.UserDTO;
import com.simbirsoft.user.mapper.UserMapper;
import com.simbirsoft.user.model.Role;
import com.simbirsoft.user.model.User;
import com.simbirsoft.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public User save(User user) {
        return userRepository.save(user);
    }

    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Пользователь с таким email уже существует");
        }
        return save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public UserDTO getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userMapper.toDTO(getByUsername(username));
    }

    public void setAdminRole() {
        UserDTO user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(userMapper.toEntity(user));
    }

    public void setUserRole() {
        UserDTO user = getCurrentUser();
        user.setRole(Role.ROLE_USER);
        save(userMapper.toEntity(user));
    }
}
