package com.oblom.DiplomServer.entities;

import javax.persistence.*;

@Entity
@Table(name = "Payment_description")
public class Payment_description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_description_id;

    @Column
    private Integer payment_id;

    @Column
    private Integer service_id;

    public Integer getPayment_description_id() {
        return payment_description_id;
    }

    public void setPayment_description_id(Integer payment_description_id) {
        this.payment_description_id = payment_description_id;
    }

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Payment_description(int payment_description_id, Integer payment_id, Integer service_id) {
        this.payment_description_id = payment_description_id;
        this.payment_id = payment_id;
        this.service_id = service_id;
    }

    public Payment_description() {
    }

    @Override
    public String toString() {
        return "Payment_description{" +
                "payment_description_id=" + payment_description_id +
                ", payment=" + payment_id +
                ", services_list=" + service_id +
                '}';
    }
}
