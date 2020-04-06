package com.online.estore.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSubType productSubType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Collection<ProductDetail> productDetails;

    @NonNull
    private boolean active;
}
