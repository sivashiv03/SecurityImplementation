package com.compassdev.controller;

import com.compassdev.dao.UserRepository;
import com.compassdev.model.CompassAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/addUser")
    public String addUser(@RequestBody CompassAppUser user) {
        String encryptedPwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPwd);
        userRepository.save(user);
        return "User Added Successfully !";

    }

    @GetMapping("/viewAllUsers")
    public List<CompassAppUser> addUser() {
        List<CompassAppUser> usersList = userRepository.findAll();
        return usersList;

    }
}
