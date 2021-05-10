package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Portfolio_pictures;
import com.oblom.DiplomServer.entities.Self_employeed_social_networks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelfEmployeedSocialNetworksRepository  extends JpaRepository<Self_employeed_social_networks, Integer> {
    @Query(value = "select self_employeed_social_networks.* from self_employeed_social_networks, self_employeed where self_employeed_social_networks.self_employeed_id = self_employeed.self_employeed_id", nativeQuery = true)
    List<Self_employeed_social_networks> findAllBySelfEmployeedId(int self_employeed_id);

}
