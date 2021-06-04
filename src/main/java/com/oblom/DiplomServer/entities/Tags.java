package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tag_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "self_employeed_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Self_employeed self_employeed;

    @Column
    private String tag_name;

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public Self_employeed getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(Self_employeed self_employeed) {
        this.self_employeed = self_employeed;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public Tags(int tag_id, Self_employeed self_employeed, String tag_name) {
        this.tag_id = tag_id;
        this.self_employeed = self_employeed;
        this.tag_name = tag_name;
    }

    public Tags() {
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
