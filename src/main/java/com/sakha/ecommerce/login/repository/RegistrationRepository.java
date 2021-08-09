package com.sakha.ecommerce.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakha.ecommerce.login.modal.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer>{

    public User findAllByEmailId(String emailId);
    
    public User findAllByEmailIdAndPassword(String emailId, String password);
    
    public Optional<User> findByEmailId(String userName);
}
