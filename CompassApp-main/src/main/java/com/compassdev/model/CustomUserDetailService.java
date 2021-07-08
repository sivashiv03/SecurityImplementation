package com.compassdev.model;

import com.compassdev.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CompassAppUser user = userRepository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if(user !=null){
            userDetails = new CustomUserDetails();
            userDetails.setCompassAppUser(user);
        } else {
            throw new UsernameNotFoundException("User "+username+" not found");
        }
        return userDetails;
    }
}
