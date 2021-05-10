package com.oblom.DiplomServer.entities;

import javax.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favorite_id;

    @Column
    private Integer customer_id;

    @Column
    private Integer self_employeed_id;

    public Integer getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(Integer favorite_id) {
        this.favorite_id = favorite_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
    }

    public Favorites(int favorite_id, Integer customer_id, Integer self_employeed_id) {
        this.favorite_id = favorite_id;
        this.customer_id = customer_id;
        this.self_employeed_id = self_employeed_id;
    }

    public Favorites() {
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "favorite_id=" + favorite_id +
                ", customer=" + customer_id +
                ", self_employeed=" + self_employeed_id +
                '}';
    }
}
