package com.ccms.security.service;

import com.ccms.security.domain.model.entity.Role;
import com.ccms.security.domain.model.enumeration.Roles;
import com.ccms.security.domain.persistence.RoleRepository;
import com.ccms.security.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private static final String[] DEFAULT_ROLES={ "ROLE_USER", "ROLE_OWNER", "ROLE_MUSICIAN"};

    @Override
    public void seed(){
        Arrays.stream(DEFAULT_ROLES).forEach(name->{
            Roles roleName=Roles.valueOf(name);
            if(!roleRepository.existsByName(roleName)){
                roleRepository.save((new Role()).withName(roleName));
            }
        });
    }

    @Override
    public List<Role> getAll(){
        return roleRepository.findAll();
    }
}
