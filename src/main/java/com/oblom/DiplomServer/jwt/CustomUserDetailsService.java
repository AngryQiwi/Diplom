package com.oblom.DiplomServer.jwt;

import com.oblom.DiplomServer.entities.Customer;
import com.oblom.DiplomServer.entities.Self_employeed;
import com.oblom.DiplomServer.services.CustomerService;
import com.oblom.DiplomServer.services.SelfEmployeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SelfEmployeedService selfEmployeedService;
    @Transactional
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Self_employeed selfEmployeed = selfEmployeedService.findByEmail(username);
        Customer customer = customerService.findByEmail(username);
        if (selfEmployeed != null) return CustomUserDetails.fromSelfEmployeedToCustomUserDetails(selfEmployeed);
        return CustomUserDetails.fromCustomerToCustomUserDetails(customer);
    }
}
