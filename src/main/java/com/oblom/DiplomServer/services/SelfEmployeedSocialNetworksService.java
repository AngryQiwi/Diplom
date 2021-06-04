package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Self_employeed_social_networks;
import com.oblom.DiplomServer.repositories.SelfEmployeedSocialNetworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SelfEmployeedSocialNetworksService {
    @Autowired
    private final SelfEmployeedSocialNetworksRepository selfEmployeedSocialNetworksRepository;

    public SelfEmployeedSocialNetworksService(SelfEmployeedSocialNetworksRepository selfEmployeedSocialNetworksRepository) {
        this.selfEmployeedSocialNetworksRepository = selfEmployeedSocialNetworksRepository;
    }
    public List<Self_employeed_social_networks> readAll() {
        return selfEmployeedSocialNetworksRepository.findAll();
    }
    public Self_employeed_social_networks read(int id){
        return selfEmployeedSocialNetworksRepository.findById(id).get();
    }

    public void create(Self_employeed_social_networks self_employeed_social_networks) {
        selfEmployeedSocialNetworksRepository.save(self_employeed_social_networks);
    }

    public boolean delete(int id) {
        if(selfEmployeedSocialNetworksRepository.existsById(id)) {
            selfEmployeedSocialNetworksRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Self_employeed_social_networks self_employeed_social_networks){
        if(selfEmployeedSocialNetworksRepository.existsById(id)) {
            self_employeed_social_networks.setSelf_employeed_social_network_id(id);
            selfEmployeedSocialNetworksRepository.save(self_employeed_social_networks);
            return true;
        }
        return false;
    }
    public List<Self_employeed_social_networks> readAllBySelfEmployeedId(int id) {
        return selfEmployeedSocialNetworksRepository.findAllBySelfEmployeedId(id);
    }
}
