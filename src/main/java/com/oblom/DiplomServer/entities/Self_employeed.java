package com.oblom.DiplomServer.entities;

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
    @Column
    private Integer category_id;
    @Column
    private String brief;
    @Column
    private Double rating;
    @Column
    private Byte[] photo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed_id")
    private Set<Tags> tags;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed_id")
    private Set<Services_list> services;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed_id")
    private Set<Self_employeed_social_networks> self_employeed_social_networks;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed_id")
    private Set<Payment> payments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed_id")
    private Set<Portfolio_pictures> portfolio_pictures;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "self_employeed_id")
    private Set<Favorites> favorites;

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

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public Self_employeed(int self_employeed_id, String l_name, String f_name, String m_name, Date birthdate, Long itn, long card_number, long phone, Integer category_id, String brief, double rating, Byte[] photo, Set<Tags> tags, Set<Services_list> services, Set<Self_employeed_social_networks> self_employeed_social_networks, Set<Payment> payments, Set<Portfolio_pictures> portfolio_pictures, Set<Favorites> favorites) {
        this.self_employeed_id = self_employeed_id;
        this.l_name = l_name;
        this.f_name = f_name;
        this.m_name = m_name;
        this.birthdate = birthdate;
        this.itn = itn;
        this.card_number = card_number;
        this.phone = phone;
        this.category_id = category_id;
        this.brief = brief;
        this.rating = rating;
        this.photo = photo;
        this.tags = tags;
        this.services = services;
        this.self_employeed_social_networks = self_employeed_social_networks;
        this.payments = payments;
        this.portfolio_pictures = portfolio_pictures;
        this.favorites = favorites;
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
                ", category=" + category_id +
                ", brief='" + brief + '\'' +
                ", rating=" + rating +
                ", photo='" + Arrays.toString(photo) + '\'' +
                '}';
    }
}
