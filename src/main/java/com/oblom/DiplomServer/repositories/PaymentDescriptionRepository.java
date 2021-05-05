package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Payment_description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDescriptionRepository  extends JpaRepository<Payment_description, Integer> {
}
