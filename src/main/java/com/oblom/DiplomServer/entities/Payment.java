package com.oblom.DiplomServer.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;

    @Column
    private Integer self_employeed_id;

    @Column
    private Integer customer_id;

    @Column
    private Double amount;

    @Column
    private Date date;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payment_id")
    private Set<Payment_description> payment_descriptions;


    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date birthdate) {
        this.date = birthdate;
    }

    public Payment(int payment_id, Integer self_employeed_id, Integer customer_id, double amount, Date date, Set<Payment_description> payment_descriptions) {
        this.payment_id = payment_id;
        this.self_employeed_id = self_employeed_id;
        this.customer_id = customer_id;
        this.amount = amount;
        this.date = date;
        this.payment_descriptions = payment_descriptions;
    }

    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", self_employeed=" + self_employeed_id +
                ", customer=" + customer_id +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
