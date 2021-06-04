package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Portfolio_pictures;
import com.oblom.DiplomServer.entities.Role;
import com.oblom.DiplomServer.repositories.PortfolioPicturesRepository;
import com.oblom.DiplomServer.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class RoleService {
    @Autowired
    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Transactional
    public List<Role> readAll() {
        return roleRepository.findAll();
    }
    @Transactional
    public Role read(int id){
        return roleRepository.findById(id).get();
    }

}
