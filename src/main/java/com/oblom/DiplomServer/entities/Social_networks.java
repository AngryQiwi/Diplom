package com.oblom.DiplomServer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Social_networks")
public class Social_networks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer social_network_id;
    @Column
    private String social_network_name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "social_networks_id")
    private Set<Self_employeed_social_networks> self_employeed_social_networks;

    public Integer getSocial_network_id() {
        return social_network_id;
    }

    public void setSocial_network_id(Integer social_network_id) {
        this.social_network_id = social_network_id;
    }

    public String getSocial_network_name() {
        return social_network_name;
    }

    public void setSocial_network_name(String social_network_name) {
        this.social_network_name = social_network_name;
    }

    public Social_networks(int social_network_id, String social_network_name, Set<Self_employeed_social_networks> self_employeed_social_networks) {
        this.social_network_id = social_network_id;
        this.social_network_name = social_network_name;
        this.self_employeed_social_networks = self_employeed_social_networks;
    }

    public Social_networks() {
    }

    @Override
    public String toString() {
        return "Social_networks{" +
                "social_network_id=" + social_network_id +
                ", social_network_name='" + social_network_name + '\'' +
                '}';
    }
}
