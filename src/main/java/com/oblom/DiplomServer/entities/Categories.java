package com.oblom.DiplomServer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;

    @Column
    private String category_name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Self_employeed> self_employeeds;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Categories(int category_id, String category_name, Set<Self_employeed> self_employeeds) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.self_employeeds = self_employeeds;
    }

    public Categories() {
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
