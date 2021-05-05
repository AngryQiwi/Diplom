package com.oblom.DiplomServer.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Self_employeed")
public class Self_employeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int self_employeed_id;
    @Column
    private String l_name;
    @Column
    private String f_name;
    @Column
    private String m_name;
    @Column
    private Date birthdate;
    @Column
    private int itn;
    @Column
    private long card_number;
    @Column
    private long phone;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    private Categories category;
    @Column
    private String brief;
    @Column
    private double rating;
    @Column
    private String photo;

    public int getSelf_employeed_id() {
        return self_employeed_id;
    }

    public void setSelf_employeed_id(int self_employeed_id) {
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

    public int getItn() {
        return itn;
    }

    public void setItn(int itn) {
        this.itn = itn;
    }

    public long getCard_number() {
        return card_number;
    }

    public void setCard_number(long card_number) {
        this.card_number = card_number;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Self_employeed(int self_employeed_id, String l_name, String f_name, String m_name, Date birthdate, int itn, long card_number, long phone, Categories category, String brief, double rating, String photo) {
        this.self_employeed_id = self_employeed_id;
        this.l_name = l_name;
        this.f_name = f_name;
        this.m_name = m_name;
        this.birthdate = birthdate;
        this.itn = itn;
        this.card_number = card_number;
        this.phone = phone;
        this.category = category;
        this.brief = brief;
        this.rating = rating;
        this.photo = photo;
    }
}
