package com.sakha.ecommerce.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sakha.ecommerce.login.modal.User;
import com.sakha.ecommerce.login.repository.RegistrationRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private RegistrationRepository registrationRepository;
    
    
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> user =  registrationRepository.findByEmailId(userName);
        
        
        user.orElseThrow(() -> new UsernameNotFoundException("user name not able to find: "+userName));
        
        return user.map(MyUserDetails::new).get();
//        return new MyUserDetails(user);
    }

}
