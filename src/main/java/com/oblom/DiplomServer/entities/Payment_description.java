package com.oblom.DiplomServer.entities;

import javax.persistence.*;

@Entity
@Table(name = "Payment_description")
public class Payment_description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_description_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "service_id")
    private Services_list services_list;

    public int getPayment_description_id() {
        return payment_description_id;
    }

    public void setPayment_description_id(int payment_description_id) {
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
}
