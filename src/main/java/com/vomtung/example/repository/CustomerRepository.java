package com.vomtung.example.repository;

import com.vomtung.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM Customer u where u.userName = ?1 and u.password = ?2 ")
    Optional login(String username, String password);
    Optional findByToken(String token);
}
