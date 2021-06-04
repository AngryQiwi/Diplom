package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favorite_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "self_employeed_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Self_employeed self_employeed;

    public Integer getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(Integer favorite_id) {
        this.favorite_id = favorite_id;
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

    public Favorites(int favorite_id, Customer customer, Self_employeed self_employeed) {
        this.favorite_id = favorite_id;
        this.customer = customer;
        this.self_employeed = self_employeed;
    }

    public Favorites() {
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "favorite_id=" + favorite_id +
                '}';
    }
}
