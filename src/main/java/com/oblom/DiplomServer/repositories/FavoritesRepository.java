package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoritesRepository  extends JpaRepository<Favorites, Integer> {
    @Query(value = "select favorite.* from favorites, customer where favorites.customer_id = customer.customer_id", nativeQuery = true)
    List<Favorites> findAllByCustomerId(int customer_id);
    @Query(value = "select favorite.* from favorites, self_employeed where favorites.self_employeed_id = self_employeed.self_employeed_id", nativeQuery = true)
    List<Favorites> findAllBySelfEmployeedId(int self_employeed_id);
}
