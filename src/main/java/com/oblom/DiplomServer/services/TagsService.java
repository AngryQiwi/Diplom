package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Tags;
import com.oblom.DiplomServer.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagsService {
    @Autowired
    private final TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }
    public List<Tags> readAll() {
        return tagsRepository.findAll();
    }
    public Tags read(int id){
        return tagsRepository.findById(id).get();
    }

    public void create(Tags tags) {
        tagsRepository.save(tags);
    }

    public boolean delete(int id) {
        if(tagsRepository.existsById(id)) {
            tagsRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Tags tags){
        if(tagsRepository.existsById(id)) {
            tags.setTag_id(id);
            tagsRepository.save(tags);
            return true;
        }
        return false;
    }
    public List<Tags> readAllBySelfEmployeedId(int id) {
        return tagsRepository.findAllBySelfEmployeedId(id);
    }
}
