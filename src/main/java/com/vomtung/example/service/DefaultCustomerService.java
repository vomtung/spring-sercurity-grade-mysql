package com.vomtung.example.service;

import com.vomtung.example.entity.User;
import com.vomtung.example.repository.CustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service("customerService")
public class DefaultCustomerService implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String login(String username, String password) {
        Optional customer = customerRepository.login(username,password);
        if(customer.isPresent()){
            String token = UUID.randomUUID().toString();
            User custom= (User) customer.get();
            custom.setToken(token);
            customerRepository.save(custom);
            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional findByToken(String token) {
        Optional customer= customerRepository.findByToken(token);
        if(customer.isPresent()){
            User customer1 = ((User)customer.get());
            org.springframework.security.core.userdetails.User user= new org.springframework.security.core.userdetails.User(customer1.getUserName(), customer1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }
}
