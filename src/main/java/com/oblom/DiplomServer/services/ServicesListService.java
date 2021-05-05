package com.oblom.DiplomServer.services;

import javax.persistence.*;

@Entity
@Table(name = "Services_list")
public class ServicesListService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "self_employeed_id")
    private SelfEmployeedService self_employeed;
    @Column
    private String service_name;
    @Column
    private String service_description;
    @Column
    private double price;

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public SelfEmployeedService getSelf_employeed() {
        return self_employeed;
    }

    public void setSelf_employeed(SelfEmployeedService self_employeed) {
        this.self_employeed = self_employeed;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ServicesListService(int service_id, SelfEmployeedService self_employeed, String service_name, String service_description, double price) {
        this.service_id = service_id;
        this.self_employeed = self_employeed;
        this.service_name = service_name;
        this.service_description = service_description;
        this.price = price;
    }
}
