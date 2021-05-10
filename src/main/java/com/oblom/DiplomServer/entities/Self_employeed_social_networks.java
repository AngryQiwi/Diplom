package com.oblom.DiplomServer.entities;

import javax.persistence.*;

@Entity
@Table(name = "Self_employeed_social_networks")
public class Self_employeed_social_networks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer self_employeed_social_network_id;

    @Column
    private Integer self_employeed_id;

    @Column
    private Integer social_networks_id;

    @Column
    private String social_network_url;

    public Integer getSelf_employeed_social_network_id() {
        return self_employeed_social_network_id;
    }

    public void setSelf_employeed_social_network_id(Integer self_employeed_social_network_id) {
        this.self_employeed_social_network_id = self_employeed_social_network_id;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
    }

    public Integer getSocial_networks_id() {
        return social_networks_id;
    }

    public void setSocial_networks_id(Integer social_networks_id) {
        this.social_networks_id = social_networks_id;
    }

    public String getSocial_network_url() {
        return social_network_url;
    }

    public void setSocial_network_url(String social_network_url) {
        this.social_network_url = social_network_url;
    }

    public Self_employeed_social_networks(int self_employeed_social_network_id, Integer self_employeed_id, Integer social_networks_id, String social_network_url) {
        this.self_employeed_social_network_id = self_employeed_social_network_id;
        this.self_employeed_id = self_employeed_id;
        this.social_networks_id = social_networks_id;
        this.social_network_url = social_network_url;
    }

    public Self_employeed_social_networks() {
    }

    @Override
    public String toString() {
        return "Self_employeed_social_networks{" +
                "self_employeed_social_network_id=" + self_employeed_social_network_id +
                ", self_employeed=" + self_employeed_id +
                ", social_networks=" + social_networks_id +
                ", social_network_url='" + social_network_url + '\'' +
                '}';
    }
}
