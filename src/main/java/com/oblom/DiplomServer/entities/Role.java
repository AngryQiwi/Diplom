package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<Customer> customers;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<Self_employeed> self_employeeds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(Integer id, String name, Set<Customer> customers, Set<Self_employeed> self_employeeds) {
        this.id = id;
        this.name = name;
        this.customers = customers;
        this.self_employeeds = self_employeeds;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
