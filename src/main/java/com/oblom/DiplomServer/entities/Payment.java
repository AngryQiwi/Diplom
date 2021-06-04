package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "self_employeed_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Self_employeed self_employeed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    @Column
    private Double amount;

    @Column
    private Date date;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
    private Set<Payment_description> payment_descriptions;


    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Self_employeed getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(Self_employeed self_employeed) {
        this.self_employeed = self_employeed;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Payment(int payment_id, Self_employeed self_employeed, Customer customer, double amount, Date date, Set<Payment_description> payment_descriptions) {
        this.payment_id = payment_id;
        this.self_employeed = self_employeed;
        this.customer = customer;
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
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
