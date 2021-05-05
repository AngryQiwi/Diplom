package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository  extends JpaRepository<Tags, Integer> {
}
