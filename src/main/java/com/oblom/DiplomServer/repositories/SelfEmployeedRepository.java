package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Customer;
import com.oblom.DiplomServer.entities.Portfolio_pictures;
import com.oblom.DiplomServer.entities.Self_employeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelfEmployeedRepository  extends JpaRepository<Self_employeed, Integer> {
    @Query(value = "select self_employeed.* from self_employeed, categories where self_employeed.category_id = categories.category_id", nativeQuery = true)
    List<Self_employeed> findAllByCategoryId(int category_id);
    Self_employeed findByEmail(String email);

}
