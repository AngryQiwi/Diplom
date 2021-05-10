package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Self_employeed_social_networks;
import com.oblom.DiplomServer.entities.Services_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicesListRepository  extends JpaRepository<Services_list, Integer> {
    @Query(value = "select services_list.* from services_list, self_employeed where services_list.self_employeed_id = self_employeed.self_employeed_id", nativeQuery = true)
    List<Services_list> findAllBySelfEmployeedId(int self_employeed_id);
}
