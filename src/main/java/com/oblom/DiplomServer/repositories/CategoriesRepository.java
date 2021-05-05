package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
