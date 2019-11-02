package com.online.estore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String loginName;
    private String password;
    private boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime lastLoginDate;

    @OneToMany
    private Set<UserRole> roles = new HashSet<UserRole>();

    @OneToOne
    private UserDetail userDetails;
}
