package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Services_list;
import com.oblom.DiplomServer.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagsRepository  extends JpaRepository<Tags, Integer> {
    @Query(value = "select tags.* from tags, self_employeed where tags.self_employeed_id = self_employeed.self_employeed_id", nativeQuery = true)
    List<Tags> findAllBySelfEmployeedId(int self_employeed_id);

}
