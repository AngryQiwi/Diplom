package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
}
