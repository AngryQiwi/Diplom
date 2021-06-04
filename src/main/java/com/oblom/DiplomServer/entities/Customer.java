package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;
    @Column
    private String l_name;
    @Column
    private String f_name;
    @Column
    private String m_name;
    @Column
    private Date birthdate;
    @Column
    private String email;
    @Column
    private Long phone;
    @Column
    private String photo;
    @Column
    private String password;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Role role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Payment> payments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Favorites> favorites;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer(Integer customer_id, String l_name, String f_name, String m_name, Date birthdate, String email, Long phone, String photo, String password, Role role, Set<Payment> payments, Set<Favorites> favorites) {
        this.customer_id = customer_id;
        this.l_name = l_name;
        this.f_name = f_name;
        this.m_name = m_name;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.password = password;
        this.role = role;
        this.payments = payments;
        this.favorites = favorites;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", l_name='" + l_name + '\'' +
                ", f_name='" + f_name + '\'' +
                ", m_name='" + m_name + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
