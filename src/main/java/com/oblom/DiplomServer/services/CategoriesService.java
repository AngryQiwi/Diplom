package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoriesService {
    @Autowired
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Categories> readAll() {
        return categoriesRepository.findAll();
    }
    public Categories read(int id){
        return categoriesRepository.getOne(id);
    }

    public void create(Categories category) {
        categoriesRepository.save(category);
    }

    public boolean delete(int id) {
        if(categoriesRepository.existsById(id)) {
            categoriesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Categories category){
        if(categoriesRepository.existsById(id)) {
            category.setCategory_id(id);
            categoriesRepository.save(category);
            return true;
        }
        return false;
    }
}
