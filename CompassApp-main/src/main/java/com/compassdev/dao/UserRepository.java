package com.compassdev.dao;

import com.compassdev.model.CompassAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CompassAppUser, Long> {
    CompassAppUser findByUsername(String username);
}
