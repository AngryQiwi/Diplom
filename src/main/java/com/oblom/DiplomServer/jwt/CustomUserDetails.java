package com.oblom.DiplomServer.jwt;

import com.oblom.DiplomServer.entities.Customer;
import com.oblom.DiplomServer.entities.Role;
import com.oblom.DiplomServer.entities.Self_employeed;
import com.oblom.DiplomServer.services.CustomerService;
import com.oblom.DiplomServer.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomUserDetails fromCustomerToCustomUserDetails(Customer customer) {
        CustomUserDetails c = new CustomUserDetails();
        c.login = customer.getEmail();
        c.password = customer.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(customer.getRole().getName()));
        return c;
    }
    public static CustomUserDetails fromSelfEmployeedToCustomUserDetails(Self_employeed self_employeed) {
        CustomUserDetails c = new CustomUserDetails();
        c.login = self_employeed.getEmail();
        c.password = self_employeed.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(self_employeed.getRole().getName()));
        return c;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
