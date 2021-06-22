package com.oblom.DiplomServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Self_employeed")
public class Self_employeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer self_employeed_id;
    @Column
    private String l_name;
    @Column
    private String f_name;
    @Column
    private String m_name;
    @Column
    private Date birthdate;
    @Column
    private Long itn;
    @Column
    private Long card_number;
    @Column
    private Long phone;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categories categories;
    @Column
    private String brief;
    @Column
    private Double rating;
    @Column
    private String photo;
    @Column
    private String password;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Role role;
    @Column
    private String email;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed")
    private Set<Tags> tags;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed")
    private Set<Services_list> services;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed")
    private Set<Self_employeed_social_networks> self_employeed_social_networks;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed")
    private Set<Payment> payments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed")
    private Set<Portfolio_pictures> portfolio_pictures;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed")
    private Set<Favorites> favorites;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(Integer self_employeed_id) {
        this.self_employeed_id = self_employeed_id;
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

    public Long getItn() {
        return itn;
    }

    public void setItn(Long itn) {
        this.itn = itn;
    }

    public Long getCard_number() {
        return card_number;
    }

    public void setCard_number(Long card_number) {
        this.card_number = card_number;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Self_employeed(Integer self_employeed_id, String l_name, String f_name, String m_name, Date birthdate, Long itn, Long card_number, Long phone, Categories categories, String brief, Double rating, String photo, String password, Role role, String email, Set<Tags> tags, Set<Services_list> services, Set<Self_employeed_social_networks> self_employeed_social_networks, Set<Payment> payments, Set<Portfolio_pictures> portfolio_pictures, Set<Favorites> favorites) {
        this.self_employeed_id = self_employeed_id;
        this.l_name = l_name;
        this.f_name = f_name;
        this.m_name = m_name;
        this.birthdate = birthdate;
        this.itn = itn;
        this.card_number = card_number;
        this.phone = phone;
        this.categories = categories;
        this.brief = brief;
        this.rating = rating;
        this.photo = photo;
        this.password = password;
        this.role = role;
        this.email = email;
        this.tags = tags;
        this.services = services;
        this.self_employeed_social_networks = self_employeed_social_networks;
        this.payments = payments;
        this.portfolio_pictures = portfolio_pictures;
        this.favorites = favorites;
    }

    public Self_employeed(String l_name, String f_name, String m_name, Date birthdate, Long itn, Long card_number, Long phone, Categories categories, String brief, Double rating, String email) {
        this.l_name = l_name;
        this.f_name = f_name;
        this.m_name = m_name;
        this.birthdate = birthdate;
        this.itn = itn;
        this.card_number = card_number;
        this.phone = phone;
        this.categories = categories;
        this.brief = brief;
        this.rating = rating;
        this.email = email;
    }

    public Self_employeed() {
    }

    @Override
    public String toString() {
        return "Self_employeed{" +
                "self_employeed_id=" + self_employeed_id +
                ", l_name='" + l_name + '\'' +
                ", f_name='" + f_name + '\'' +
                ", m_name='" + m_name + '\'' +
                ", birthdate=" + birthdate +
                ", itn=" + itn +
                ", card_number=" + card_number +
                ", phone=" + phone +
                ", brief='" + brief + '\'' +
                ", rating=" + rating +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
