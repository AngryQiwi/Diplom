package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Services_list;
import com.oblom.DiplomServer.repositories.ServicesListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicesListService {
    @Autowired
    private final ServicesListRepository servicesListRepository;

    public ServicesListService(ServicesListRepository servicesListRepository) {
        this.servicesListRepository = servicesListRepository;
    }
    public List<Services_list> readAll() {
        return servicesListRepository.findAll();
    }
    public Services_list read(int id){
        return servicesListRepository.getOne(id);
    }

    public void create(Services_list services_list) {
        servicesListRepository.save(services_list);
    }

    public boolean delete(int id) {
        if(servicesListRepository.existsById(id)) {
            servicesListRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Services_list services_list){
        if(servicesListRepository.existsById(id)) {
            services_list.setService_id(id);
            servicesListRepository.save(services_list);
            return true;
        }
        return false;
    }
    public List<Services_list> readAllBySelfEmployeedId(int id) {
        return servicesListRepository.findAllBySelfEmployeedId(id);
    }
}
