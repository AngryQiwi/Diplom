package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Services_list;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesListRepository  extends JpaRepository<Services_list, Integer> {
}
