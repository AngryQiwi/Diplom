package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Customer;
import com.oblom.DiplomServer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> readAll() {
        return customerRepository.findAll();
    }
    public Customer read(int id){
        return customerRepository.getOne(id);
    }

    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean delete(int id) {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Customer customer){
        if(customerRepository.existsById(id)) {
            customer.setCustomer_id(id);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

}
