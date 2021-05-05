package com.oblom.DiplomServer.services;

import javax.persistence.*;

@Entity
@Table(name = "Social_networks")
public class SocialNetworksService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int social_network_id;
    @Column
    private String social_network_name;

    public int getSocial_network_id() {
        return social_network_id;
    }

    public void setSocial_network_id(int social_network_id) {
        this.social_network_id = social_network_id;
    }

    public String getSocial_network_name() {
        return social_network_name;
    }

    public void setSocial_network_name(String social_network_name) {
        this.social_network_name = social_network_name;
    }

    public SocialNetworksService(int social_network_id, String social_network_name) {
        this.social_network_id = social_network_id;
        this.social_network_name = social_network_name;
    }
}
