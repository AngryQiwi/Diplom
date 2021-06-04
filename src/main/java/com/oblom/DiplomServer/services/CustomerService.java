package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Customer;
import com.oblom.DiplomServer.entities.Self_employeed;
import com.oblom.DiplomServer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Transactional
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }
    @Transactional
    public Customer read(int id){
        return customerRepository.findById(id).get();
    }
    @Transactional
    public void create(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }
    @Transactional
    public boolean delete(int id) {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Transactional
    public Customer findByEmail(String email){
        return customerRepository.findByEmail(email);
    }
    @Transactional
    public Customer findByEmailAndPassword(String email, String password){
        Customer customer = findByEmail(email);
        if(customer!=null){
            if (passwordEncoder.matches(password, customer.getPassword())) {
                return customer;
            }
        }
        return null;
    }
    @Transactional
    public boolean update(int id, Customer customer){
        if(customerRepository.existsById(id)) {
            customer.setCustomer_id(id);
            create(customer);
            return true;
        }
        return false;
    }

}
