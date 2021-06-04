package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Social_networks;
import com.oblom.DiplomServer.repositories.SocialNetworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SocialNetworksService {
    @Autowired
    private final SocialNetworksRepository socialNetworksRepository;

    public SocialNetworksService(SocialNetworksRepository socialNetworksRepository) {
        this.socialNetworksRepository = socialNetworksRepository;
    }
    public List<Social_networks> readAll() {
        return socialNetworksRepository.findAll();
    }
    public Social_networks read(int id){
        return socialNetworksRepository.findById(id).get();
    }

    public void create(Social_networks social_networks) {
        socialNetworksRepository.save(social_networks);
    }

    public boolean delete(int id) {
        if(socialNetworksRepository.existsById(id)) {
            socialNetworksRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Social_networks social_networks){
        if(socialNetworksRepository.existsById(id)) {
            social_networks.setSocial_network_id(id);
            socialNetworksRepository.save(social_networks);
            return true;
        }
        return false;
    }
}
