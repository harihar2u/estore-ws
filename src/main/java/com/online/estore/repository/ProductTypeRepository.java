package com.online.estore.repository;

import com.online.estore.model.ProductType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType, Long> {

    @Override
    <S extends ProductType> S save(S s);
}
