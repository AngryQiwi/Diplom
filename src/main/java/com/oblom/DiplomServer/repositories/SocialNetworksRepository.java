package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Social_networks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialNetworksRepository  extends JpaRepository<Social_networks, Integer> {
}
