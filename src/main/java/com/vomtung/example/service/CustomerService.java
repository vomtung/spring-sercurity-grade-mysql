package com.vomtung.example.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("customerService")
public interface CustomerService {

    public String login(String username, String password);

    public Optional findByToken(String token);

}
