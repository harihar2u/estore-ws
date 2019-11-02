package com.online.estore.model;


import lombok.Data;
import org.apache.catalina.filters.AddDefaultCharsetFilter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mobile;
    private String email;

    @OneToMany
    private Set<Address> addresses;

}
