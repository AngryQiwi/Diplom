package com.oblom.DiplomServer.services;

import javax.persistence.*;

@Entity
@Table(name = "Tags")
public class TagsService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tag_id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "self_employeed_id")
    private SelfEmployeedService self_employeed;
    @Column
    private String tag_name;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public SelfEmployeedService getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(SelfEmployeedService self_employeed) {
        this.self_employeed = self_employeed;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public TagsService(int tag_id, SelfEmployeedService self_employeed, String tag_name) {
        this.tag_id = tag_id;
        this.self_employeed = self_employeed;
        this.tag_name = tag_name;
    }
}
