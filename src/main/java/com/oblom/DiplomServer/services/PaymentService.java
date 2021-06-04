package com.oblom.DiplomServer.services;

import com.oblom.DiplomServer.entities.Payment;
import com.oblom.DiplomServer.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public List<Payment> readAll() {
        return paymentRepository.findAll();
    }
    public Payment read(int id){
        return paymentRepository.findById(id).get();
    }

    public void create(Payment payment) {
        paymentRepository.save(payment);
    }

    public boolean delete(int id) {
        if(paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean update(int id, Payment payment){
        if(paymentRepository.existsById(id)) {
            payment.setPayment_id(id);
            paymentRepository.save(payment);
            return true;
        }
        return false;
    }
    public List<Payment> readAllBySelfEmployeedId(int id) {
        return paymentRepository.findAllBySelfEmployeedId(id);
    }
    public List<Payment> readAllByCustomerId(int id) {
        return paymentRepository.findAllByCustomerId(id);
    }
}
