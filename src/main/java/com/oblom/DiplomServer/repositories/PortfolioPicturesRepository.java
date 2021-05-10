package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Payment;
import com.oblom.DiplomServer.entities.Portfolio_pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioPicturesRepository  extends JpaRepository<Portfolio_pictures, Integer> {
    @Query(value = "select portfolio_pictures.* from portfolio_pictures, self_employeed where portfolio_pictures.self_employeed_id = self_employeed.self_employeed_id", nativeQuery = true)
    List<Portfolio_pictures> findAllBySelfEmployeedId(int self_employeed_id);
}
