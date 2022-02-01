package dev.edgeahz.userapi.service;

import dev.edgeahz.userapi.domain.dto.RoleDto;
import dev.edgeahz.userapi.domain.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> store(RoleDto roleDto);

    Optional<Role> search(String roleName);

    List<Role> search();

    void destroy(String roleName);
}
