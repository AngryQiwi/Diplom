package com.oblom.DiplomServer.services;

import javax.persistence.*;

@Entity
@Table(name = "Portfolio_pictures")
public class PortfolioPicturesService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int picture_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "self_employeed_id")
    private SelfEmployeedService self_employeed;

    @Column
    private String picture;

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public SelfEmployeedService getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(SelfEmployeedService self_employeed) {
        this.self_employeed = self_employeed;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public PortfolioPicturesService(int picture_id, SelfEmployeedService self_employeed, String picture) {
        this.picture_id = picture_id;
        this.self_employeed = self_employeed;
        this.picture = picture;
    }
}
