package com.sakha.ecommerce.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakha.ecommerce.login.modal.User;
import com.sakha.ecommerce.login.repository.RegistrationRepository;

@Service
public class RegisterationService {

    @Autowired
    private RegistrationRepository registrationRepository;
//    
//    @PersistenceContext
//    private EntityManagerFactory entityManagerFactory;
    
    public User saveUser(User user) {
        return registrationRepository.save(user);
    }
    
    public User fetchUserByEmailId(String emailId) {
        return registrationRepository.findAllByEmailId(emailId);
    }
    
    public User fetchUserByEmailAndPassword(String emailId, String password) {
        
        return registrationRepository.findAllByEmailIdAndPassword(emailId, password);
        
//        if(user != null) {
//            reur
//        }
    }
}
