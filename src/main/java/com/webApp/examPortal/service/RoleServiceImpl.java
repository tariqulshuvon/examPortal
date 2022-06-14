package com.webApp.examPortal.service;

import com.webApp.examPortal.model.Role;
import com.webApp.examPortal.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;





    @Override
    public Role findById(Long id) {
        return roleRepository.getById(id);
    }
}
