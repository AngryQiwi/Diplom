package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Payment_description;
import com.oblom.DiplomServer.repositories.PaymentDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentDescriptionService {
    @Autowired
    private final PaymentDescriptionRepository paymentDescriptionRepository;

    public PaymentDescriptionService(PaymentDescriptionRepository paymentDescriptionRepository) {
        this.paymentDescriptionRepository = paymentDescriptionRepository;
    }

    public void create(Payment_description payment_description) {
        paymentDescriptionRepository.save(payment_description);
    }
    public boolean delete(int id) {
        if(paymentDescriptionRepository.existsById(id)) {
            paymentDescriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Payment_description> readAllByPaymentId(int id) {
        return paymentDescriptionRepository.findAllByPaymentId(id);
    }
}
