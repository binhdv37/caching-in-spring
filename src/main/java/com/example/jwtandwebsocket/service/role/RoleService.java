package com.example.jwtandwebsocket.service.role;

import com.example.jwtandwebsocket.common.exception.MyAppException;
import com.example.jwtandwebsocket.dto.role.RoleDto;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    RoleDto findById(UUID id);

    RoleDto reloadById(UUID id); // for testing purpose only - reload from db and update cache

    void clearCacheById(UUID id); // for tesing purpose only

    void clearAllCache(); // for testing purpose only

    List<RoleDto> findAll();

    RoleDto save(RoleDto roleDto, UUID actioner);

    boolean deleteById(UUID id) throws MyAppException;

}
