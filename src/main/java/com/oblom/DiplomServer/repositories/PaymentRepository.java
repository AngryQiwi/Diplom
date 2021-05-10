package com.oblom.DiplomServer.repositories;

import com.oblom.DiplomServer.entities.Categories;
import com.oblom.DiplomServer.entities.Favorites;
import com.oblom.DiplomServer.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
    @Query(value = "select payment.* from payment, customer where payment.customer_id = customer.customer_id", nativeQuery = true)
    List<Payment> findAllByCustomerId(int customer_id);
    @Query(value = "select payment.* from payment, self_employeed where payment.self_employeed_id = self_employeed.self_employeed_id", nativeQuery = true)
    List<Payment> findAllBySelfEmployeedId(int self_employeed_id);


}
