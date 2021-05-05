package com.oblom.DiplomServer.services;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class PaymentService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "self_employeed_id")
    private SelfEmployeedService self_employeed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "customer_id")
    private CustomerService customer;

    @Column
    private double money;

    @Column
    private Date birthdate;

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public SelfEmployeedService getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(SelfEmployeedService self_employeed) {
        this.self_employeed = self_employeed;
    }

    public CustomerService getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerService customer) {
        this.customer = customer;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public PaymentService(int payment_id, SelfEmployeedService self_employeed, CustomerService customer, double money, Date birthdate) {
        this.payment_id = payment_id;
        this.self_employeed = self_employeed;
        this.customer = customer;
        this.money = money;
        this.birthdate = birthdate;
    }
}
