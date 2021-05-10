package com.oblom.DiplomServer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Services_list")
public class Services_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_id;
    @Column
    private Integer self_employeed_id;
    @Column
    private String service_name;
    @Column
    private String service_description;
    @Column
    private Float price;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service_id")
    private Set<Payment_description> payment_descriptions;

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Services_list(int service_id, Integer self_employeed_id, String service_name, String service_description, Float price, Set<Payment_description> payment_descriptions) {
        this.service_id = service_id;
        this.self_employeed_id = self_employeed_id;
        this.service_name = service_name;
        this.service_description = service_description;
        this.price = price;
        this.payment_descriptions = payment_descriptions;
    }

    public Services_list() {
    }

    @Override
    public String toString() {
        return "Services_list{" +
                "service_id=" + service_id +
                ", self_employeed=" + self_employeed_id +
                ", service_name='" + service_name + '\'' +
                ", service_description='" + service_description + '\'' +
                ", price=" + price +
                '}';
    }
}
