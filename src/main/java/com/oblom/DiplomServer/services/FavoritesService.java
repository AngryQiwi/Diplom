package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Favorites;
import com.oblom.DiplomServer.repositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FavoritesService {
    @Autowired
    private final FavoritesRepository favoritesRepository;

    public FavoritesService(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }
    public List<Favorites> readAll() {
        return favoritesRepository.findAll();
    }
    public Favorites read(int id){
        return favoritesRepository.findById(id).get();
    }

    public void create(Favorites favorites) {
        favoritesRepository.save(favorites);
    }

    public boolean delete(int id) {
        if(favoritesRepository.existsById(id)) {
            favoritesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Favorites favorites){
        if(favoritesRepository.existsById(id)) {
            favorites.setFavorite_id(id);
            favoritesRepository.save(favorites);
            return true;
        }
        return false;
    }
    public List<Favorites> readAllForCustomer(int id) {
        return favoritesRepository.findAllBySelfEmployeedId(id);
    }
    public List<Favorites> readAllForSelfEmployeed(int id) {
        return favoritesRepository.findAllByCustomerId(id);
    }

}
