package com.online.estore.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="name"))
public class ProductSubType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "product_type_id", insertable = false, updatable = false)
    private ProductType productType;

    @NonNull
    private String name;
    @NonNull
    private boolean active;


}
