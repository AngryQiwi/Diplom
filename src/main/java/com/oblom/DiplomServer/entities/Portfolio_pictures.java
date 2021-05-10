package com.oblom.DiplomServer.entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Portfolio_pictures")
public class Portfolio_pictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer picture_id;

    @Column
    private Integer self_employeed_id;

    @Column
    private Byte[] picture;

    public Integer getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        this.picture_id = picture_id;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    public Portfolio_pictures(int picture_id, Integer self_employeed_id, Byte[] picture) {
        this.picture_id = picture_id;
        this.self_employeed_id = self_employeed_id;
        this.picture = picture;
    }

    public Portfolio_pictures() {
    }

    @Override
    public String toString() {
        return "Portfolio_pictures{" +
                "picture_id=" + picture_id +
                ", self_employeed=" + self_employeed_id +
                ", picture='" + Arrays.toString(picture) + '\'' +
                '}';
    }
}
