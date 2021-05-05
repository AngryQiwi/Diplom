package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Portfolio_pictures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioPicturesRepository  extends JpaRepository<Portfolio_pictures, Integer> {
}
