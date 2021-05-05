package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Self_employeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelfEmployeedRepository  extends JpaRepository<Self_employeed, Integer> {
}
