package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository  extends JpaRepository<Favorites, Integer> {
}
