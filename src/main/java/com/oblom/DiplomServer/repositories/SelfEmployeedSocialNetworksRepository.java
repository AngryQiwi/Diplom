package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Self_employeed_social_networks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelfEmployeedSocialNetworksRepository  extends JpaRepository<Self_employeed_social_networks, Integer> {
}
