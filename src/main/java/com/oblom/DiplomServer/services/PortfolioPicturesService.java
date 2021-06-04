package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Portfolio_pictures;
import com.oblom.DiplomServer.repositories.PortfolioPicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PortfolioPicturesService {
    @Autowired
    private final PortfolioPicturesRepository portfolioPicturesRepository;

    public PortfolioPicturesService(PortfolioPicturesRepository portfolioPicturesRepository) {
        this.portfolioPicturesRepository = portfolioPicturesRepository;
    }
    public List<Portfolio_pictures> readAll() {
        return portfolioPicturesRepository.findAll();
    }
    public Portfolio_pictures read(int id){
        return portfolioPicturesRepository.findById(id).get();
    }

    public void create(Portfolio_pictures portfolio_pictures) {
        portfolioPicturesRepository.save(portfolio_pictures);
    }

    public boolean delete(int id) {
        if(portfolioPicturesRepository.existsById(id)) {
            portfolioPicturesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Portfolio_pictures portfolio_pictures){
        if(portfolioPicturesRepository.existsById(id)) {
            portfolio_pictures.setPicture_id(id);
            portfolioPicturesRepository.save(portfolio_pictures);
            return true;
        }
        return false;
    }
    public List<Portfolio_pictures> readAllBySelfEmployeedId(int id) {
        return portfolioPicturesRepository.findAllBySelfEmployeedId(id);
    }

}
