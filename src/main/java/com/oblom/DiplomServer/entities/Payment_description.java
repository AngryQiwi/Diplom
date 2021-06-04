package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Payment_description")
public class Payment_description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_description_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Services_list services_list;

    public Integer getPayment_description_id() {
        return payment_description_id;
    }

    public void setPayment_description_id(Integer payment_description_id) {
        this.payment_description_id = payment_description_id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Services_list getServices_list() {
        return services_list;
    }

    public void setServices_list(Services_list services_list) {
        this.services_list = services_list;
    }

    public Payment_description(int payment_description_id, Payment payment, Services_list services_list) {
        this.payment_description_id = payment_description_id;
        this.payment = payment;
        this.services_list = services_list;
    }

    public Payment_description() {
    }

    @Override
    public String toString() {
        return "Payment_description{" +
                "payment_description_id=" + payment_description_id +
                '}';
    }
}
