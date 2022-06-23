package com.ccms.security.domain.service;

import com.ccms.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();
    List<Role> getAll();
}
