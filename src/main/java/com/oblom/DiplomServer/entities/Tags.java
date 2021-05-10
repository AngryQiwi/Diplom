package com.oblom.DiplomServer.entities;

import javax.persistence.*;

@Entity
@Table(name = "Tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tag_id;

    @Column
    private Integer self_employeed_id;

    @Column
    private String tag_name;

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public Tags(int tag_id, Integer self_employeed_id, String tag_name) {
        this.tag_id = tag_id;
        this.self_employeed_id = self_employeed_id;
        this.tag_name = tag_name;
    }

    public Tags() {
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tag_id=" + tag_id +
                ", self_employeed=" + self_employeed_id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
