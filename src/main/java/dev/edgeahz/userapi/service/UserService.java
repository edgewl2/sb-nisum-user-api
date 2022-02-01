package dev.edgeahz.userapi.service;

import dev.edgeahz.userapi.domain.dto.UserDto;
import dev.edgeahz.userapi.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> store(UserDto userDto);

    Optional<User> search(String email);

    Optional<String> authenticate(String email, String password);

    List<User> search();
}
