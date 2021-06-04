package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Portfolio_pictures")
public class Portfolio_pictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer picture_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "self_employeed_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Self_employeed self_employeed;

    @Column
    private String picture;

    public Integer getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        this.picture_id = picture_id;
    }

    public Self_employeed getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(Self_employeed self_employeed) {
        this.self_employeed = self_employeed;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Portfolio_pictures(int picture_id, Self_employeed self_employeed, String picture) {
        this.picture_id = picture_id;
        this.self_employeed = self_employeed;
        this.picture = picture;
    }

    public Portfolio_pictures() {
    }

    @Override
    public String toString() {
        return "Portfolio_pictures{" +
                "picture_id=" + picture_id +
                ", picture='" + picture + '\'' +
                '}';
    }
}
