package com.compassdev.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
public class CompassAppUser {
    @Id
    private long userid;
    private String username;
    private String password;
    private boolean isactive;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name ="userid"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
