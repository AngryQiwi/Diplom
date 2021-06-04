package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Customer;
import com.oblom.DiplomServer.entities.Self_employeed;
import com.oblom.DiplomServer.repositories.SelfEmployeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SelfEmployeedService {
    @Autowired
    private final SelfEmployeedRepository selfEmployeedRepository;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public SelfEmployeedService(SelfEmployeedRepository selfEmployeedRepository) {
        this.selfEmployeedRepository = selfEmployeedRepository;
    }
    public List<Self_employeed> readAll() {
        return selfEmployeedRepository.findAll();
    }
    public Self_employeed read(int id){
        return selfEmployeedRepository.findById(id).get();
    }

    public void create(Self_employeed self_employeed) {
        self_employeed.setPassword(passwordEncoder.encode(self_employeed.getPassword()));
        selfEmployeedRepository.save(self_employeed);
    }

    public boolean delete(int id) {
        if(selfEmployeedRepository.existsById(id)) {
            selfEmployeedRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Self_employeed self_employeed){
        if(selfEmployeedRepository.existsById(id)) {
            self_employeed.setSelf_employeed_id(id);
            create(self_employeed);
            return true;
        }
        return false;
    }
    public List<Self_employeed> readAllByCategoryId(int id) {
        return selfEmployeedRepository.findAllByCategoryId(id);
    }
    public Self_employeed findByEmail(String email){
        return selfEmployeedRepository.findByEmail(email);
    }
    public Self_employeed findByEmailAndPassword(String email, String password){
        Self_employeed selfEmployeed = findByEmail(email);
        if(selfEmployeed!=null){
            if (passwordEncoder.matches(password, selfEmployeed.getPassword())) {
                return selfEmployeed;
            }
        }
        return null;
    }
}
