package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Role;
import com.oblom.DiplomServer.entities.Self_employeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository   extends JpaRepository<Role, Integer> {
}
