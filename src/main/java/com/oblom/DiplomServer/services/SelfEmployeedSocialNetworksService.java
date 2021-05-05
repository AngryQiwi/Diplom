package com.oblom.DiplomServer.services;

import javax.persistence.*;

@Entity
@Table(name = "Self_employeed_social_networks")
public class SelfEmployeedSocialNetworksService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int self_employeed_social_network_id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "self_employeed_id")
    private SelfEmployeedService self_employeed;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "social_network_id")
    private SocialNetworksService social_networks;
    @Column
    private String social_network_url;

    public int getSelf_employeed_social_network_id() {
        return self_employeed_social_network_id;
    }

    public void setSelf_employeed_social_network_id(int self_employeed_social_network_id) {
        this.self_employeed_social_network_id = self_employeed_social_network_id;
    }

    public SelfEmployeedService getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(SelfEmployeedService self_employeed) {
        this.self_employeed = self_employeed;
    }

    public SocialNetworksService getSocial_networks() {
        return social_networks;
    }

    public void setSocial_networks(SocialNetworksService social_networks) {
        this.social_networks = social_networks;
    }

    public String getSocial_network_url() {
        return social_network_url;
    }

    public void setSocial_network_url(String social_network_url) {
        this.social_network_url = social_network_url;
    }

    public SelfEmployeedSocialNetworksService(int self_employeed_social_network_id, SelfEmployeedService self_employeed, SocialNetworksService social_networks, String social_network_url) {
        this.self_employeed_social_network_id = self_employeed_social_network_id;
        this.self_employeed = self_employeed;
        this.social_networks = social_networks;
        this.social_network_url = social_network_url;
    }
}
