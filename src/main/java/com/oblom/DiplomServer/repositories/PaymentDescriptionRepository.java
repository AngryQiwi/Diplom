package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Favorites;
import com.oblom.DiplomServer.entities.Payment_description;
import com.oblom.DiplomServer.entities.Self_employeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDescriptionRepository  extends JpaRepository<Payment_description, Integer> {
    @Query(value = "select payment_description.* from payment_description, payment where payment_description.payment_id = payment.payment_id", nativeQuery = true)
    List<Payment_description> findAllByPaymentId(int payment_id);
}
